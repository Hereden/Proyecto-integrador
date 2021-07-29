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
import org.springframework.web.bind.annotation.RestController;
import tlacuariders.mx.models.ArticulosModel;
import tlacuariders.mx.services.ArticulosService;



@RestController
@RequestMapping("/articulos")
public class ArticulosController {
	
	@Autowired
	ArticulosService articulosService;
	
	@GetMapping
	public ArrayList<ArticulosModel> getArticulos(){
		return articulosService.getArticulos();
	}
	
	@PostMapping
	public ArticulosModel saveArticulos(@RequestBody ArticulosModel articulos) {
		return articulosService.saveArticulos(articulos);
	}
	
	@GetMapping(path="/{id}")
	public Optional<ArticulosModel> getUserById(@PathVariable("id") Integer id){
		return articulosService.getArticulosById(id);
	}
	
	@DeleteMapping(path="/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		boolean ok=articulosService.deleteArticulo(id);
		if (ok) {
			return "El artículo no se pudo borrar";
		}else {
			return "El artículo no existe o no se pudo borrar";
		}
	}
	
}
