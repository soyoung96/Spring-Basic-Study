package inflearn.study.autowired;

import inflearn.study.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    public void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{

        @Autowired(required = false) // noBean1 빈이 없으면 메소드 자체가 호출이 안된다.
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = "+noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){ //noBean에 null값 들어옴
            System.out.println("noBean2 = "+noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){ //noBean3 = Optional.empty 가 들어옴
            System.out.println("noBean3 = "+noBean3);
        }
    }
}
