package org.pz.railway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
public class MvcConfig {
	@Bean
	public JedisConnectionFactory connectionFactory() {
	return new JedisConnectionFactory();
	}
/*	
	@Bean
	public HttpSessionStrategy httpSessionStrategy() {
	return new HeaderHttpSessionStrategy();
	}*/
}