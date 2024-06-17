package inflearn.study.scan;

import inflearn.study.AppConfig;
import inflearn.study.AutoAppConfig;
import inflearn.study.member.MemberService;
import inflearn.study.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);


//        AppConfig appConfig = ac.getBean(AppConfig.class); //AppConfig 는 제외됌

        System.out.println("orderService.getMemberRepository() = "+orderService.getMemberRepository());
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
