package org.pz.railway.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public ApplicationSecurity applicationSecurity() {
		return new ApplicationSecurity();
	}
	
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected class ApplicationSecurity extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// @formatter:off
			http.csrf().ignoringAntMatchers("/api/**")
				.and().authorizeRequests().antMatchers("/", "/signin", "/css/**", "/static/**", "/error", "/js/**", "/api/**").permitAll()
				.anyRequest().fullyAuthenticated()
				.and().formLogin().loginPage("/signin")
				.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
			// @formatter:on
		}

	}
}
