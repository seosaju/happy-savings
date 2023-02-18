package seosaju.happysavings.domain.member;

public interface MemberStore {

    Member save(Member member);

    void delete(Member member);
}
