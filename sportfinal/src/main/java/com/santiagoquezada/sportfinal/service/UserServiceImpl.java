package com.santiagoquezada.sportfinal.service;

import com.santiagoquezada.sportfinal.model.User;
import com.santiagoquezada.sportfinal.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User saveUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalStateException("El correo electrónico ya existe en la base de datos.");
        }
        return userRepository.save(user);
    }

    @Override
    public String updateUser(Integer id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser!= null) {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            userRepository.save(existingUser);
            return "Se han actualizado datos de la base de datos";
        }
        return "No se pudo actualizar el usuario. El ID no existe.";
    }

    @Override
    public String deleteUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "Se ha eliminado el usuario de la base de datos";
        }
        return "No se pudo eliminar el usuario. El ID no existe.";
    }
}
