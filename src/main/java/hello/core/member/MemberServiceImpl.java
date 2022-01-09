package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    //생성자가 한 개만 있으면 @Autowired 생략 가능
    @Autowired //생성자 호출 -> 호출 시점에 딱 1번만 호출되는 것이 보장됨 -> "불변, 필수" 의존관계에 사용 -> private를 통해 불편, final을 통해 필수를 지킨다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        System.out.println("memberRepository : " + memberRepository.getClass());
    } //개발자는 암묵적으로 매개변수를 갖고 있는 생성자가 있으면 매개변수를 다 채우려한다.

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
