package com.clinica.clinicapantano.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration//Indicándole a Spring que tome en cuenta esta clase para la configuración de seguridad
@EnableWebSecurity//Permite activar la seguridad para las rutas que vamos a indicar
public class SecurityConfig {

    //Método para la encriptación de contraseña
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http//Especificamos las rutas a las que se puede acceder y a las que no o que se necesita un rol específico
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((requests -> requests
                        .requestMatchers("/medicamento", "/api", "/user/**").permitAll()
                        .requestMatchers("/paciente", "/paciente/**").hasAuthority("ADMIN")
                        .anyRequest().permitAll()))
                .formLogin(login -> login
                        .loginPage("/login")
                        .defaultSuccessUrl("/hello"))
                .logout(logout -> logout
                        .permitAll());
        return http.build();
    }

    //Método que permite crear un usuario fijo para ser almacenado en la memoria del proyecto(no en la bdd)
    /*@Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("shrek1234")
                        .password("shrekislove")
                        .roles("USER")
                        .build();

        UserDetails user2 =
                User.withDefaultPasswordEncoder()
                        .username("fiona5422")
                        .password("fionalamasguapa")
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(user, user2);*/
    }



