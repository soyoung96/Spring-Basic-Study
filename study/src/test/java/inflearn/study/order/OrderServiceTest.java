package inflearn.study.order;

import inflearn.study.AppConfig;
import inflearn.study.member.Grade;
import inflearn.study.member.Member;
import inflearn.study.member.MemberService;
import inflearn.study.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){ //테스트 두번 있으면 이게 두번 돈다.
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

//    @Test
//    void fieldInjectionTest(){
//        OrderServiceImpl orderService = new OrderServiceImpl();
//
//        orderService.createOrder(1L,"itemA",10000); //"this.memberRepository" is null -> 이유: 테스트 코드는 순수 자바코드(스프링X)/해결책: orderserviceImpl안에 set을 만들어야 함(필드 주입 단점==DI프레임 워크가 아니면 아무것도 할 수 없다.)
//    }
}
