package com.LinkUp.Service;

import java.util.List;

import com.LinkUp.Exception.DataIntegrityViolationException;
import com.LinkUp.Exception.InternalServerErrorException;
import com.LinkUp.Exception.NotFoundException;
import com.LinkUp.Exception.ValidationException;
import com.LinkUp.Model.User;

public interface UserService {
    User createUser(User user) throws ValidationException, DataIntegrityViolationException, InternalServerErrorException;
    User updateUser(Long userId, User user) throws ValidationException, NotFoundException, InternalServerErrorException;
    void deleteUser(Long userId) throws NotFoundException, InternalServerErrorException;
    User getUserById(Long userId) throws NotFoundException, InternalServerErrorException;
    List<User> getAllUsers();
}


