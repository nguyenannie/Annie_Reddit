package com.annie.reddit.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            .antMatchers("/welcome/reddit").permitAll()
            .antMatchers("/reddit").permitAll()
            .and()
            .formLogin()
            .loginPage("/login")
            .successHandler(loginSuccessHandler())
            .failureHandler(loginFailureHandler())
            .and().logout()
            .invalidateHttpSession(true)
            .logoutSuccessUrl("/login");

    http.exceptionHandling().accessDeniedHandler(accessDeniedHandler());
  }

  private AuthenticationSuccessHandler loginSuccessHandler() {
    return (request, response, authentication) ->
            response.sendRedirect("/home/" + authentication.getName());
  }

  private AuthenticationFailureHandler loginFailureHandler() {
    return (request, response, exception) -> {
      response.sendRedirect("/reddit/welcome");
    };
  }

  private AccessDeniedHandler accessDeniedHandler() {
    return (request, response, authentication) ->
            response.sendRedirect("/accessdenied");
  }
}
