package inflearn.study.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    public void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);

        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();

    }

    @Configuration
    static class LifeCycleConfig{
//        @Bean(initMethod = "init",destroyMethod = "close") //거이 javax의 어노테이션을 쓰지만, 외부 라이브러리의 경우 코드를 못고치므로 그땐, 이 방법을 사용!
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();//스프링 빈 라이프 사이클: 객체생성 -> 의존관계 주입 (예외: 생성자 주입/나머지 필드,setter주입에서는 어김없이 적용됌)
                                                                //따라서 의존관계 주입 끝나고 그 다음에 초기화 작업 진행되야함 -> 그럼 의존관계 주입 시점은?
                                                                //스프링 의존관계 주입 완료후 스프링 빈에 콜백 메소드로 알려줌+스프링 컨테이너 종료직전 소멸 콜백으로 알려줌

                                                                //스프링 컨테이너 생성->스프링 빈 생성 -> 의존관계 주입->초기화 콜백->사용->소멸전 콜백 ->컨테이너 종료

            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
