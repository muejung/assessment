package com.kbtg.bootcamp.posttest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kbtg.bootcamp.posttest.utils.convertObjectToString.convertObjectToString;
import static com.kbtg.bootcamp.posttest.utils.numberValidation.isUserPattern;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<String> allUserID() {
        List<Object[]> users = userRepository.getUserID();
        return convertObjectToString(users);
    }
    public ResponseEntity<String> addUser(User user) {
        if (isUserPattern(user.getUserId())) {
            userRepository.save(user);
            return ResponseEntity.ok("\"userId\": \"" + user.getUserId() + "\"");
        } else {
            return ResponseEntity.badRequest().body("\"UserId must contain 10 digits without spaces\"");
        }
    }
}
