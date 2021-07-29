package tlacuariders.mx.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tlacuariders.mx.models.CodigoPostalModel;
import tlacuariders.mx.services.CodigoPostalService;

@RestController
@RequestMapping ("/codigo_postal")
public class CodigoPostalControllers {
	
	@Autowired
	CodigoPostalService services;
	
	@GetMapping(path = "/{id}")
	public Optional<CodigoPostalModel> getCodigoPostalById(@PathVariable("id")
	Integer id){
		return services.getCodigoPostalById(id);
	}
	@PostMapping
	public CodigoPostalModel saveCodigoPostal(@RequestBody CodigoPostalModel 
			CodigoPostal) {
		return services.saveCodigoPostal(CodigoPostal);
	}
}
