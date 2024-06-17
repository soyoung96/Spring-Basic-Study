package inflearn.study.member;

import inflearn.study.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach(){ //테스트 두번 있으면 이게 두번 돈다.
        AppConfig appConfig = new AppConfig();
//        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberA",Grade.VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(member.getId());
        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
