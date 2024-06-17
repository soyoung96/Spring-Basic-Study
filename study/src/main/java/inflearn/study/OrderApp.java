package inflearn.study;

import inflearn.study.member.Grade;
import inflearn.study.member.Member;
import inflearn.study.member.MemberService;
import inflearn.study.member.MemberServiceImpl;
import inflearn.study.order.Order;
import inflearn.study.order.OrderService;
import inflearn.study.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);

        Long memberId=1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);
        System.out.println("order = "+order);
        System.out.println("order.calculate() = "+order.calculate());
    }
}
