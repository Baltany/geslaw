package com.geslaw.appgeslaw.conf;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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
    public SecurityFilterChain filter(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
            .authorizeHttpRequests((request) -> request
                .requestMatchers("/webjars/**", "/img/**", "/js/**", "/register/**", "/ayuda/**", "/acerca/**", "/login", "/denegado")
                .permitAll()
                .requestMatchers(
                    "/usuarios/**", "/usuarios/*/**", "/usuarios/*/*/**",
                    "/facturas/**", "/facturas/*/**", "/facturas/*/*/**",
                    "/obligadocumplimientos/**", "/obligadocumplimientos/*/**", "/obligadocumplimientos/*/*/**",
                    "/ayuda/**", "/acerca/**")
                .hasAuthority("Admin"))
            .exceptionHandling((exception) -> exception.accessDeniedPage("/denegado"))
            .formLogin((formLogin) -> formLogin
                .permitAll())
            .rememberMe(Customizer.withDefaults())
            .logout((logout) -> logout.invalidateHttpSession(true)
                .logoutSuccessUrl("/")
                .permitAll())
            .csrf((protection) -> protection
                .disable())//para deshabilitar el uso de token
            .build();
    }
}