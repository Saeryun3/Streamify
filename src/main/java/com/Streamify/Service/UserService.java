package com.Streamify.Service;

import com.Streamify.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Streamify.Model.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public User getUserById(long ID){
        return userRepository.getUserById(ID);
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public User save(User save){
        save.setIsAdmin(false);
        return userRepository.save(save);
    }
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean LoginUser(String Email, String Password) {
        User user = userRepository.getUserByEmail(Email);
        if(user != null && user.getPassword().equals(Password)) {
            return true;
        } else {
            return false;
        }
    }
}

//@Service
//public class UserService {
//    private UserRepository userRepository();
//    @Autowired
//    Public UserService (UserRepository userRepository){
//        this.userRepository = userRepository;
//    }
//    public boolean LoginUser(String Email, String Password) {
//        User user = userRepository.findByEmail(Email);
//        if(user != null &&  user.getPassword().equals(password)){
//            return true;
//        } else{
//            return false;
//        }
//
//}