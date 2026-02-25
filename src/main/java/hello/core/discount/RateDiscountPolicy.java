package hello.core.discount;

import org.springframework.stereotype.Component;

import hello.core.member.Grade;
import hello.core.member.Member;

@Component
public class RateDiscountPolicy implements DiscountPolicy {
  @Override
  public int discount(Member member, int price) {
    if (member.getGrade() == Grade.VIP) {
      return (int) (price * 0.1);
    }
    return 0;
  }
}
