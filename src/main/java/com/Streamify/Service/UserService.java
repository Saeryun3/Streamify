package com.Streamify.Service;

import com.Streamify.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository();
    @Autowired
    Public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public boolean LoginUser(String Email, String Password) {
        User user = userRepository.findByEmail(Email);
        if(user != null &&  user.getPassword().equals(password)){
            return true;
        } else{
            return false;
        }

        return super.equals(obj);
    }
}
