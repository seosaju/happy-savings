package seosaju.happysavings.module.storage.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import seosaju.happysavings.module.user.domain.User;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User owner;

    @CreationTimestamp
    private Instant creationTime;

    @Builder
    public Storage(User owner) {
        this.owner = owner;
    }
}
