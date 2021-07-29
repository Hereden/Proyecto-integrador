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
import tlacuariders.mx.models.RodadasModel;
import tlacuariders.mx.services.RodadasService;


@RestController
@RequestMapping("/rodadas")
public class RodadasController {
	

	@Autowired
	RodadasService rodadasService;
	
	@GetMapping
	public ArrayList<RodadasModel> getRodadas(){
		return rodadasService.getRodadas();
	}
	
	@PostMapping
	public RodadasModel saveRodadas(@RequestBody RodadasModel rodada) {
		return rodadasService.saveRodadas(rodada);
	}
	
	@GetMapping(path="/{id}")
	public Optional<RodadasModel> getRodadaById(@PathVariable("id") Integer id){
		return rodadasService.getRodadaById(id);
	}
	
	@DeleteMapping(path="/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		boolean ok=rodadasService.deleteRodadas(id);
		if (ok) {
			return "La rodada se pudo borrar";
		}else {
			return "La rodada no existe o no se pudo borrar";
		}
	}
	
	
	@GetMapping(path= "/query")
	public ArrayList<RodadasModel> getUsersByName(@RequestParam(value="name", defaultValue="") String name){
		return rodadasService.getRodadaByName(name);
	}

	
	
}
