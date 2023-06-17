
package com.todocode.demo;

import com.todocode.demo.Servicios.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService usuarioServicio;
    
//    @Autowired
//    PeriodistaServicio periodistaServicio;
    
    @Autowired
    public void configuredGlobal(AuthenticationManagerBuilder auth) throws Exception{//recive un objeto por param y configuramos el manejador de seguridad, le digo cual es el servicio q tiene q usar pasa autenticar un usuario
        auth.userDetailsService(usuarioServicio).passwordEncoder(new BCryptPasswordEncoder());//lo autentica con el userdetail y lo decodifica con el encoder
        //auth.userDetailsService(periodistaServicio).passwordEncoder(new BCryptPasswordEncoder());
    }
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {//configura el logueo
        http
                .authorizeHttpRequests()
                    .antMatchers("/admin/*").hasRole("ADMIN")
                    .antMatchers("/cc*", "/js/*", "/img/*", "/**")
                    .permitAll()
                .and().formLogin()
                        .loginPage("/login")
                        .loginProcessingUrl("/logincheck")//autentica el usuario...esta direccion tiene q estar en action del formulario de logueo
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/inicio")//url q se muestra en caso de acceso con mas funcionalidades
                        .permitAll()
                    .and().logout()
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")//cuando se sale redirecciona al index
                    .permitAll()
                .and().csrf()
                    .disable();

    }
}
