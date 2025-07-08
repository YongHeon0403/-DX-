package org.zerock.house.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.zerock.house.entity.Room;
import org.zerock.house.repository.RoomRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final RoomRepository roomRepository;

    @GetMapping("/")
    public String home(Model model) {
        // 최신순으로 4개의 매물을 가져옵니다.
        Pageable pageable = PageRequest.of(0, 4, Sort.by(Sort.Direction.DESC, "id"));
        List<Room> featuredRooms = roomRepository.findAll(pageable).getContent();

        // 모델에 담아서 뷰로 전달
        model.addAttribute("featuredRooms", featuredRooms);

        return "index";
    }
}