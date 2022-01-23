package hello.core.order;

import hello.core.discount.DiscountPolycy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor  //생성자를 만들어줌
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolycy discountPolycy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolycy.discount(member, itemPrice);
        return new Order(memberId, itemName,itemPrice, discountPrice);
    }
}
