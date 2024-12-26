import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnit {
    @DisplayName("1+2는 3이다.")
    @Test
    public void junittest(){
        // given : 사전 준비
        int a = 1;
        int b = 2;
        // when : 테스트 실행
        int sum = 3;

        // then : 검즘
        Assertions.assertEquals(sum, a + b);
    }
 /*   @DisplayName("1+2는 4이다.")
    @Test
    public void junitFailedTest() {
        // given : 사전 준비
        int a = 1;
        int b = 3;
        // when : 테스트 실행
        int sum = 3;

        // then : 검즘
        Assertions.assertEquals(sum, a + b);
    }*/
}
/*
    @DisplayName 애너테이션 : 테스트 이름을 명시하는 애너테이션
    @Test 애너테이션을 붙인 메서드는 테스트를 수행하기 위한 메서드가 됨.
        JUnit은 테스트끼리 영향을 주지 않도록 각 테스트를 싱핼할 때마다
        테스트를 위한 객체를 만들고, 테스트 종료 시점에 실행 객체를 소멸시킴.


    .assertEquals() 메서드 : 첫 번째 인수에는 기대하는 값,
        두 번째 인수에는 실제로 검증할 값을 argument로 받습니다.
            -> 근데 이거 안쓸 겁니다.
    test/java 폴더에 JUnitCycleTest.java 파일을 생성

    AssertJ로 검증문 가독성 높이기

        AssertJ는 JUnit과 함꼐 사용해 검증문의 가독성을 높여주는 라이브러리
        예를 들어서 아까 작성한(JUnitTest.java에서)
        Assertions.assertEquals(sum, a + b); 를 보시면 기대값과 비교값이 잘 구분되지 않습니다.

        AssertJ를 사용한 코드 라인
        assertThat(a + b).isEqualTo(sum);
        이 경우 a와 b를 더한 값이 sum과 같아야 한다는 의미로 읽힙니다 -> 영어의 경우예요.

        자주 사용하는 메서드 목록

        1) isEqualTo(A) : A와 같은지 검증
        2) isNotEqualTo(A) : A와 다른지 검증
        3) contains(A) : A를 포함하는지 검증
        4) doesNotContain(A) : A를 미포함하는지 검증
        5) startsWith(A) : 접두사가 A인지 검증
        6) endsWith(A) : 접미사가 A인지 검증
        7) isEmpty(A) : 비어있는 값인지 검증
        8) isNotEmpty() : 비어있지 않은 값인지 검증
        9) isPositive() : 양수인지 검증
        10) isNegative() : 음수인지 검즈
        11) isGreaterThan() : 1보닥 큰 값인지 검증
        12) isLessThan() : 1보다 작은 값인지 검증
        13) isNull : Null인지 검증
        14) isNotNull : Null이 아닌지 검증

        테스트 코드 작성 연습 문제 풀어보기 -> test/java 폴더에 JUnitQuiz.java
 */
