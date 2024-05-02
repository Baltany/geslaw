package com.geslaw.appgeslaw.conf;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private DataSource dataSource;

    // Define el bean PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //la consulta funciona correctamente en el adminer
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("select username, password, habilitar from usuario where username=?")
            .authoritiesByUsernameQuery("select usuario.username, tipo_usuario.nombre " +
                "from usuario, usuario_tipo_usuario, tipo_usuario " +
                "where usuario.id = usuario_tipo_usuario.usuario_id " +
                "and usuario_tipo_usuario.tipo_usuario_id = tipo_usuario.id " +
                "and usuario.username = ?")
            //.passwordEncoder(passwordEncoder())
            ; // Utiliza el PasswordEncoder inyectado
    }

    

    @Bean
    public DefaultSecurityFilterChain filter(HttpSecurity httpSecurity) throws Exception {
        
        httpSecurity
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers("/webjars/**", "/img/**", "/js/**", "/register/**", "/ayuda/**", "/acerca/**", "/login", "/denegado", "/logout","/obligadocumplimientos","/facturas","/obligadocumplimientos/**","/facturas/**")
                    .permitAll()
                .requestMatchers("/usuarios/**", "/usuarios/*/*/**", "/facturas/**","/facturas/*/*/**", "/obligadocumplimientos/**","/obligadocumplimientos/*/*/**", "/ayuda/**", "/acerca/**")
                    .hasAnyAuthority("Admin", "Coordinador")
                .requestMatchers(HttpMethod.DELETE,"/facturas/delete/**","/obligadocumplimientos/delete/**").hasAnyAuthority("Admin","Coordinador")
                .requestMatchers("/facturas/add", "/obligadocumplimientos/add")
                    .hasAuthority("Director")
                .requestMatchers("/facturas", "/obligadocumplimientos")
                    .hasAnyAuthority("Trabajador", "Director")
                .anyRequest().authenticated())
            .exceptionHandling(exceptionHandling -> exceptionHandling
                .accessDeniedPage("/denegado"))
            .formLogin((formLogin)-> formLogin.loginPage("/login")
                .permitAll())
            .logout(logout -> logout
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
                .permitAll())
            .csrf(csrf -> csrf
                .disable());

        return httpSecurity.build();
    }
    
}