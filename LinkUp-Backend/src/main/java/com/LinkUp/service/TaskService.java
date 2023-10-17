package com.LinkUp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LinkUp.Exceptions.TaskNotFoundException;
import com.LinkUp.enums.Priority;
import com.LinkUp.enums.Status;
import com.LinkUp.model.Task;
import com.LinkUp.repository.TaskRepository;
import com.LinkUp.repository.UsersRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	  public Task assignTaskToTeamMember(Task task) {
		    task.getAssigned().getNotifications().add("You have Assinged Task : "+task.getTitle());
//		    usersRepository.save(task.getAssigned());
	        return taskRepository.save(task);
	        
	    }
	  
	  
	  
	  public Task changeTaskPriority(Long taskId, Priority newPriority) {
	        Task task = taskRepository.findById(taskId)
	                .orElseThrow(() -> new TaskNotFoundException("Task not found with ID: " + taskId));

	        // Update the task priority
	        task.setPriority(newPriority);

	        return taskRepository.save(task);
	    }
	  
	  
	  public Task changeTaskStatus(Long taskId, Status newStatus) {
		  
		  
			Task task = taskRepository.findById(taskId).get();	  
			task.setStatus(newStatus);
		
			return taskRepository.save(task);
	    }
	  
	  
	  
	  public Optional<Task> getTaskDetails(Long taskId) {
		    return taskRepository.findById(taskId);
		    
		}
	  
	  

	  public List<Task> getAllTask(Long userId) {
		     
		     return taskRepository.findAll().stream().filter(a->a.getAssigned().getId()==userId).toList();
		}
	 
	  
	  public String deleteTask(Long taskId) {
		  
		  if(taskRepository.findById(taskId).isPresent()) {
			  Task task = taskRepository.findById(taskId).get();
			    taskRepository.delete(task);
			    return "task deleted Successfully";
			    
		  }else {
			  return "task id cannot found";
		  }
		  
	
		  
}
	 public Task findTask(Long taskId) {
			Task task = taskRepository.findById(taskId).get();
			return task;
		}  
	 







}



