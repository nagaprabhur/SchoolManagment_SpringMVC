package com.example.demo;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.*"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	/*public void authenticationManager(AuthenticationManagerBuilder builder,final UserRepository repo) throws Exception{
		
		if(repo.count()==0)
			 repo.save(new User("user","user", (Collection<? extends GrantedAuthority>) Arrays.asList(new Role("USER"),new Role("ACTUATOR"))));
		
		
		builder.userDetailsService(new UserDetailsService(){

			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				// TODO Auto-generated method stub
				return new CustomUserdetails(repo.findByUsername(username));
			}
			
		});
	}*/
}
