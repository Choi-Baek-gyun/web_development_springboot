package me.qorrbs.springbootdeveloper;
/*
    혹시나 기능 구현을 했는데 적용되지 않을 경우

    1. 서버 껐다가 킵니다.
    2. 그런데 안되는 경우 ctrl + s 세이브 하시고
    3. intelliJ 껐다가 켭니다.
    4. 서버 재실행합니다.
    5. 그러면 완료되는 경우가 많습니다.
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "Hello World!";
    }
}
/*

 */