package cookingguide.services;

import cookingguide.models.User;
import cookingguide.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user){
        this.userRepository.save(user);
    }

    public void removeUser(User user){
        this.userRepository.delete(user);
    }

    public User loadUserByUsername(String username){
        return userRepository.findUsersByUsername(username);
    }

    public List<User> findAllUsers(){
        return (List<User>) userRepository.findAll();
    }

}
