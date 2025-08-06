package com.todo.TodoList.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    // LDAP or Database -> Storing Username And password

    // Here we use in memory

    @Bean
    public InMemoryUserDetailsManager createUserDetailManager(){
        UserDetails user1 = createUser("Kartik","123","ADMIN");
        UserDetails user2 = createUser("manav","123","USER");
        UserDetails user3 = createUser("ronak","123","USER");
        UserDetails user4 = createUser("new","123","USER");
        return new InMemoryUserDetailsManager(user1,user2,user3,user4);
    }

    private UserDetails createUser(String userName,String password,String role){
        return User
                .builder()
                .passwordEncoder(input -> passwordEncoder().encode(input))
                .username(userName)
                .password(password)
                .roles(role)
                .build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception{
        httpSecurity.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.csrf(csrf -> csrf.disable())
                    .headers(header ->
                            header.frameOptions(frameOptionsConfig ->
                                    frameOptionsConfig.disable()
                            )
                    );
        return httpSecurity.build();
    }

}
