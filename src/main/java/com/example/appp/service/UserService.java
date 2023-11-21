package com.example.appp.service;

import com.example.appp.dto.UserDto;
import com.example.appp.entity.Constants;
import com.example.appp.entity.User;
import com.example.appp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User createUserAsAdmin(UserDto userDto){
        User user = new User(null,userDto.getName(), Constants.ADMIN_TYPE,userDto.getEmail(),userDto.getPassword());
       return userRepository.save(user);
    }
    public User createUserAsClient(UserDto userDto){
        User user = new User(null,userDto.getName(), Constants.CLIENT_TYPE,userDto.getEmail(),userDto.getPassword());
        return userRepository.save(user);
    }
    public User createUserAsManager(UserDto userDto){
        User user = new User(null,userDto.getName(), Constants.MANAGER_TYPE,userDto.getEmail(),userDto.getPassword());
        return userRepository.save(user);
    }

}
