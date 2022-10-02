package seosaju.happysavings.module.user.infra;

import org.springframework.data.jpa.repository.JpaRepository;
import seosaju.happysavings.module.user.domain.User;
import seosaju.happysavings.module.user.domain.UserRepository;

public interface JpaUserRepository extends JpaRepository<User, String>, UserRepository {
}
