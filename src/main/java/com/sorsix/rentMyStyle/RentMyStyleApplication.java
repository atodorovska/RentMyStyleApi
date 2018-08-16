package com.sorsix.rentMyStyle;

import com.sorsix.rentMyStyle.configuration.Handler;
import com.sorsix.rentMyStyle.repository.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.CompositeFilter;
import javax.servlet.Filter;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableOAuth2Client
@EnableConfigurationProperties(StorageProperties.class)
@RestController
@RequestMapping("/api")
public class RentMyStyleApplication extends WebSecurityConfigurerAdapter {

    @Autowired
    OAuth2ClientContext oauth2ClientContext;

    @RequestMapping("/user")
    public Principal user(Principal principal) {
        Principal a = principal;
        return principal;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/**", "/", "/files/**", "/login**", "/webjars/**", "/error**", "/api/**")
                .permitAll()
                .anyRequest()
                .authenticated().and().logout()
                .logoutSuccessUrl("http://localhost:4200/home").permitAll().and().csrf().disable()
//                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class);
    }

    @Bean
    @ConfigurationProperties("facebook.client")
    public AuthorizationCodeResourceDetails facebook() {
        return new AuthorizationCodeResourceDetails();
    }

    @Bean
    @ConfigurationProperties("facebook.resource")
    public ResourceServerProperties facebookResource() {
        return new ResourceServerProperties();
    }

    @Autowired
    public Handler handler;

    private Filter ssoFilter() {

        CompositeFilter filter = new CompositeFilter();
        List<Filter> filters = new ArrayList<>();

        OAuth2ClientAuthenticationProcessingFilter facebookFilter = new OAuth2ClientAuthenticationProcessingFilter("/login/facebook");
        facebookFilter.setAuthenticationSuccessHandler(handler);
        OAuth2RestTemplate facebookTemplate = new OAuth2RestTemplate(facebook(), oauth2ClientContext);
        facebookFilter.setRestTemplate(facebookTemplate);
        UserInfoTokenServices tokenServices = new UserInfoTokenServices(facebookResource().getUserInfoUri(), facebook().getClientId());
        tokenServices.setRestTemplate(facebookTemplate);
        facebookFilter.setTokenServices(tokenServices);
        filters.add(facebookFilter);

        OAuth2ClientAuthenticationProcessingFilter githubFilter = new OAuth2ClientAuthenticationProcessingFilter("/login/github");
        githubFilter.setAuthenticationSuccessHandler(handler);
        OAuth2RestTemplate githubTemplate = new OAuth2RestTemplate(github(), oauth2ClientContext);
        githubFilter.setRestTemplate(githubTemplate);
        tokenServices = new UserInfoTokenServices(githubResource().getUserInfoUri(), github().getClientId());
        tokenServices.setRestTemplate(githubTemplate);
        githubFilter.setTokenServices(tokenServices);
        filters.add(githubFilter);

        filter.setFilters(filters);
        return filter;

    }

    @Bean
    @ConfigurationProperties("github.client")
    public AuthorizationCodeResourceDetails github() {
        return new AuthorizationCodeResourceDetails();
    }

    @Bean
    @ConfigurationProperties("github.resource")
    public ResourceServerProperties githubResource() {
        return new ResourceServerProperties();
    }

    public static void main(String[] args) {
		SpringApplication.run(RentMyStyleApplication.class, args);
	}

}
