package org.pz.railway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.thymeleaf.extras.tiles2.dialect.TilesDialect;
import org.thymeleaf.extras.tiles2.spring4.web.configurer.ThymeleafTilesConfigurer;
import org.thymeleaf.extras.tiles2.spring4.web.view.ThymeleafTilesView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

@Configuration
public class ThymeleafTilesConfig {

	@SuppressWarnings("deprecation")
	@Bean
	public ThymeleafTilesConfigurer tilesConfigurer() {
		final ThymeleafTilesConfigurer configurer = new ThymeleafTilesConfigurer();
		configurer.setDefinitions("classpath:tiles/tiles-def.xml");
		return configurer;
	}

	/**
	 * 方法名称不能变动，SpringTemplateEngine不能自己初始化，否则有问题
	 * @param templateEngine
	 * @return
	 */
	@Bean
	public ThymeleafViewResolver thymeleafTilesViewResolver(SpringTemplateEngine templateEngine) {
		final ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setViewClass(ThymeleafTilesView.class);
		resolver.setTemplateEngine(templateEngine);
		resolver.setCharacterEncoding("UTF-8");
		resolver.setOrder(Ordered.LOWEST_PRECEDENCE);
		return resolver;
	}
	
	@Bean
    public ThymeleafViewResolver thymeleafViewResolver(SpringTemplateEngine templateEngine) {
        ThymeleafViewResolver vr = new ThymeleafViewResolver();
        vr.setTemplateEngine(templateEngine);
        vr.setCharacterEncoding("UTF-8");
        vr.setOrder(Ordered.HIGHEST_PRECEDENCE);
        // all message/* views will not be handled by this resolver as they are Tiles views
        vr.setExcludedViewNames(new String[]{"message/*"});
        return vr;
    }

	@Bean
	public TilesDialect tilesDialect() {
		return new TilesDialect();
	}
}
