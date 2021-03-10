package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.exception.ResourceNotFoundException;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UserController {
     @Autowired
     private UserRepository userRepository ;

     //get all users
     @GetMapping("/users")
     public List<UserModel>getAllUsers() {
          return userRepository.findAll();
     }


     // create user
     @PostMapping("/users")
     public UserModel createUser(@RequestBody UserModel user) {
//          System.out.println("created user: ");
          return userRepository.save(user);
     }

     // get user by id
     @GetMapping("/users/{id}")
     public ResponseEntity<UserModel> getUserById(@PathVariable Integer id) {
          UserModel user = userRepository.findById(id)
                  .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));
          return ResponseEntity.ok(user);
     }

     // update user
     @PutMapping("/users/{id}")
     public ResponseEntity<UserModel> updateUser(@PathVariable Integer id, @RequestBody UserModel userDetails){
          UserModel user = userRepository.findById(id)
                  .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));

          user.setName(userDetails.getName());
          user.setEmail(userDetails.getEmail());
          user.setPassword(userDetails.getPassword());

          UserModel updatedUser = userRepository.save(user);
          return ResponseEntity.ok(updatedUser);
     }

     // delete user
     @DeleteMapping("/users/{id}")
     public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Integer id){
          UserModel user = userRepository.findById(id)
                  .orElseThrow(() -> new ResourceNotFoundException("User not exist with id :" + id));

          userRepository.delete(user);
          Map<String, Boolean> response = new HashMap<>();
          response.put("deleted", Boolean.TRUE);
          return ResponseEntity.ok(response);
     }
}
