package org.zerock.house.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.house.entity.Room;
import org.zerock.house.entity.RoomMapDto;
import org.zerock.house.repository.RoomRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RoomApiController {

    private final RoomRepository roomRepository;

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

            // Room 엔티티 리스트를 RoomMapDto 리스트로 변환
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