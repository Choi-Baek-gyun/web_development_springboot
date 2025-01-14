package me.qorrbs.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Article {

    @Id // id 필드를 기본키(PK)로 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false) // 'title'이라는 not null 컬럼과 매핑
    private String title;

    @Column(name = "content", nullable = false) // 'content'이라는 not null 컬럼과 매핑
    private String content;
    @Builder        // 빌더 패턴으로 객체 생성
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

    /*
        @Builder 애너테이션은 롬복에서 지원하는 애너테이션으로, 생성자 위에 입력하면
        빌더 패턴 방식으로 객체 생성 가능

        객체를 유연하고 직관적으로 생성할 수 있기 때문에, 개발자들이 애용하는 '디자인 패턴'
        어느 필드에 어떤 값이 들어가는지 명시적으로 파악할 수 있습니다.

        repository 패키지 -> BlogRepository.java 생성

        SQL statement 입력창에 (SQL 편집기)
        select * from article;
        그리고 Run 눌러서 쿼리 실행
        h2 데이터베이스에 저장된 데이터를 확인할 수 있습니다.
        애플리케이션을 실행하면 자동으로 생성한 엔티티 내용을 바탕으로
        테이블이 생성되고,
        우리가 요청한 POST 요청에 의해 INSERT문이 실행되어
        실제로 데이터가 저장된 겁니다.

        내일(2025-01-09) 안되신 분들 확인할 예정이고,
        내일은 반복작업을 줄여줄 테스트 코드들을 작성하겠습니다.
            - 매번 H2 들어가는게 번거로워서
            test를 이용할 예정
     */
}
