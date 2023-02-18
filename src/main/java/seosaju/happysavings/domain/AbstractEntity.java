package seosaju.happysavings.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity {

    @CreationTimestamp
    private Instant creationTime;

    @UpdateTimestamp
    private Instant updateTime;
}
