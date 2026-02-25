package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // ComponentScan에 의해 스프링 빈에 등록된 객체를 주입해줌
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;

  @Autowired // 자동으로 스프링 빈에 등록된 객체를 주입해줌
  public MemberServiceImpl(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Override
  public void join(Member member) {
    memberRepository.save(member);
  }

  @Override
  public Member findMember(Long memberId) {
    return memberRepository.findById(memberId);
  }
  
}
