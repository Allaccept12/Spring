package hello.core.order;

import hello.core.discount.DiscountPolycy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolycy discountPolycy;

//    public void setDiscountPolycy(DiscountPolycy discountPolycy) {
//        this.discountPolycy = discountPolycy;
//    }
//
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolycy discountPolycy) {
        this.memberRepository = memberRepository;
        this.discountPolycy = discountPolycy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolycy.discount(member, itemPrice);

        return new Order(memberId, itemName,itemPrice, discountPrice);
    }
    ///테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
