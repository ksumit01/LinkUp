package com.LinkUp.Service;

import java.util.List;

import com.LinkUp.Exception.DataIntegrityViolationException;
import com.LinkUp.Exception.InternalServerErrorException;
import com.LinkUp.Exception.NotFoundException;
import com.LinkUp.Exception.ValidationException;
import com.LinkUp.Model.Task;

public interface TaskService {
    Task createTask(Task task) throws ValidationException, DataIntegrityViolationException, InternalServerErrorException;
    Task updateTask(Long taskId, Task task) throws ValidationException, NotFoundException, InternalServerErrorException;
    void deleteTask(Long taskId) throws NotFoundException, InternalServerErrorException;
    Task getTaskById(Long taskId) throws NotFoundException, InternalServerErrorException;
    List<Task> getAllTasks();
}

