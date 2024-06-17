package inflearn.study;

import inflearn.study.member.Grade;
import inflearn.study.member.Member;
import inflearn.study.member.MemberService;
import inflearn.study.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member findMemember = memberService.findMember(member.getId());
        System.out.println("new member = "+member.getName());
        System.out.println("find member = "+findMemember.getName());
    }
}
