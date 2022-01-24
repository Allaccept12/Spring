package hello.core;

import hello.core.discount.DiscountPolycy;
import hello.core.discount.FixDiscountPolycy;
import hello.core.discount.RateDiscountPolycy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImple;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

//    @Bean
//    //멤버서비스
//    public MemberService memberService(){
//        System.out.println("call AppConfig.memberService");
//        return new MemberServiceImple(getMemberRepository());
//    }
//    @Bean
//    //오더서비스
//    public OrderService orderService(){
//        System.out.println("call AppConfig.orderService");
//        return new OrderServiceImpl(getMemberRepository(), discountPolycy());
//        //return null
//    }
//    @Bean
//    //레파지토리
//    public MemberRepository getMemberRepository() {
//        System.out.println("call AppConfig.getMemberRepository");
//        return new MemoryMemberRepository();
//    }
//    @Bean
//    //할인정책
//    public DiscountPolycy discountPolycy(){
//        return new RateDiscountPolycy();
//    }
}
