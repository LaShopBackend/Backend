package practic.la_shop.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
//                        .requestMatchers("/signUp").permitAll()
//                        .requestMatchers("/signIn").permitAll()
//                        .requestMatchers("/home").permitAll()
//                        .requestMatchers("/deleteAccount").authenticated()
//                        .requestMatchers("/cart", "/cart/**").authenticated()
//                        .requestMatchers("/categories/{categoryId}").permitAll()
//                        .requestMatchers("/products/{productId}").permitAll()
//                        .requestMatchers("/favourites", "favourites/**").authenticated()
                        .requestMatchers("/signUp").permitAll()
                        .requestMatchers("/signIn").permitAll()
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/deleteAccount").permitAll()
                        .requestMatchers("/cart", "/cart/**").permitAll()
                        .requestMatchers("/categories/{categoryId}").permitAll()
                        .requestMatchers("/products/{productId}").permitAll()
                        .requestMatchers("/favourites", "favourites/**").permitAll())
//                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    public static final String ADMIN = "ADMIN";
//    public static final String USER = "USER";
}
