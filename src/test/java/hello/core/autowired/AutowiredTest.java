package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        //의존 관계 Member가 스프링 빈에 없을 때

        @Autowired(required = false) //의존 관계가 스프링 빈에 없으면 메소드 자체가 호출이 되지 않는다. required = true(default값) 이면 에러 발생
        public void setNoBean1(Member noBean) {
            System.out.println("noBean1 = " + noBean);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean) { //호출은 되지만 Null이 들어간다.
            System.out.println("noBean2 = " + noBean);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean) { //스프링 빈이 없으면 Optional.empty 값이 들어간다.
            System.out.println("noBean3 = " + noBean);
        }


    }

}
