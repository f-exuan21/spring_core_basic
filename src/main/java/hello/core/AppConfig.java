package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //바이트코드를 조작하는 CGLIB 기술을 사용해서 싱글톤을 보장
public class AppConfig {

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository() 두 번 호출 -> 싱글톤이 깨지는게 아닌가???

    @Bean
    public MemberService memberService() {
        System.out.println("Call : AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); //생성자 주입 //option + command + m을 누르면 한번에 method refactoring을 할 수 있다.
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("Call : AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("Call : AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
