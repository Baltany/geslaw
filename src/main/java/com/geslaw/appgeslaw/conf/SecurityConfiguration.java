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

// @Configuration
// @EnableWebSecurity
public class SecurityConfiguration {

    // @Autowired private DataSource dataSource;

    // // Podemos crear nuestra propia clase para autenticar a los usuarios o bien usar
    // // un AuthenticationManagerBuilder.

    // @Autowired public void configure(AuthenticationManagerBuilder auth)throws Exception {
    //     auth
    //         .jdbcAuthentication()
    //         .dataSource(dataSource)
    //         .usersByUsernameQuery(
    //             "select username, password, habilitar from usuario where username = ?"
    //         )
    //         .authoritiesByUsernameQuery(
    //             "select usuario.username, tipo_usuario.nombre " +
    //             "from usuario, usuario_tipo_usuario, tipo_usuario "+
    //             "where usuario.id = usuario_tipo_usuario.usuario_id " +
    //             "and usuario_tipo_usuario.tipo_usuario_id = tipo_usuario.id "+
    //             "and usuario.username = ?"
    //         );


    // }

    // /*
    //      * @Bean UserDetailsService userDetailsService(){
    //      * return new MyCustomUserDetailsService();
    //      * }
    //      */
    // @Bean public PasswordEncoder encoder() {
    //     return new BCryptPasswordEncoder();
    // }

    // @Bean public SecurityFilterChain filter(HttpSecurity http)throws Exception {

    //     return http
    //         .authorizeHttpRequests((requests) -> requests.requestMatchers(
    //             "/webjars/**",
    //             "/img/**",
    //             "/js/**",
    //             // "/register/**",
    //             "/ayuda/**",
    //             "/acerca/**",
    //             "/login",
    //             "/denegado"
    //         ).permitAll().requestMatchers(
    //             "/usuarios/**",
    //             "/usuarios/*/**",
    //             "/usuarios/*/*/**",
    //             "/ayuda/**",
    //             "/acerca/**"
    //         ).hasAuthority("director"))
    //         .exceptionHandling((exception) -> exception.accessDeniedPage("/denegado"))
    //         .formLogin((formLogin) -> formLogin.permitAll())
    //         .rememberMe(Customizer.withDefaults())
    //         .logout(
    //             (logout) -> logout.invalidateHttpSession(true)
    //             // Redirecciona aquí después de cerrar sesión correctamente
    //             .logoutSuccessUrl("/")
    //             // .deleteCookies("JSESSIONID") 
    //             .permitAll()
    //         )
    //         .csrf((protection) -> protection.disable())
    //         //).cors((protection)-> protection
    //         //.disable())

    //         .build();


    //}

}
