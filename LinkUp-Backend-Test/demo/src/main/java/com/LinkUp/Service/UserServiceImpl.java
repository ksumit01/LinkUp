package com.LinkUp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.LinkUp.Exception.DataIntegrityViolationException;
import com.LinkUp.Exception.InternalServerErrorException;
import com.LinkUp.Exception.NotFoundException;
import com.LinkUp.Exception.ValidationException;
import com.LinkUp.Model.User;
import com.LinkUp.Repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public User createUser(User user) throws ValidationException, DataIntegrityViolationException, InternalServerErrorException {
        validateUser(user);

        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("User creation failed due to data integrity violation.");
        } catch (Exception e) {
            throw new InternalServerErrorException("Failed to create user.");
        }
    }

    @Override
    @Transactional
    public User updateUser(Long userId, User updatedUser) throws ValidationException, NotFoundException, InternalServerErrorException {
        validateUser(updatedUser);

        try {
            User existingUser = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found."));
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            // ... update other properties as needed
            
            return userRepository.save(existingUser);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("User not found.");
        } catch (ValidationException e) {
            throw new ValidationException("Validation failed while updating user.");
        } catch (Exception e) {
            throw new InternalServerErrorException("Failed to update user.");
        }
    }

    @Override
    @Transactional
    public void deleteUser(Long userId) throws NotFoundException, InternalServerErrorException {
        try {
            userRepository.deleteById(userId);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("User not found.");
        } catch (Exception e) {
            throw new InternalServerErrorException("Failed to delete user.");
        }
    }

    @Override
    public User getUserById(Long userId) throws NotFoundException, InternalServerErrorException {
        try {
            return userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found."));
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("User not found.");
        } catch (Exception e) {
            throw new InternalServerErrorException("Failed to retrieve user.");
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    private void validateUser(User user) throws ValidationException {
        if (user.getEmail() == null || !user.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new ValidationException("Invalid email format.");
        }
        // Add more validation rules as needed
    }
}
