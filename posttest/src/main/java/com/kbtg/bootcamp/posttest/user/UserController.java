package com.kbtg.bootcamp.posttest.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin/users")
    public ResponseEntity<String> getLottery() {
        return ResponseEntity.ok().body("\"users\": " + userService.allUserID());
    }

    @PostMapping("/admin/user")
    @PreAuthorize("hasAuthority('Admin_Create')")
    public ResponseEntity<String> addUser(@RequestBody User user){
        return userService.addUser(user);
    }
}
