package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);;

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        //세 개의 스프링 빈이 모두 똑같다. (싱글톤)
        System.out.println("memberService -> memberRepository = " + memberRepository1);
        System.out.println("orderService -> memberRepository2 = " + memberRepository2);
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertThat(memberRepository).isSameAs(memberRepository1);
        Assertions.assertThat(memberRepository).isSameAs(memberRepository2);
    }

    @Test
    void configurationDepp() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean = " + bean.getClass()); // (출력) bean = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$9d75f273
        //순수한 클래스라면 class hello.core.AppConfig 라고 출력되야 한다.
        //이것은 내가 만든 클래스가 아니라, 스프링이 CGLIB라는 바이트코드 조작 라이브러리를 사용해서 AppConfig 클래스를 상속받은 임의의 다른 클래스를 만들고,
        //그 다른 클래스를 스프링 빈으로 등록한 것이다!
        //AppConfig@CGLIB는 AppConfig의 자식 클래스이기 때문에 AppConfig로 조회할 수 있다.
    }
}
