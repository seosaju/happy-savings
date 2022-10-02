package seosaju.happysavings.module.user.domain;

import java.util.Optional;

public interface UserRepository {

    Optional<User> findByEmail(String email);

    User save(User user);
}