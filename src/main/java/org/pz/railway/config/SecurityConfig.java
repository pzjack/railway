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

//		http.requiresChannel().antMatchers("signin").requiresSecure();
//		http.requiresChannel().antMatchers("/**").requiresInsecure();
		
		/*http
		.authorizeRequests()                                                                1
			.antMatchers("/resources/**", "/signup", "/about").permitAll()                  2
			.antMatchers("/admin/**").hasRole("ADMIN")                                      3
			.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")            4
			.anyRequest().authenticated()                                                   5
			.and()
		...
		.formLogin();*/
		// @formatter:off
		http.authorizeRequests()
			.antMatchers("/", "/signin", "/css/**", "/js/**", "/api/**", "/static/**", "/error")
			.permitAll()
			.anyRequest()	//.authenticated()
			.fullyAuthenticated();
		
		
		/**
		 * 
		 */
		http.formLogin()
			.loginPage("/signin");
		
		/**
         * <logout invalidate-session="true" delete-cookies="JSESSIONID" />
         */
		http.logout()
//			.logoutUrl("/logout")
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		/**
         * <session-management session-fixation-protection="newSession"/>
         */
		http.sessionManagement()
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