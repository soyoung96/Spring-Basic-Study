package inflearn.study.order;

import inflearn.study.discount.FixDiscountPolicy;
import inflearn.study.member.Grade;
import inflearn.study.member.Member;
import inflearn.study.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {
//    @Test
//    void createOrder(){
//        OrderServiceImpl orderService = new OrderServiceImpl(); // 수정자 주입을 선택하면 컴파일 에러가 안일어난다.
//        orderService.createOrder(1L,"itemA",10000);
//    }

    @Test
    void createOrder(){
        MemoryMemberRepository memberRepository =new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"name", Grade.VIP));
        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new FixDiscountPolicy()); // 생성자 주입을 선택하면 테스트 코드 작성 시 컴파일 에러가 일어남. -> 빠르게 수정 가능!!!
        Order order = orderService.createOrder(1L,"itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
