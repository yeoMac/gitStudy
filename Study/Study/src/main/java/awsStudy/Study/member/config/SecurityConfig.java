package awsStudy.Study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // CSRF 보호 비활성화 (POST 요청 허용)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/member/signup").permitAll() // 회원가입은 인증 없이 가능
                        .anyRequest().authenticated() // 그 외 요청은 인증 필요
                );
        return http.build();
    }
}
