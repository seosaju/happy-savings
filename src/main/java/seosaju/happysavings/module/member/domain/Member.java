package seosaju.happysavings.module.member.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import seosaju.happysavings.module.storage.domain.Storage;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    private String id;

    private String name;

    private String password;

    @Email
    private String email;

    @CreationTimestamp
    private Instant creationTime;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Storage> storages;

    @Builder
    public Member(String name, String password, String email) {
        this.id = UUID.randomUUID().toString();
        changeName(name);
        changePassword(password);
        this.email = email;
    }

    public void changeName(String name) {

        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름은 반드시 있어야 합니다.");
        }

        this.name = name;
    }

    public void changePassword(String password) {

        if (password.isEmpty()) {
            throw new IllegalArgumentException("비밀번호는 반드시 있어야 합니다.");
        }

        this.password = password;
    }
}
