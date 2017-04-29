package blog.services;

import blog.models.User;
import blog.forms.LoginForm;
import blog.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Windows 7 on 20-Apr-17.
 */

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User save(User u) { return userRepository.save(u); }

 //   public List<User> findAll() { return userRepository.findAll(); }

   // public void delete(User user) { userRepository.delete(user); }

    public boolean validateLogin(LoginForm user)
    {

        List<User> users = userRepository.findByUsernameAndPasswordHash(user.getUsername(), user.getPassword());


       return users !=null && users.size()>0;
    }


}
