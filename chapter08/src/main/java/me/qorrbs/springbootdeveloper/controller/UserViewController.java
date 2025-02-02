package me.qorrbs.springbootdeveloper.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
    /*
        GET 요청으로 /login 경로로 들어오면 login() 메서드가 login.html을,
        마찬가지 요정으로 /signup 경로로 드렁오면 signup() 메서드가 signup.html

        resource/templates에 login.html 생성
     */

    // 로그아웃 관련
    @GetMapping("/logout")
    public String logout (HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());

        return "redirect:/login";

    }


}
