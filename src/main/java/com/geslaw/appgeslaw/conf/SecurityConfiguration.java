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

        // Podemos crear nuestra propia clase para autenticar a los usuarios
        // o bien usar un AuthenticationManagerBuilder.

        @Autowired
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth.jdbcAuthentication()
                                .dataSource(dataSource)
                                .usersByUsernameQuery("select username, password, habilitar "
                                                + "from usuario "
                                                + "where username = ?")
                                .authoritiesByUsernameQuery("SELECT usuario.username, tipo_usuario.nombre  "
                                                + "FROM usuario, usuario_tipo_usuario, tipo_usuario "
                                                + "WHERE usuario.id = usuario_tipo_usuario.usuario_id AND "
                                                + "usuario_tipo_usuario.tipo_usuario_id = tipo_usuario.id AND usuario.username = ?");
        }

        /*
         * @Bean UserDetailsService userDetailsService(){
         * return new MyCustomUserDetailsService();
         * }
         */
        @Bean
        public PasswordEncoder encoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public SecurityFilterChain filter(HttpSecurity http) throws Exception {
                
                // Con Spring Security 6.2 y 7: usando Lambda DSL

                return http
                        .authorizeHttpRequests((requests) -> requests
                                .requestMatchers("/webjars/**", "/img/**", "/js/**", "/register/**", "/ayuda/**", "/acerca/**", "asignaturas/**" , "/login", "/denegado")
                                .permitAll() 
                                //retoques en clase,importante la proteccion de todas las rutas tal y como me ha dicho Juangu
                                .requestMatchers("/usuarios/**", "/usuarios/*/**" , "/usuarios/*/*/**", "asignaturas/**" ,"asignaturas/*/**", "asignaturas/*/*/**" ,  "/ayuda/**", "/acerca/**")
                                //.authenticated()
                                .hasAuthority("director")
                        //        .anyRequest().permitAll()
                        // ).headers(headers -> headers
                        //         .frameOptions(frameOptions -> frameOptions
                        //                 .sameOrigin())
                        // ).sessionManagement((session) -> session
                        //         .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        ).exceptionHandling((exception)-> exception.
                                accessDeniedPage("/denegado") )
                        .formLogin((formLogin) -> formLogin
                                //.loginPage("/login")
                                .permitAll()
                        ).rememberMe(
                                Customizer.withDefaults()
                        ).logout((logout) -> logout
                                .invalidateHttpSession(true)
                                .logoutSuccessUrl("/home")
                                // .deleteCookies("JSESSIONID") // no es necesario, JSESSIONID se hace por defecto
                                .permitAll()                                
                        ).csrf((protection) -> protection
                                .disable()
                        // ).cors((protection)-> protection
                        //          .disable()
                        ).build();

        }

}
