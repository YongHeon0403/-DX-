package org.zerock.house.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.house.entity.Room;
import org.zerock.house.entity.RoomImage;
import org.zerock.house.entity.RoomMapDto;
import org.zerock.house.repository.RoomRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {

    private final RoomRepository roomRepository;
    private final ObjectMapper objectMapper;
    private final String uploadPath = "C:/uploads/";

    @Value("${kakao.maps.appkey}")
    private String kakaoAppKey;

    @GetMapping("/new")
    public String newRoomForm(Model model) {
        model.addAttribute("kakaoAppKey", kakaoAppKey);
        return "room/room_form";
    }

    @PostMapping("/new")
    public String saveRoom(@RequestPart("roomData") String roomDataJson,
                           @RequestPart(name = "imageFiles", required = false) List<MultipartFile> imageFiles) throws IOException {

        Room room = objectMapper.readValue(roomDataJson, Room.class);
        List<RoomImage> newImages = new ArrayList<>();

        if (imageFiles != null && !imageFiles.isEmpty()) {
            for (MultipartFile imageFile : imageFiles) {
                if (imageFile == null || imageFile.isEmpty()) {
                    continue;
                }

                String originalFilename = imageFile.getOriginalFilename();
                String savedName;

                // ▼▼▼ [수정] 외부 라이브러리 없이 확장자를 소문자로 변경하는 로직 ▼▼▼
                if (originalFilename != null && originalFilename.contains(".")) {
                    // 파일명과 확장자 분리
                    String baseName = originalFilename.substring(0, originalFilename.lastIndexOf("."));
                    String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
                    // 새로운 파일명 조합
                    savedName = UUID.randomUUID().toString() + "_" + baseName + "." + extension;
                } else {
                    // 확장자가 없는 파일의 경우
                    savedName = UUID.randomUUID().toString() + "_" + (originalFilename != null ? originalFilename : "file");
                }

                File newFile = new File(uploadPath + savedName);
                imageFile.transferTo(newFile);

                RoomImage roomImage = new RoomImage();
                roomImage.setImageName(savedName);
                roomImage.setRoom(room);
                newImages.add(roomImage);
            }
        }

        room.setImages(newImages);
        roomRepository.save(room);

        return "redirect:/map";
    }

    @GetMapping("/{id}")
    public String roomDetail(@PathVariable("id") Long id, Model model) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid room Id:" + id));
        model.addAttribute("room", room);
        return "room/room_detail";
    }

    @PostMapping("/delete/{id}")
    public String deleteRoom(@PathVariable("id") Long id) {
        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid room Id:" + id));

        if (room.getImages() != null && !room.getImages().isEmpty()) {
            for (RoomImage image : room.getImages()) {
                File fileToDelete = new File(uploadPath + image.getImageName());
                if (fileToDelete.exists()) {
                    fileToDelete.delete();
                }
            }
        }
        roomRepository.delete(room);
        return "redirect:/map";
    }

    @ResponseBody
    @Transactional(readOnly = true)
    @GetMapping("/api/rooms")
    public ResponseEntity<List<RoomMapDto>> getRooms(@RequestParam(required = false) String type) {
        try {
            List<Room> rooms;
            if (type == null || type.isEmpty()) {
                rooms = roomRepository.findAll();
            } else {
                rooms = roomRepository.findByType(type);
            }

            List<RoomMapDto> roomDtos = rooms.stream()
                    .map(RoomMapDto::new)
                    .collect(Collectors.toList());

            return ResponseEntity.ok(roomDtos);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}