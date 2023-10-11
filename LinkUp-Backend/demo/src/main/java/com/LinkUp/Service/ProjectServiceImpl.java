package com.LinkUp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.LinkUp.Exception.DataIntegrityViolationException;
import com.LinkUp.Exception.InternalServerErrorException;
import com.LinkUp.Exception.NotFoundException;
import com.LinkUp.Exception.ValidationException;
import com.LinkUp.Model.Project;
import com.LinkUp.Repository.ProjectRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserService userService; // Assuming you have a UserService

    @Override
    @Transactional
    public Project createProject(Project project) throws ValidationException, DataIntegrityViolationException, InternalServerErrorException {
        validateProject(project);

        try {
            return projectRepository.save(project);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Project creation failed due to data integrity violation.");
        } catch (Exception e) {
            throw new InternalServerErrorException("Failed to create project.");
        }
    }

    @Override
    @Transactional
    public Project updateProject(Long projectId, Project updatedProject) throws ValidationException, NotFoundException, InternalServerErrorException {
        validateProject(updatedProject);

        try {
            Project existingProject = projectRepository.findById(projectId).orElseThrow(() -> new NotFoundException("Project not found."));
            // Update project properties here
            existingProject.setProjectName(updatedProject.getProjectName());
            existingProject.setDescription(updatedProject.getDescription());
            // ... other properties
            return projectRepository.save(existingProject);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Project not found.");
        } catch (ValidationException e) {
            throw new ValidationException("Validation failed while updating project.");
        } catch (Exception e) {
            throw new InternalServerErrorException("Failed to update project.");
        }
    }

    @Override
    @Transactional
    public void deleteProject(Long projectId) throws NotFoundException, InternalServerErrorException {
        try {
            projectRepository.deleteById(projectId);
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Project not found.");
        } catch (Exception e) {
            throw new InternalServerErrorException("Failed to delete project.");
        }
    }

    @Override
    public Project getProjectById(Long projectId) throws NotFoundException, InternalServerErrorException {
        try {
            return projectRepository.findById(projectId).orElseThrow(() -> new NotFoundException("Project not found."));
        } catch (EntityNotFoundException e) {
            throw new NotFoundException("Project not found.");
        } catch (Exception e) {
            throw new InternalServerErrorException("Failed to retrieve project.");
        }
    }
    
    

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    private void validateProject(Project project) throws ValidationException {
        if (project.getProjectName() == null || project.getProjectName().isEmpty()) {
            throw new ValidationException("Project name cannot be empty.");
        }
        // Add more validation rules as needed
    }
}

