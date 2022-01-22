package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolycyTest {

    RateDiscountPolycy rateDiscountPolycy = new RateDiscountPolycy();
    @Test
    @DisplayName("VIP는 10% 할인이 적용되야함")
    void vip_ok() {
        //g
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        //w
        int discount = rateDiscountPolycy.discount(member, 10000);
        //t
        Assertions.assertThat(discount).isEqualTo(1000);
    }
    @Test
    @DisplayName("VIP가 아니면 할인 적용이 안되야함")
    void vip_no(){
        //g
        Member member = new Member(1L,"member",Grade.BASIC);
        //w
        int discount = rateDiscountPolycy.discount(member, 10000);
        //t
        Assertions.assertThat(discount).isEqualTo(0);

    }
}