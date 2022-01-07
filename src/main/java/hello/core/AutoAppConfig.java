package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) //Configuration 어노테이션을 가진 파일들 제외(AppConfig를 제외)
)
public class AutoAppConfig {

    /*
    * 수동 빈 등록 vs 자동 빈 등록 -> 수동 빈 등록이 우선 순위를 가지지만, 스트링부트를 통해 실행하면 에러를 던진다.
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    */

}
