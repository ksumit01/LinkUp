package com.LinkUp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LinkUp.model.Team;
import com.LinkUp.model.Users;
import com.LinkUp.repository.TeamRepository;
import com.LinkUp.repository.UsersRepository;

@Service
public class TeamService {

	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	
	
	  public Team createTeam(Team team) {
		  team.getMembers().add(team.getTeamProject().getProjectManager());
		  team.getMembers().stream().map(a->a.getNotifications().add("You have been Added in the Team : " +team.getName()));
//		  userRepository.saveAllAndFlush(team.getMembers());
	        return teamRepository.save(team);
	        
	    }
	  
	  
	 
	  
	  public Team addMemberToTeam(Long teamId, Long memberId) {
		  
	        Team team = teamRepository.findById(teamId).get();

	        Users newMember = userRepository.findById(memberId).get();

	        team.getMembers().add(newMember);
	        
	        newMember.getNotifications().add("You have been added in : "+ team.getName());
	        
	        userRepository.save(newMember);
	        return teamRepository.save(team);
	    }
	  
	  
	  
	  
	  public Optional<Team> teamDetails(Long id) {
		  
		  return teamRepository.findById(id);
	  }
	  
	  
	  public List<Team> getAllTeamsOfManager(Long id) {
		  
		  
		  
		  List<Team> teamList=teamRepository.findByMembersId(id);
		  teamList.addAll(teamRepository.findAll().stream().filter(a->a.getTeamProject().getProjectManager().getId()==id).toList());
//		  teamList.addAll(teamRepository.findProjectsByMemberId(id));
		  
		  
		return teamList;
		  
	  }
	  
	  
	  
	  
}
