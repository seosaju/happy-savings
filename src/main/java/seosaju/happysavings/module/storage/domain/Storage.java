package seosaju.happysavings.module.storage.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import seosaju.happysavings.module.happy_memory.domain.HappyMemory;
import seosaju.happysavings.module.member.domain.Member;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

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

    @OneToMany(mappedBy = "storage", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HappyMemory> memories;

    private boolean opened;

    @CreationTimestamp
    private Instant creationTime;

    @Builder
    public Storage(String name, Member owner) {
        changeName(name);
        this.owner = owner;
        this.opened = false;
    }

    public void changeName(String name) {
        if (name.length() > 100) {
            throw new IllegalArgumentException("보관함의 이름은 100자를 넘을 수 없습니다.");
        }

        this.name = name;
    }

    public void open() {
        if (this.opened) {
            throw new IllegalStateException("이미 열려있는 보관함입니다.");
        }

        this.opened = true;
    }
}
