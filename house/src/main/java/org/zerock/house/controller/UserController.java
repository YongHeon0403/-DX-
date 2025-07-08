package org.zerock.house.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.house.entity.User;
import org.zerock.house.repository.UserRepository;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 기존 회원가입 GET 메서드
    @GetMapping("/signup")
    public String signup() {
        return "users/signup_form";
    }

    // 기존 회원가입 POST 메서드
    @PostMapping("/signup")
    public String signup(String username, String password, String password2, Model model) {
        if (!password.equals(password2)) {
            // 비밀번호가 일치하지 않으면 오류 메시지를 모델에 담아 다시 폼으로
            model.addAttribute("error", "2개의 비밀번호가 일치하지 않습니다.");
            return "users/signup_form";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole("USER");
        this.userRepository.save(user);
        return "redirect:/";
    }

    // 기존 로그인 GET 메서드
    @GetMapping("/login")
    public String login() {
        return "users/login_form";
    }

    // --- ▼▼▼ 회원 정보 관련 메서드 추가 ▼▼▼ ---

    // 1. '회원 정보' 클릭 시 비밀번호 확인 페이지로 이동
    @GetMapping("/myinfo")
    public String myinfo() {
        return "myinfo/password_check_form";
    }

    // 2. 비밀번호 확인 처리
    @PostMapping("/myinfo/check")
    public String checkPassword(@AuthenticationPrincipal UserDetails userDetails,
                                @RequestParam String password,
                                RedirectAttributes redirectAttributes) {

        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        if (passwordEncoder.matches(password, user.getPassword())) {
            return "redirect:/user/myinfo/edit"; // 비밀번호 일치
        } else {
            redirectAttributes.addFlashAttribute("error", "비밀번호가 일치하지 않습니다.");
            return "redirect:/user/myinfo"; // 비밀번호 불일치
        }
    }

    // 3. 회원 정보 수정 페이지 표시
    @GetMapping("/myinfo/edit")
    public String myinfoEditForm(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));
        model.addAttribute("user", user);
        return "myinfo/myinfo_edit_form";
    }

    // 4. 비밀번호 업데이트 처리
    @PostMapping("/myinfo/edit")
    @Transactional // DB 변경이 일어나므로 트랜잭션 처리
    public String updatePassword(@AuthenticationPrincipal UserDetails userDetails,
                                 @RequestParam String newPassword,
                                 @RequestParam String confirmPassword,
                                 RedirectAttributes redirectAttributes) {

        if (!newPassword.equals(confirmPassword)) {
            redirectAttributes.addFlashAttribute("error", "새 비밀번호가 일치하지 않습니다.");
            return "redirect:/user/myinfo/edit";
        }

        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다."));

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user); // @Transactional에 의해 변경 감지로 사실 save는 불필요하나 명시적으로 작성

        redirectAttributes.addFlashAttribute("success", "비밀번호가 성공적으로 변경되었습니다.");
        return "redirect:/";
    }
}