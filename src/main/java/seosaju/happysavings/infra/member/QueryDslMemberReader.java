package seosaju.happysavings.infra.member;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import seosaju.happysavings.domain.member.Member;
import seosaju.happysavings.domain.member.MemberFilter;
import seosaju.happysavings.domain.member.MemberReader;
import seosaju.happysavings.domain.member.QMember;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class QueryDslMemberReader implements MemberReader {

    private final JPAQueryFactory queryFactory;
    QMember member = QMember.member;

    @Override
    public Optional<Member> findMember(MemberFilter memberFilter) {

        return Optional.ofNullable(
                queryFactory.selectFrom(member)
                        .where(
                                idEq(member, memberFilter.getId()),
                                emailEq(member, memberFilter.getEmail())
                        )
                        .fetchOne()
        );
    }

    public BooleanExpression idEq(QMember member, String id) {
        return id == null ? null : member.id.eq(id);
    }

    public BooleanExpression emailEq(QMember member, String email) {
        return email == null ? null : member.email.eq(email);
    }
}
