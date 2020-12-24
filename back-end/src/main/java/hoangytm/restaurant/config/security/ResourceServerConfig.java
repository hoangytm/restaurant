package hoangytm.restaurant.config.security;

import hoangytm.restaurant.exception.RestAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * @author PhanHoang
 * 2/6/2020
 */

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    RestAccessDeniedHandler restAccessDeniedHandler;
    @Autowired
    AuthenticationEntryPoint authenticationEntryPoint;
    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.
                anonymous().disable()
                .authorizeRequests()
                .antMatchers("user/register").permitAll()
//                .antMatchers("/private/**").access("hasRole('ADMIN')")
                .antMatchers("**/fb/**", "/spring-security-rest/**", "**/swagger-ui.html").permitAll()
                .anyRequest().authenticated();

//                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
        http.exceptionHandling().accessDeniedHandler(restAccessDeniedHandler).authenticationEntryPoint(authenticationEntryPoint).and()
        ;

    }


}
