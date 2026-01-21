package com.ecommerce.user.Controller;

import com.ecommerce.user.Service.UserService;
import com.ecommerce.user.Dto.UserRequest;
import com.ecommerce.user.Dto.UserResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    //private Logger logger = LoggerFactory.getLogger(UserController.class);
//    private List<User>userList=new ArrayList<>();

    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(userService.fetchAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String id) {
        log.trace("this is Trace Level Request received user with id: " + id);
        log.info("Request received user with id: " + id);
        log.debug("this is Debug Level Request received user with id: " + id);
        log.warn("this is warn Level Request received user with id: " + id);
        log.error("this is error Level Request received user with id: " + id);

        return userService.fetchUser(id).map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest) {
        userService.addUser(userRequest);
        return ResponseEntity.ok("User added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@RequestBody UserRequest updatedUserRequest, @PathVariable String id) {
        boolean updated = userService.updateUser(id, updatedUserRequest);
        if (updated)
            return ResponseEntity.ok("User updated successfully");

        return ResponseEntity.notFound().build();
    }
}
