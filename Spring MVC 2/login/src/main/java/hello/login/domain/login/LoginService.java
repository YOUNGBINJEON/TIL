package hello.login.domain.login;

import hello.login.domain.member.Member;
import hello.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;


    /**
     *
     * @param loginId
     * @param password
     * @return
     */
    public Member login(String loginId, String password) {

        /*
        Optional<Member> findMemberOptional = memberRepository.findByLoginId(loginId);
        Member member = findMemberOptional.get();
        if(member.getPassword().equals(password)) {
            return member;
        } else {
            return null;
        }*/ //아래의 코드로 간단하게 작성 가능

        return memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);

    }
}
