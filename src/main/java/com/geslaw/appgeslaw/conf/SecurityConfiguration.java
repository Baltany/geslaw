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


    //Deshabilitando el login...
    @Autowired
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
    .requestMatchers("/public/**").permitAll() // Configura las URL públicas
    .anyRequest().authenticated(); // Todas las demás URL requieren autenticación
 // Deshabilitar CSRF para simplicidad
    }

    /*No funciona */
//     @Autowired
// public void configure(AuthenticationManagerBuilder auth) throws Exception {
//     auth.jdbcAuthentication()
//         .dataSource(dataSource)
//         .usersByUsernameQuery("SELECT username, password, habilitar "
//                             + "FROM usuario "
//                             + "WHERE username = ?")
//         .authoritiesByUsernameQuery("SELECT usuario.username, tipo_usuario.nombre "
//                             + "FROM usuario_tipo_usuario, usuario, tipo_usuario "
//                             + "WHERE usuario.id = usuario_tipo_usuario.usuario_id and "
//                             + "usuario_tipo_usuario.tipo_usuario_id = tipo_usuario.id and usuario.username = ?");
// }


    


    // @Autowired
    // public void configure(AuthenticationManagerBuilder auth) throws Exception{
    //     auth.jdbcAuthentication()
    //     .dataSource(dataSource)
    //     .usersByUsernameQuery("select username, password "
    //     + "from usuario "
    //     + "where username = ?")
    //     // .authoritiesByUsernameQuery("SELECT username, password FROM usuario WHERE username = ?");



    // }

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
