package me.qorrbs.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.qorrbs.springbootdeveloper.domain.User;
import me.qorrbs.springbootdeveloper.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    // 사용자 이름(email)으로 사용자 정보를 가져오는 메서드
    @Override
    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException((email)));
    }
}
/*
    스프링 시큐리티에서 사용자 정볼르 가져오는 UserDetailService 인터페이스를 구현합니다.
    (우리가 작성한 클래스 명 : UserDetailService.java)
    필수로 구현해야하는 loadUserByUsername() 메서드를 오버라이딩해서
 */
