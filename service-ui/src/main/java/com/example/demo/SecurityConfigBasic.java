package com.example.demo;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
//@Order(2)

public class SecurityConfigBasic extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
        .httpBasic()
      .and()
        .authorizeRequests()
          .antMatchers("/index.html", "/**").permitAll()
          .anyRequest().authenticated();
		       
		          //  .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());;

		// http.authorizeRequests().antMatchers("/login").authenticated().antMatchers("/").permitAll();
	}
	
}

