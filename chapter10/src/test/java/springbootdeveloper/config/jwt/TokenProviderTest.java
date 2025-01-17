package springbootdeveloper.config.jwt;


import io.jsonwebtoken.Jwts;
import me.ahngeunsu.springbootdeveloper.config.jwt.JwtProperties;
import me.ahngeunsu.springbootdeveloper.config.jwt.TokenProvider;
import me.ahngeunsu.springbootdeveloper.domain.User;
import me.ahngeunsu.springbootdeveloper.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Duration;
import java.util.Date;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TokenProviderTest {
    @Autowired
    private TokenProvider tokenProvider;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtProperties jwtProperties;

    // 1. generateToken() 검증 테스트
    @DisplayName("generateToken() : 유저 정보와 만료 기간을 전달해 토큰 생성 가능")
    @Test
    void generateToken(){
        User testUser = userRepository.save(User.builder()
                .email("user@gmail.com")
                .password("test")
                .build());

        String token = tokenProvider.generateToken(testUser, Duration.ofDays(14));

        Long userId = Jwts.parser()
                .setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJws(token)
                .getBody()
                .get("id", Long.class);

        assertThat(userId).isEqualTo(testUser.getId());

    }
    // 2
    @DisplayName("validToken() : 유효한 토큰인 때에 유효성 검증에 성공")
    @Test
    void validToken_valid_Token() {
        // given
        String token = JwtFactory.withDefaultValues().createToken(jwtProperties);

        // when
        boolean result = tokenProvider.validToken(token);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("validToken() : 만료된 토큰일 때 유효성 검증에 실패")
    @Test
    void validToken_invalidToken() {
        // given -> 일부러 default가 아니라 실패하는 token을 생성하기 때문에 위의 메서드와
        String token = JwtFactory.builder()
                .expiration(new Date(new Date().getTime()
                    - Duration.ofDays(7).toMillis()))
                .build()
                .createToken(jwtProperties);

        // when
        boolean result = tokenProvider.validToken(token);

        // then
        assertThat(result).isFalse();
    }
    // 3. getAuthentication() 검증 테스트
    @DisplayName("getAuthentication() : 토큰 기반으로 인증 정보를 가져온다")
    @Test
    void getAuthentication() {
        // given
        String userEmail = "user@gmail.com";
        String token = JwtFactory.builder()
                .subject(userEmail)
                .build()
                .createToken(jwtProperties);
        // when
        Authentication authentication = tokenProvider.getAuthentication(token);

        // then -> 참조 자료형 캐스팅 응용
        assertThat(( (UserDetails) authentication.getPrincipal()).getUsername())
                .isEqualTo(userEmail);
    }

    // 4. getUserId()
    @DisplayName("getUserId() : 토큰으로 유저ID를 가져올 수 있다.")
    @Test
    void getUserId() {
        // given
        Long userId = 1L;
        String token = JwtFactory.builder()
                .claims(Map.of("id", userId))
                .build()
                .createToken(jwtProperties);

        // when
        Long userIdByToken = tokenProvider.getUserId(token);

        //then
        assertThat(userIdByToken).isEqualTo(userId);
    }
}