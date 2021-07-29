package tlacuariders.mx.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tlacuariders.mx.models.UsuariosModel;
import tlacuariders.mx.services.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {
	
	@Autowired
	UsuariosService usuariosService;
	
	@GetMapping
	public ArrayList<UsuariosModel> getUsers(){
		return usuariosService.getUsers();
	}
	
	@PostMapping
	public UsuariosModel saveUser(@RequestBody UsuariosModel user) {
		return usuariosService.saveUser(user);
	}
	
	
	@GetMapping(path="/{id}")
	public Optional<UsuariosModel> getUserById(@PathVariable("id") Integer id){
		return usuariosService.getUserById(id);
	}
	
	@DeleteMapping(path="/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		boolean ok=usuariosService.deleteUser(id);
		if (ok) {
			return "El usuario se pudo borrar";
		}else {
			return "El usuario no existe o no se pudo borrar";
		}
	}
	
	
	@GetMapping(path= "/query")
	public ArrayList<UsuariosModel> getUsersByName(@RequestParam(value="nombre",
	defaultValue="") String nombre){
		return usuariosService.getUsersByName(nombre);
	}

	

}
