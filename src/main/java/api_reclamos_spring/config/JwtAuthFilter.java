package api_reclamos_spring.config;

import java.io.IOException;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthFilter extends OncePerRequestFilter {

	private final SecretKey secretKey;

	public JwtAuthFilter(SecretKey secretKey) {
		this.secretKey = secretKey;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String token = extractJwtFromRequest(request);

			if (token != null && validateToken(token)) {
				String username = extractUsernameFromToken(token);

				if (username != null) {
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
							username, null, null);
					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
			}
		} catch (Exception e) {
			SecurityContextHolder.clearContext();
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
			return;
		}

		filterChain.doFilter(request, response);
	}

	private String extractJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");

		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}

		return null;
	}

	private boolean validateToken(String token) {
		try {
			Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);

			// If the above line doesn't throw an exception, the token is valid
			return true;
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
			return false;
		}
	}


	private boolean isTokenSignatureValid(Jws<Claims> claimsJws) {
		try {
			claimsJws.getBody();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private boolean isTokenNotExpired(Date expirationDate) {
		return expirationDate != null && !expirationDate.before(new Date());
	}

	public String extractUsernameFromToken(String token) {
		try {
			Claims claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();

			String username = claims.getSubject();
			return username;
		} catch (Exception e) {
			return null;
		}
	}
}
