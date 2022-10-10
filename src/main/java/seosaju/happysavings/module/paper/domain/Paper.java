package seosaju.happysavings.module.paper.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import seosaju.happysavings.module.member.domain.Member;
import seosaju.happysavings.module.storage.domain.Storage;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Paper {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member writer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Storage storage;

    private String contents;

    @CreationTimestamp
    private Instant creationTime;

    @Builder
    public Paper(Member writer, Storage storage, String contents) {
        this.writer = writer;
        this.storage = storage;
        writeContents(contents);
    }

    void writeContents(String contents) {
        if (contents.length() > 1000) {
            throw new IllegalArgumentException("1000자 이상 입력할 수 없습니다.");
        }

        this.contents = contents;
    }
}
