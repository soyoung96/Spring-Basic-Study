package inflearn.study.order;

import inflearn.study.annotation.MainDiscountPolicy;
import inflearn.study.discount.DiscountPolicy;
import inflearn.study.discount.FixDiscountPolicy;
import inflearn.study.member.Member;
import inflearn.study.member.MemberRepository;
import inflearn.study.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //lombok 사용으로 깔끔하게!!
public class OrderServiceImpl implements OrderService{
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("memberRepository = "+memberRepository);
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = "+discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }

    private final MemberRepository memberRepository; //final 키워드 까지 넣어야 굿 -> 컴파일 에러 발생시켜서 매우 좋다!!
    private final DiscountPolicy discountPolicy;

    @Autowired//생성자가 딱 하나일 떈 자동으로 Autowired 해준다 -> 두개 이상이면 어떤 생성자에 값을 넣어야할 지 몰라서 안됌!
    public OrderServiceImpl(MemberRepository memberRepository, /*@Qualifier("mainDiscountPolicy")*/@MainDiscountPolicy DiscountPolicy discountPolicy) {
        System.out.println("1. OrderServiceImpl 호출");
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return this.memberRepository;
    }
}
