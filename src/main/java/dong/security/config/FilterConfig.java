package dong.security.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dong.security.filter.FindRoleFromJwtFilter;

@Configuration
public class FilterConfig {

	@Autowired
	private FindRoleFromJwtFilter findRoleFromJwtFilter;
	
	@Bean
	public FilterRegistrationBean<FindRoleFromJwtFilter> roleFindFilter() {
		FilterRegistrationBean<FindRoleFromJwtFilter> registrationBean = new FilterRegistrationBean<>();

		registrationBean.setFilter(findRoleFromJwtFilter);
		List<String> filterUrls = new ArrayList<>();
		filterUrls.add("/tasks/add");
		// filterUrls.add("/tasks/findAll");
		registrationBean.setUrlPatterns(filterUrls);
		registrationBean.setOrder(0);
		return registrationBean;

	}

}
