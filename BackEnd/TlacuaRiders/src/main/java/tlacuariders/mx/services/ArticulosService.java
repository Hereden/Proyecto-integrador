package tlacuariders.mx.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tlacuariders.mx.models.ArticulosModel;
import tlacuariders.mx.repositories.ArticulosRepository;

@Service
public class ArticulosService {
	

	@Autowired
	ArticulosRepository articulosRepository;
	
	public ArrayList<ArticulosModel> getArticulos() {
		return (ArrayList<ArticulosModel>) articulosRepository.findAll();
	}
	
	public ArticulosModel saveArticulos(ArticulosModel user) {
		return articulosRepository.save(user);
	}
	
	public boolean deleteArticulo(Integer id) {
		try {
			articulosRepository.deleteById(id);
			return true;
		}catch(Exception error) {
			return false;
		}
	}
	
	public Optional<ArticulosModel> getArticulosById(int id) {
		return articulosRepository.findById(id);
	}


	}

