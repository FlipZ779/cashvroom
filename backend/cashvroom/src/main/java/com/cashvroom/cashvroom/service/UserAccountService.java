package com.cashvroom.cashvroom.service;

import com.cashvroom.cashvroom.model.UserAccount;
import com.cashvroom.cashvroom.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserAccount register(UserAccount userAccount) throws Exception{
        if (userAccountRepository.findByEmail(userAccount.getEmail()).isPresent()){
            throw new RuntimeException("email already registered");
        }

        userAccount.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        return userAccountRepository.save(userAccount);
    }

    public UserAccount login(UserAccount loginRequest)throws Exception{
        Optional<UserAccount> userAccountOptional = userAccountRepository.findByEmail(loginRequest.getEmail());

        if (userAccountOptional.isEmpty()){
            throw new RuntimeException("User not found");
        }

        UserAccount userAccount = userAccountOptional.get();

        if (!passwordEncoder.matches(loginRequest.getPassword(), userAccount.getPassword())){
            throw new Exception("Incorrect Password");
        }

        return userAccount;
    }

    public UserAccount updateProfile(Long id, UserAccount updateData)throws Exception{
        UserAccount userAccount = userAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        if (updateData.getName() != null){
            userAccount.setName(updateData.getName());
        }

        if (updateData.getPassword() != null){
            userAccount.setPassword(passwordEncoder.encode(updateData.getPassword()));
        }

        return userAccountRepository.save(userAccount);
    }
}
