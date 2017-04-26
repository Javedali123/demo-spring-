package blog.services;

/**
 * Created by Windows 7 on 20-Apr-17.
 */

import blog.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    List<Post> findLatest5();
    Post findById(Long id);
    Post create(Post post);
    Post edit(Post post);
    void deleteById(Long id);
}
