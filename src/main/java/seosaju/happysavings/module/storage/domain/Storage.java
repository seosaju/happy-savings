package seosaju.happysavings.module.storage.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import seosaju.happysavings.module.member.domain.Member;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private Member owner;

    private boolean opened;

    @CreationTimestamp
    private Instant creationTime;

    @Builder
    public Storage(String name, Member owner) {
        setName(name);
        this.owner = owner;
        this.opened = false;
    }

    void setName(String name) {
        if (name.length() > 100) {
            throw new IllegalArgumentException("저장소의 이름은 100자를 넘을 수 없습니다.");
        }

        this.name = name;
    }
}
