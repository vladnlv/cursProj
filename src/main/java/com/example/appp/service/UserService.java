package com.example.appp.service;

import com.example.appp.dto.UserDto;
import com.example.appp.entity.Constants;
import com.example.appp.entity.User;
import com.example.appp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<User> findById(Integer id){
        return userRepository.findById(id);
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
}
