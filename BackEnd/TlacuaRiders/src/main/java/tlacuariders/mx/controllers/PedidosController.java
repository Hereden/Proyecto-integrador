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
import tlacuariders.mx.models.PedidosModel;
import tlacuariders.mx.services.PedidosService;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {
	 
	@Autowired
	PedidosService pedidosService;
	
	@GetMapping
	public ArrayList<PedidosModel> getPedidos(){
		return pedidosService.getPedidos();
	}
	
	@PostMapping
	public PedidosModel savePedidos(@RequestBody PedidosModel pedidos) {
		return pedidosService.savePedidos(pedidos);
	}
	
	
	@GetMapping(path="/{id}")
	public Optional<PedidosModel> getUserById(@PathVariable("id") Integer id){
		return pedidosService.getPedidosById(id);
	}
	
	@DeleteMapping(path="/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		boolean ok=pedidosService.deletePedidos(id);
		if (ok) {
			return "El pedido no se pudo borrar";
		}else {
			return "El pedido no existe o no se pudo borrar";
		}
	}
}
