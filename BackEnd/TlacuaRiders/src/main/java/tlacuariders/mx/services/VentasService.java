package tlacuariders.mx.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tlacuariders.mx.models.VentasModel;
import tlacuariders.mx.repositories.VentasRepository;

@Service
public class VentasService {
	
	@Autowired
	VentasRepository ventasRepository;
	
	public ArrayList<VentasModel> getVentas() {
		return (ArrayList<VentasModel>) ventasRepository.findAll();
	}
	
	public VentasModel saveVenta(VentasModel user) {
		return ventasRepository.save(user);
	}
	
	public boolean deleteVenta(Integer id) {
		try {
			ventasRepository.deleteById(id);
			return true;
		}catch(Exception error) {
			return false;
		}
	}
	
	public Optional<VentasModel> getVentaById(int id) {
		return ventasRepository.findById(id);
	}

}
