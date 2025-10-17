package com.cashvroom.cashvroom.controller;

import com.cashvroom.cashvroom.model.UserAccount;
import com.cashvroom.cashvroom.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/users")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserAccount userAccount){
        try{
            UserAccount newUser = userAccountService.register(userAccount);
            return ResponseEntity.ok(newUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserAccount userAccount){
        try {
            UserAccount loggedUser = userAccountService.login(userAccount);
            return ResponseEntity.ok(loggedUser);
        } catch (Exception e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserAccount updateData){
        try {
            UserAccount updatedUser = userAccountService.updateProfile(id, updateData);
            return ResponseEntity.ok(updatedUser);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
