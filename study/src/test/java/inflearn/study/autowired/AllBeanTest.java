package inflearn.study.autowired;

import inflearn.study.AutoAppConfig;
import inflearn.study.discount.DiscountPolicy;
import inflearn.study.member.Grade;
import inflearn.study.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

public class AllBeanTest {

    @Test
    void findAllBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(DiscountServiceConfig.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L,"userA", Grade.VIP);

        int discountPrice = discountService.discount(member,10000,"allBeanTest.DiscountPolicy2");

        Assertions.assertThat(discountPrice).isEqualTo(2);
    }

    @ComponentScan
    static class DiscountServiceConfig{

    }


    @Component
    static class DiscountService{

        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> policies) {
            this.policyMap = policyMap;
            this.policies = policies;

            System.out.println("policyMap = "+policyMap);
            System.out.println("policies = "+policies);
        }

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);

            return discountPolicy.discount(member,price);
        }
    }

    @Component
    static class DiscountPolicy1 implements DiscountPolicy{


        @Override
        public int discount(Member member, int price) {
            return 1;
        }
    }

    @Component
    static class DiscountPolicy2 implements DiscountPolicy{


        @Override
        public int discount(Member member, int price) {
            return 2;
        }
    }
}
