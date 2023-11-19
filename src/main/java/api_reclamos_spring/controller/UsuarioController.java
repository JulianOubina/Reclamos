package api_reclamos_spring.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import api_reclamos_spring.model.dto.UsuarioDTO;
import api_reclamos_spring.model.entity.Usuario;
import api_reclamos_spring.service.IUsuarioService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;

	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody Usuario usuario) {
		System.out.println(usuario.getNombre_usuario());

		String plainPassword = usuario.getContraseña();

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(plainPassword);
		usuario.setContraseña(hashedPassword);

		Usuario existingUser = usuarioService.findByUsername(usuario.getNombre_usuario());
		if (existingUser != null) {
			String mensaje = "El nombre de usuario '" + usuario.getNombre_usuario() + "' ya está en uso";
			return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
		}

		usuarioService.save(usuario);

		return new ResponseEntity<>(usuario, HttpStatus.CREATED);
	}

	@GetMapping({"/search"})
	public List<UsuarioDTO> findAll(){
		List<Usuario> usuarios = usuarioService.findAll();
        List<UsuarioDTO> usuarioDTOs = new ArrayList<>();

        for (Usuario usuario : usuarios) {
        	UsuarioDTO usuarioDTO = convertToDTO(usuario);
        	usuarioDTOs.add(usuarioDTO);
        }

        return usuarioDTOs;
	}

	@GetMapping("/searchId/{usuarioId}")
	public ResponseEntity<?> getUsuario(@PathVariable int usuarioId) {
		Usuario usuario = usuarioService.findById(usuarioId);		

		if (usuario == null) {
			String mensaje = "Usuario no encontrado con ID: " + usuarioId;
			return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
		}

		UsuarioDTO usuarioDTO = convertToDTO(usuario);
		return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
	}

	@GetMapping("/searchUsername/{nombre_usuario}")
	public ResponseEntity<?> getUsuarioByNombreUsuario(@PathVariable String nombre_usuario) {
		Usuario usuario = usuarioService.findByUsername(nombre_usuario);

		if (usuario == null) {
			String mensaje = "Usuario no encontrado con ese nombre de usuario: " + nombre_usuario;
			return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
		}

		UsuarioDTO usuarioDTO = convertToDTO(usuario);
		return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<UsuarioDTO> addUsuario(@RequestBody UsuarioDTO usuarioDTO) {

		String plainPassword = usuarioDTO.getContraseña();
		System.out.println(plainPassword);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(plainPassword);
		System.out.println(hashedPassword);
		usuarioDTO.setContraseña(hashedPassword);

		System.out.println(passwordEncoder.matches(plainPassword, hashedPassword));
		Usuario usuarioNew = convertToEntity(usuarioDTO);

		usuarioService.save(usuarioNew);
		
		UsuarioDTO nuevoClienteDTO = convertToDTO(usuarioNew);

		return new ResponseEntity<>(nuevoClienteDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{usuarioId}")
	public ResponseEntity<?> updateUsuario(@PathVariable int usuarioId, @RequestBody UsuarioDTO usuarioDTO) {

		Usuario usuarioOld = usuarioService.findById(usuarioId);

		if (usuarioOld == null) {
			String mensaje = "Usuario no encontrado con ID: " + usuarioId;
			return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
		}

		Usuario usuarioToUpdate = convertToEntity(usuarioDTO);
		usuarioService.update(usuarioId, usuarioToUpdate);
		
		UsuarioDTO usuarioUpdatedDTO = convertToDTO(usuarioToUpdate);
		return new ResponseEntity<>(usuarioUpdatedDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{usuarioId}")
	public ResponseEntity<String> deleteUsuario(@PathVariable int usuarioId) {

		Usuario usuario = usuarioService.findById(usuarioId);

		if (usuario == null) {
			String mensaje = "Usuario no encontrado con ID: " + usuarioId;
			return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
		}

		usuarioService.deleteById(usuarioId);

		String mensaje = "Usuario eliminado [usuarioId: " + usuarioId + "]";
		return new ResponseEntity<>(mensaje, HttpStatus.OK);
	}

	private UsuarioDTO convertToDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getNombre_usuario(), usuario.getContraseña(), usuario.getTipo());
		return usuarioDTO;
	}

	private Usuario convertToEntity(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();

		usuario.setNombre_usuario(usuarioDTO.getNombre_usuario());
		usuario.setContraseña(usuarioDTO.getContraseña());
		usuario.setTipo(usuarioDTO.getTipo());

		return usuario;
	}
}


