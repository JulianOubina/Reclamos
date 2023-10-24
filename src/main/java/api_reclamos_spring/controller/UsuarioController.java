package api_reclamos_spring.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api_reclamos_spring.model.dto.UsuarioDTO;
import api_reclamos_spring.model.entity.Usuario;
import api_reclamos_spring.service.IUsuarioService;


@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping({ "/usuarios", ""})
	public List<UsuarioDTO> findAll(){
		List<Usuario> usuarios = usuarioService.findAll();
        List<UsuarioDTO> usuarioDTOs = new ArrayList<>();

        for (Usuario usuario : usuarios) {
        	UsuarioDTO usuarioDTO = convertToDTO(usuario);
        	usuarioDTOs.add(usuarioDTO);
        }

        return usuarioDTOs;
	}
	
	@GetMapping("/usuarios/{usuarioId}")
	public ResponseEntity<?> getUsuario(@PathVariable int usuarioId) {
		Usuario usuario = usuarioService.findById(usuarioId);		

		if (usuario == null) {
			String mensaje = "Usuario no encontrado con ID: " + usuarioId;
			return new ResponseEntity<>(mensaje, HttpStatus.NOT_FOUND);
		}

		UsuarioDTO usuarioDTO = convertToDTO(usuario);
		return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<UsuarioDTO> addUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		
		Usuario usuarioNew = convertToEntity(usuarioDTO);
		
		usuarioService.save(usuarioNew);
		
		UsuarioDTO nuevoClienteDTO = convertToDTO(usuarioNew);

		return new ResponseEntity<>(nuevoClienteDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/usuarios/{usuarioId}")
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
	
	@DeleteMapping("usuarios/{usuarioId}")
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
		UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getNombre_usuario(), usuario.getContraseña());
		return usuarioDTO;
	}
	
	private Usuario convertToEntity(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		
		usuario.setNombre(usuarioDTO.getNombre_usuario());
		usuario.setApellido(usuarioDTO.getContraseña());

		return usuario;
	}
}


