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


    /*Tengo que cambiar la consulta */
    @Autowired

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery("select username, password, true "
            + "from usuario "
            + "where username = ?")
        .authoritiesByUsernameQuery("select username, tipoUsuario.nombre as authority "
            + "from usuario "
            + "join usuario_tipo_usuario on usuario.id = usuario_tipo_usuario.usuario_id "
            + "join tipo_usuario on usuario_tipo_usuario.tipo_usuario_id = tipo_usuario.id "
            + "where username = ?");
}


    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }



    /*Hay que proteger todas las rutas a las que un usuario puede acceder */
    @Bean
    public SecurityFilterChain filter(HttpSecurity httpSecurity) throws Exception{
        
        return httpSecurity
        .authorizeHttpRequests((request)-> request.requestMatchers("/webjars/**", "/img/**", "/js/**", "/register/**", "/ayuda/**", "/acerca/**", "aaaaa/**" , "/login", "/denegado")
        .permitAll()
        .requestMatchers("/usuarios/**", "/usuarios/*/**" , "/usuarios/*/*/**", "aaaaaa/**" ,"aaaaaa/*/**", "aaaaaa/*/*/**" ,  "/ayuda/**", "/acerca/**")
        /*cambiar admin -> director */
        .hasAuthority("admin"))
        .exceptionHandling((exception)-> exception.accessDeniedPage("/denegado"))
        .formLogin((formLogin)-> formLogin.permitAll())
        .rememberMe(Customizer.withDefaults())
        .logout((logout)-> logout.invalidateHttpSession(true)
        .logoutSuccessUrl("/")
        .permitAll())
        .csrf((protection)->protection.disable())
        .build();

    }


}
