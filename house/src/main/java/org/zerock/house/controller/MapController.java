package org.zerock.house.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor // 생성자 주입을 위해 추가
public class MapController {

    @Value("${kakao.maps.appkey}") // properties에서 키 주입
    private String kakaoAppKey;

    @GetMapping("/map")
    public String showMapPage(Model model) { // Model 파라미터 추가
        model.addAttribute("kakaoAppKey", kakaoAppKey); // 모델에 키 추가
        return "map/map";
    }
}