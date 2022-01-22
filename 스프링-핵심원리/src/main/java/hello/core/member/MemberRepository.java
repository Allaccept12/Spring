package hello.core.member;

public interface MemberRepository {
    //rlsmd
    void save(Member member);
    Member findById(Long memberId);
}
