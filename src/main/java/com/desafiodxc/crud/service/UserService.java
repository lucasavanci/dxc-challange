package com.desafiodxc.crud.service;

import java.util.List;
import java.util.Optional;

import com.desafiodxc.crud.model.UserModel;
import com.desafiodxc.crud.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel createUser(UserModel user) {
        UserModel userCreated=userRepository.save(user);
        return userCreated; 
    }

    public List <UserModel> findAllUsers() {
        List <UserModel> users=userRepository.findAll();
        return users;
    }

    public Optional <UserModel> findUserById(Long id) {
        Optional <UserModel> result=userRepository.findById(id);
        return result;
    }

    public void deleteUserById(Long user) {
        Optional <UserModel> userDetails=userRepository.findById(user);

        if(userDetails.isPresent()){
            userRepository.delete(userDetails.get());
        }
    }

    public UserModel updateByUser(Long id, UserModel user) {
        
        Optional<UserModel> userDetails=userRepository.findById(id);

        if(userDetails.isPresent()==false){
            System.out.println("Usuario não existe "+id);
        }

        UserModel dbUser = userDetails.get();
        dbUser.setEmail(user.getEmail());
        dbUser.setName(user.getName());

        UserModel userUpdated=userRepository.save(dbUser);
        return userUpdated;
    }
}
