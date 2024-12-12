package example.Loc5_Spring_Security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception {
        return
        http.httpBasic()
                .and().authorizeRequests()
//                .requestMatchers("/test1").authenticated()
//                .requestMatchers("/test2").hasAuthority("read")
                 .requestMatchers(HttpMethod.GET,"/demo/**").hasAuthority("read")
                .and()
                .csrf().disable()
                .build();

    }

    @Bean
    public UserDetailsService userDetailsService(){
//        var uds = new InMemoryUserDetailsManager();

        var u1 = User.withUsername("mhmd").
                password(encoder().encode("123"))
                .authorities("read").build();
        var u2 = User.withUsername("saif").
                password(encoder().encode("456"))
                .authorities("play").build();
        var u3 = User.withUsername("khalid").
                password(encoder().encode("789"))
                .authorities("manager").build();
//        .roles("ADMIN")  == .authorities("ROLE_ADMIN")
//        uds.createUser(u1);
//        uds.createUser(u2);
        return new InMemoryUserDetailsManager(u1,u2,u3) ;

    }

    @Bean
    public BCryptPasswordEncoder encoder (){
        return new  BCryptPasswordEncoder() ;
    }


}
