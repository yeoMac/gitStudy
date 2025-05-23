package awsStudy.Study.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}

    // 시큐리티 설정 추가
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // CSRF 비활성화 (테스트용으로만)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/member/signup",
                                "/api/member/login","/api/member/login/**",
                                "/api/boards","/api/boards/**",
                                "/api/category","/api/category/**",
                                "/api/board/comment","/api/board/comment/**").permitAll() // 이 경로는 인증 없이 접근 가능
                        .anyRequest().authenticated() // 그 외 경로는 인증 필요
                );

        return http.build();
    }
}
