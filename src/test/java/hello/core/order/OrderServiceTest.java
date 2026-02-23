package hello.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class OrderServiceTest {
  private final MemberService memberService = new MemberServiceImpl();
  private final OrderService orderService = new OrderServiceImpl();
  @Test
  void createOrder() {
    memberService.join(new Member(1L, "memberA", Grade.VIP));
    memberService.join(new Member(2L, "memberB", Grade.BASIC));
    Order order = orderService.createOrder(1L, "itemA", 10000);

    Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
  }
}
