package com.LinkUp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LinkUp.Exception.DataIntegrityViolationException;
import com.LinkUp.Exception.InternalServerErrorException;
import com.LinkUp.Exception.NotFoundException;
import com.LinkUp.Exception.ValidationException;
import com.LinkUp.Model.Task;
import com.LinkUp.Repository.TaskRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    @Transactional
    public Task createTask(Task task) throws ValidationException, DataIntegrityViolationException, InternalServerErrorException {
        validateTask(task);

        try {
            return taskRepository.save(task);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Task creation failed due to data integrity violation.");
        } catch (Exception e) {
            throw new InternalServerErrorException("Failed to create task.");
        }
    }

    @Override
    @Transactional
    public Task updateTask(Long taskId, Task updatedTask) throws ValidationException, NotFoundException, InternalServerErrorException {
        validateTask(updatedTask);

        try {
            Task existingTask = taskRepository.findById(taskId).orElseThrow(() -> new NotFoundException("Task not found."));
            // Update task properties here
            existingTask.setTaskTitle(updatedTask.getTaskTitle());
            // ... other properties
            return taskRepository.save(existingTask);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Task not found.");
        } catch (ValidationException e) {
            throw new ValidationException("Validation failed while updating task.");
        } catch (Exception e) {
            throw new InternalServerErrorException("Failed to update task.");
        }
    }

    @Override
    @Transactional
    public void deleteTask(Long taskId) throws NotFoundException, InternalServerErrorException {
        try {
            taskRepository.deleteById(taskId);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Task not found.");
        } catch (Exception e) {
            throw new InternalServerErrorException("Failed to delete task.");
        }
    }

    @Override
    public Task getTaskById(Long taskId) throws NotFoundException, InternalServerErrorException {
        try {
            return taskRepository.findById(taskId).orElseThrow(() -> new NotFoundException("Task not found."));
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Task not found.");
        } catch (Exception e) {
            throw new InternalServerErrorException("Failed to retrieve task.");
        }
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    private void validateTask(Task task) throws ValidationException {
        if (task.getTaskTitle() == null || task.getTaskTitle().isEmpty()) {
            throw new ValidationException("Task title cannot be empty.");
        }
        // Add more validation rules as needed
    }
}

