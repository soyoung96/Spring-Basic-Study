package inflearn.study;

import inflearn.study.member.MemberRepository;
import inflearn.study.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "inflearn.study",
        excludeFilters =  @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
//    @Bean
//    MemberRepository memoryMemberRepository(){
//        return new MemoryMemberRepository();
//    }
}
