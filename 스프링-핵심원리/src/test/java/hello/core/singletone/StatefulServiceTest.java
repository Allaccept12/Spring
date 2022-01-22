package hello.core.singletone;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void StatefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA : 사용자A 주문 금액 조회
//        int price = statefulService1.getPrice();
        // 사용자 b가 20000원을 넣었음 에러 -> 객체는 빈에서 싱글톤으로 빈을 등록하기때문에 필드값또한 공유 하기때문에 에러
        Assertions.assertThat(userAPrice).isEqualTo(10000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }


}