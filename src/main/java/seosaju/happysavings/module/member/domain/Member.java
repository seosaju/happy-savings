package seosaju.happysavings.module.member.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    private String id;

    private String name;

    @Email
    private String email;

    @Builder
    public Member(String name, String email) {
        this.id = UUID.randomUUID().toString();
        changeName(name);
        this.email = email;
    }

    public void changeName(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름은 반드시 있어야 합니다.");
        }

        this.name = name;
    }
}
