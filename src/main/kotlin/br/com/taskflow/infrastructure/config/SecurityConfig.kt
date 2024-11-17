package com.muyan.issuetracker.infrastructure.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@EnableWebSecurity
@Configuration
class SecurityConfig {

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() } // Desabilita CSRF, útil para APIs REST
            .authorizeHttpRequests {
                it.requestMatchers("/login", "/api/auth/signin").permitAll() // Permite acesso público a essas rotas
                    .anyRequest().authenticated() // Requer autenticação para todas as outras rotas
            }
            .formLogin { form ->
                form
                    .loginPage("/login") // Página personalizada de login
                    .permitAll()
            }
            .logout { logout ->
                logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login")
                    .permitAll()
            }
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun userDetailsService(passwordEncoder: PasswordEncoder): UserDetailsService {
        val userAdmin: UserDetails = User
            .withUsername("admin")
            .password(passwordEncoder.encode("password"))
            .roles("ADMIN")
            .build()

        val userUser: UserDetails = User
            .withUsername("user")
            .password(passwordEncoder.encode("password"))
            .roles("USER")
            .build()

        return InMemoryUserDetailsManager(userAdmin, userUser)
    }

    @Bean
    fun authenticationManager(config: AuthenticationConfiguration): AuthenticationManager {
        return config.authenticationManager
    }
}
