package blog.services;

/**
 * Created by Windows 7 on 20-Apr-17.
 */

import blog.models.Post;
import blog.models.User;
import blog.repositories.PostRepository;
import blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PostServiceJpaImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return this.postRepository.findAll();
    }

    @Override
    public List<Post> findLatest5() {
        return this.postRepository.findLatest5Posts();
    }

    @Override
    public Post findById(Long id) {
        return this.postRepository.findOne(id);
    }

    @Override
    public Post create(Post u) {

        return this.postRepository.save(u);
    }

    @Override
    public Post edit(Post u) {

        return this.edit(u);
    }

    @Override
    public void delete(Post post) { postRepository.delete(post);

    }
}
