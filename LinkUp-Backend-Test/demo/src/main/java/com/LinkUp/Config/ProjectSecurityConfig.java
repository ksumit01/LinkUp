package com.LinkUp.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors(Customizer.withDefaults()) // Configure CORS here
            .csrf(csrf -> {
                csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
            })
            .authorizeHttpRequests(authorizeRequests -> {
                // Specify access permissions directly using requestMatchers
                authorizeRequests
                    .requestMatchers(request -> {
                        String uri = request.getRequestURI();
                        return uri.matches("/myAccount|/myBalance|/myLoans|/myCards|/user") && request.getMethod().equals("GET");
                    }).authenticated()
                    .requestMatchers(request -> {
                        String uri = request.getRequestURI();
                        return uri.matches("/notices|/contact|/register");
                    }).permitAll();
            })
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:4200"); // Allow requests from your Angular app's origin
        config.addAllowedMethod("*"); // Allow all HTTP methods
        config.addAllowedHeader("*"); // Allow all headers
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
