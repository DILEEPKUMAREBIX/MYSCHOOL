package com.myschool.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.myschool.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	private UserPrincipalDetailsService userPrincipalDetailsService;
	private UserRepository userRepository;

	public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService,
			UserRepository userRepository) {
		this.userPrincipalDetailsService = userPrincipalDetailsService;
		this.userRepository = userRepository;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/myschool/users/**").hasRole("STUDENT")
//				.antMatchers("/myschool/schools/**").hasRole("ADMIN").and().httpBasic();
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//				// remove csrf and state in session because in jwt we do not need them
//				.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//				// add jwt filters (1. authentication, 2. authorization)
//				.addFilter(new JwtAuthenticationFilter(authenticationManager()))
//				.addFilter(new JwtAutherizationFilter(authenticationManager(), this.userRepository)).authorizeRequests()
//				// configure access rules
//				.antMatchers("/*").permitAll();
//				// .antMatchers("/api/public/management/*").hasRole("MANAGER")
////				.antMatchers("/myschool/users/").permitAll().antMatchers("/myschool/schools").hasRole("ADMIN")
////				.anyRequest().authenticated();

		http
				// remove csrf and state in session because in jwt we do not need them
				.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				// add jwt filters (1. authentication, 2. authorization)
				.addFilter(new JwtAuthenticationFilter(authenticationManager()))
				.addFilter(new JwtAutherizationFilter(authenticationManager(), this.userRepository))
				.authorizeRequests()
				// configure access rules
				.antMatchers(HttpMethod.POST, "/login").permitAll();
				/*.antMatchers("/myschool/schools/*").hasRole("STUDENT")
				.antMatchers("/myschool/users/*").hasRole("ADMIN")
				.anyRequest().authenticated();
*/
	}

	@Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);

        return daoAuthenticationProvider;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
