package blog.services;

import blog.models.User;
import blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Windows 7 on 26-Apr-17.
 * Helps us to talk with the database, provides basic crud operations
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User save(User u) { return userRepository.save(u); }
}

