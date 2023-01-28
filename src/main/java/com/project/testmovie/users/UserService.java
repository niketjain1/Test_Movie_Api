package com.project.testmovie.users;

import com.project.testmovie.dtos.CreateUserDto;
import com.project.testmovie.dtos.UserResponseDto;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserResponseDto createUser(CreateUserDto request){
        var user = modelMapper.map(request, UserEntity.class);
        user.setPassword(request.getPassword());
        var savedUser = userRepository.save(user);
        var response =modelMapper.map(savedUser, UserResponseDto.class);
        return response;
    }
}
