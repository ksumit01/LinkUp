package com.LinkUp.Service;

import java.util.List;

import com.LinkUp.Exception.DataIntegrityViolationException;
import com.LinkUp.Exception.InternalServerErrorException;
import com.LinkUp.Exception.NotFoundException;
import com.LinkUp.Exception.ValidationException;
import com.LinkUp.Model.Project;

public interface ProjectService {
    Project createProject(Project project) throws ValidationException, DataIntegrityViolationException, InternalServerErrorException;
    Project updateProject(Long projectId, Project project) throws ValidationException, NotFoundException, InternalServerErrorException;
    void deleteProject(Long projectId) throws NotFoundException, InternalServerErrorException;
    Project getProjectById(Long projectId) throws NotFoundException, InternalServerErrorException;
    List<Project> getAllProjects();
}


