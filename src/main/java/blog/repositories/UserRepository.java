package blog.repositories;

/**
 * Created by Windows 7 on 20-Apr-17.
 */

import blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends
        JpaRepository<User, Long> {

    List<User> findByUsernameAndPasswordHash(String username, String password);

    @Query("SELECT user FROM User user WHERE user.username=?1 and user.passwordHash=?2")
    List<User> checkUserLogin(String username, String password);


}
