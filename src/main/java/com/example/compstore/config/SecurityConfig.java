package com.example.compstore.config;

import com.example.compstore.model.Role;
import com.example.compstore.security.jwt.JwtConfigurer;
import com.example.compstore.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String ROLE_ADMIN = Role.ADMIN.name();
    private static final String ROLE_USER = Role.USER.name();
    private static final String ROLE_MASTER = Role.STAFF.name();
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public SecurityConfig(UserDetailsService userDetailsService,
                          PasswordEncoder passwordEncoder,
                          JwtTokenProvider jwtTokenProvider) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/register", "/login", "/swagger-ui/**", "/swagger-resources/**",
                        "/v3/api-docs", "/v2/api-docs").permitAll()
                .antMatchers(HttpMethod.GET, "/laptops/**", "/desktops/**", "/all-in-one/**",
                        "/computers/**", "/items/**").permitAll()
                .antMatchers(HttpMethod.GET,
                        "/users/**").hasRole(ROLE_ADMIN)
                .antMatchers(HttpMethod.POST,
                        "/users/**").hasAnyRole(ROLE_ADMIN)
                .antMatchers(HttpMethod.PUT,
                        "/users/**").hasAnyRole(ROLE_ADMIN, ROLE_USER)
                .antMatchers(HttpMethod.DELETE,
                        "/orders/**", "/laptops/**", "/desktops/**",
                        "/items/**", "/all-in-one/**").hasAnyRole(ROLE_ADMIN)
                .antMatchers(HttpMethod.GET,
                        "/shopping-carts/**").hasAnyRole(ROLE_ADMIN, ROLE_USER)
                .antMatchers(HttpMethod.PATCH,
                        "/shopping-carts/**").hasAnyRole(ROLE_USER)
                .antMatchers(HttpMethod.GET,
                        "/orders/**").hasAnyRole(ROLE_ADMIN, ROLE_USER)
                .antMatchers(HttpMethod.POST,
                        "/orders/**").hasAnyRole(ROLE_ADMIN, ROLE_USER)
                .antMatchers(HttpMethod.PATCH,
                        "/orders/**", "/laptops/**", "/desktops/**", "/all-in-one/**",
                        "/computers/**", "/items/**", "/users/**").hasAnyRole(ROLE_ADMIN, ROLE_USER)
                .antMatchers(HttpMethod.DELETE,
                        "/orders/**").hasAnyRole(ROLE_ADMIN)
                .antMatchers(HttpMethod.POST,
                        "/laptops/**", "/desktops/**", "/all-in-one/**",
                        "/computers/**", "/items/**").hasRole(ROLE_ADMIN)
                .antMatchers(HttpMethod.PUT,
                        "/laptops/**", "/desktops/**", "/all-in-one/**",
                        "/computers/**", "/items/**").hasRole(ROLE_ADMIN)
                .anyRequest()
                .authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider))
                .and()
                .headers().frameOptions().disable();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
}