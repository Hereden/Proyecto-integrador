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

import tlacuariders.mx.models.VentasModel;
import tlacuariders.mx.services.VentasService;

@RestController
@RequestMapping("/ventas")
public class VentasController {

	@Autowired
	VentasService ventasService;
	
	@GetMapping
	public ArrayList<VentasModel> getVentas(){
		return ventasService.getVentas();
	}
	
	@PostMapping
	public VentasModel saveVenta(@RequestBody VentasModel venta) {
		return ventasService.saveVenta(venta);
	}
	
	
	@GetMapping(path="/{id}")
	public Optional<VentasModel> getUserById(@PathVariable("id") Integer id){
		return ventasService.getVentaById(id);
	}
	
	@DeleteMapping(path="/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		boolean ok=ventasService.deleteVenta(id);
		if (ok) {
			return "La venta no se pudo borrar";
		}else {
			return "El venta no existe o no se pudo borrar";
		}
	}

}
