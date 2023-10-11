//This is DAOAuthentication Example To Check For The Authentication
//IT is a Default Method Method by Spring Security

//package com.LinkUp.Config;



//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.LinkUp.Repository.UserRepository;
//
//@Service
//public class LinkUpUserDetails implements UserDetailsService{
//	
//	@Autowired
//	private  UserRepository userRepository;
//
//	@Override
//	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
//		
//		String userName, password;
//		List<GrantedAuthority> authorities;
//		List<com.LinkUp.Model.User> user = userRepository.findByEmail(name);
//		if(user.size()==0) {
//			throw new UsernameNotFoundException("User details not found for the user : " + name);
//		}else {
//			
//			userName = user.get(0).getEmail();
//			password = user.get(0).getPassword();
//			authorities = new ArrayList<>();
//			authorities.add(new SimpleGrantedAuthority(user.get(0).getRole()));
//		}
//		return new User(userName,password,authorities);
//	}
//
//}
