package api_reclamos_spring.controller;

import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import api_reclamos_spring.model.dto.UsuarioDTO;
import api_reclamos_spring.service.IUsuarioService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private final int EXPIRATION_TIME_IN_MIN = 1;
	
	@Autowired
	private IUsuarioService usuarioService;
	@Autowired
	private SecretKey secretKey;
	
	public AuthController(IUsuarioService usuarioService, SecretKey secretKey) {
        this.usuarioService = usuarioService;
        this.secretKey = secretKey;
    }

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody UsuarioDTO credentials) {
		if (usuarioService.findUser(credentials.getNombre_usuario(), credentials.getContraseña()) != null) {
			String token = Jwts.builder().setSubject(credentials.getNombre_usuario()).setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME_IN_MIN * 60 * 1000))
					.signWith(secretKey, SignatureAlgorithm.HS256).compact();

			return new ResponseEntity<>(token, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Credenciales invalidas.", HttpStatus.UNAUTHORIZED);
		}
	}

}
