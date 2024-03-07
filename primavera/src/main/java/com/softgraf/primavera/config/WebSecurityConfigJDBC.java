package com.softgraf.primavera.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigJDBC {
	
	@Bean
	public PasswordEncoder delegateEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	// permite salvar novos usuários ou apenas retornas os existentes do banco de dados
	@Bean
	public UserDetailsManager users(DataSource dataSource) {
		
		UserDetails user = User.builder()
						.username("Felipe")
						.password(delegateEncoder().encode("softgraf"))
						.roles(RolesConstants.USER)
						.build();
		
		UserDetails admin = User.builder()
						.username("softgraf")
						.password(delegateEncoder().encode("softgraf"))
						.roles(RolesConstants.USER, RolesConstants.ADMIN)
						.build();
		
		JdbcUserDetailsManager jdbcUsers = new JdbcUserDetailsManager(dataSource);
		
		
		//jdbcUsers.createUser(user);
		//jdbcUsers.createUser(admin);
		
		return jdbcUsers;

	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			
		.authorizeHttpRequests((request) -> request
				
				.requestMatchers("/", "/homepage", "/sobre", "/images/**","/uploads/**","/api/**").permitAll()
				
				
				.requestMatchers("/produto/excluir/**").hasAnyRole("ADMIN")
				
				.anyRequest().authenticated()
		)
		
		// define o formulario personalizado de login
		.formLogin(form -> form
				
				// cjama o endpoint do controlador
				.loginPage("/login")
				
				// apos fazer o login vai para este endpoint
				.defaultSuccessUrl("/produto/gerenciar", true)
				.permitAll()
		)
		
		.logout(logout -> logout.logoutSuccessUrl("/login"))
		
		// podemos também incluir essas opçoes
		// .invalidatehttpSssion(true)
		// .deleteCookies("JESSIONID")
		
		// proteçao contra falsificaçao de folicitaçao entre site
		.csrf(csrf -> csrf.disable());
		
		
		return http.build();
		
		
	}

}
