package org.pz.railway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.authorizeRequests().antMatchers("/", "/signin", "/css/**", "/js/**", "/api/**", "/static/**", "/error").permitAll()
			.anyRequest().fullyAuthenticated()
			.and().formLogin().loginPage("/signin")
			.and().logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.and()
            .sessionManagement()
            .maximumSessions(1)
            .expiredUrl("/")
            .maxSessionsPreventsLogin(true)
            .sessionRegistry(sessionRegistry());
		// @formatter:on
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService userDetailsService) throws Exception {
//		auth
//		.inMemoryAuthentication()
//		.withUser("user").password("user").roles("USER").and()
//		.withUser("admin").password("admin").roles("USER", "ADMIN");
		auth.userDetailsService(userDetailsService);
		
//			.passwordEncoder(new BCryptPasswordEncoder());
	}

    // Work around https://jira.spring.io/browse/SEC-2855
    @Bean
    public SessionRegistry sessionRegistry() {
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }
}