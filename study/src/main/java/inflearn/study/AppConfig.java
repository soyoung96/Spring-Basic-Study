package inflearn.study;

import inflearn.study.discount.DiscountPolicy;
import inflearn.study.discount.FixDiscountPolicy;
import inflearn.study.member.MemberRepository;
import inflearn.study.member.MemberService;
import inflearn.study.member.MemberServiceImpl;
import inflearn.study.member.MemoryMemberRepository;
import inflearn.study.order.OrderService;
import inflearn.study.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),discountPolicy());
//        return null;
    }
}
