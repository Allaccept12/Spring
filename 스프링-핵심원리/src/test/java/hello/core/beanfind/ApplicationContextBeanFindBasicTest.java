package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBeanFindBasicTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByname(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImple.class);

    }
    @Test
    @DisplayName("빈 타입으로 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean( MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImple.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByname2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceImple.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImple.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회x")
    void findBeanNamex(){
//        ac.getBean("xxxx",MemberService.class)
//        MemberService xxxx = ac.getBean("xxxx", MemberService.class);
//        assertThrows(NoSuchBeanDefinitionException.class,
//                () -> ac.getBean("xxxx", MemberService.class));
    }
}
