package api_reclamos_spring.config;

import java.util.Base64;
import javax.crypto.SecretKey;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { //'HttpSecurity' analiza cada solicitud http que es enviada a nuestra aplicacion
		http.authorizeHttpRequests(
			(authz) -> authz.anyRequest().authenticated())
			.addFilterBefore(jwtAuth(), UsernamePasswordAuthenticationFilter.class)
			.csrf(AbstractHttpConfigurer::disable);
		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("auth/login", "api/usuarios");
	}

	@Bean
	public JwtAuthFilter jwtAuth() {
		return new JwtAuthFilter(secretKey());
	}

	@Bean
	public SecretKey secretKey() {
		SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		byte[] encodedKey = secretKey.getEncoded();
		String encodedKeyBase64 = Base64.getEncoder().encodeToString(encodedKey);

		System.out.println("Secret Key (Base64): " + encodedKeyBase64);

		return secretKey;
	}
}
