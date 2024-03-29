package seosaju.happysavings.domain.member;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import seosaju.happysavings.domain.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.time.Instant;
import java.util.Collection;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends AbstractEntity implements UserDetails {

    @Id
    private String id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    @Email
    private String email;

    @Builder
    public Member(String username, String password, String email) {
        this.id = UUID.randomUUID().toString();
        changeName(username);
        changePassword(password);
        this.role = MemberRole.USER;
        this.email = email;
    }

    public void changeName(String name) {

        if (name.isEmpty()) {
            throw new IllegalArgumentException("이름은 반드시 있어야 합니다.");
        }

        this.username = name;
    }

    public void changePassword(String password) {

        if (password.isEmpty()) {
            throw new IllegalArgumentException("비밀번호는 반드시 있어야 합니다.");
        }

        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.createAuthorityList(this.role.toString());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
