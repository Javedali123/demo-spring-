package blog.repositories;

/**
 * Created by Windows 7 on 20-Apr-17.
 */

import blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends
        JpaRepository<User, Long> {
}
