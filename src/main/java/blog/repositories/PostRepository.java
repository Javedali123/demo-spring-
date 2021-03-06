package blog.repositories;

/**
 * Created by Windows 7 on 20-Apr-17.
 */

import blog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends
        JpaRepository<Post, Long> {
    // finds latest posts and in order by date
    @Query("SELECT p FROM Post p LEFT JOIN FETCH p.author ORDER BY p.date DESC")
    List<Post> findLatest5Posts();
}

