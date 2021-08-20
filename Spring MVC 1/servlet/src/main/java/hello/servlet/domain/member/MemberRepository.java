package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
* */
public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    // 싱글톤 생성시, 아무나 접근 못하도록 프라이빗 생성자 생성
    private MemberRepository() {

    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);

    }

    public List<Member> findAll() {
        // ArrayList의 값을 수정할 때, store.value()의 값에 간섭하지 않기 위함
        return new ArrayList<>(store.values());
    }

    // 테스트에서 Store의 값을 다 날리기위함
    public void clearStore() {
        store.clear();
    }

}
