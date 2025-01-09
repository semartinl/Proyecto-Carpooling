package incubadora.carpooling.Configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig /*extends WebSecurityConfigurerAdapter*/ {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/usuarios/login", "/usuarios/logout").permitAll()  // Permitir acceso al login y logout
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/usuarios/login")  // Página de login personalizada
//                .permitAll()
//                .and()
//                .logout()
//                .logoutUrl("/usuarios/logout")  // URL para logout
//                .permitAll()
//                .invalidateHttpSession(true) // Invalida la sesión al cerrar sesión
//                .clearAuthentication(true); // Limpia la autenticación
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Usamos BCrypt para las contraseñas
    }
}