package seosaju.happysavings.domain.happy_memory;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import seosaju.happysavings.domain.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Storage extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ownerId;

    private String name;

    private boolean opened;

    @Builder
    public Storage(String name, String ownerId) {
        this.ownerId = ownerId;
        changeName(name);
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
