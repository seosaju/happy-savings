package seosaju.happysavings.domain.happy_memory;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import seosaju.happysavings.domain.AbstractEntity;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Memory extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String storageId;

    private String contents;

    @Builder
    public Memory(String storageId, String contents) {
        this.storageId = storageId;
        writeContents(contents);
    }

    void writeContents(String contents) {
        if (contents.length() > 1000) {
            throw new IllegalArgumentException("1000자 이상 입력할 수 없습니다.");
        }

        this.contents = contents;
    }
}
