package inflearn.study.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

//        //ThreadA: A사용자 10000원 주문
//        statefulService1.order("userA",10000);
//        //ThreadB: B사용자 20000원 주문
//        statefulService2.order("userB",20000);

        //ThreadA: A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA",10000);
        //ThreadB: B사용자 20000원 주문
        int userBPrice =statefulService2.order("userB",20000);

//        //ThreadA: A사용자가 주문금액 조회
//        int price = statefulService1.getPrice();
//        System.out.println("price = "+price);

        //ThreadA: A사용자가 주문금액 조회
        System.out.println("userAPrice = "+userAPrice);

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

        Assertions.assertThat(userAPrice).isEqualTo(10000);

    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}