package utcn.ps.backend.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import utcn.ps.backend.service.TeacherUserDetailsService;

@Configuration // special annotation
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final TeacherUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // autorizeaza toate requesturile
        // si la fiecare reuwest trebe sa fiu autentificat (logged in)
        http.authorizeRequests()
                .anyRequest().authenticated()
//                .antMatchers("/admin/**").hasAuthority("ROLE_TEACHER")
                .and()
                .httpBasic().and()
                .cors().and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    //anotatie speciala in clasa de config to create an instance by yourself
    // dar o trimit la spring ca sa stie spring sa o injecteze unde este nevoie
    // eu fac instantierea, dar spring o injecteaza
    // pe cand la service si astea face spring tot
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
