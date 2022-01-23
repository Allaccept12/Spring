import hello.core.discount.FixDiscountPolycy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.Order;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest {


    //순수 자바 코드 테스트
    @Test
    void createOrder() {
        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L,"memberA", Grade.BASIC));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository,new FixDiscountPolycy());
        Order order = orderService.createOrder(1L, "itemA", 10000);

        Assertions.assertThat(order.getMemberId()).isEqualTo(1L);

    }
}
