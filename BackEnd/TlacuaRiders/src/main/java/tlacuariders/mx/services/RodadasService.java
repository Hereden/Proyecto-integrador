package tlacuariders.mx.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tlacuariders.mx.models.RodadasModel;
import tlacuariders.mx.repositories.RodadasRepository;

@Service
public class RodadasService {
	
	@Autowired
	RodadasRepository rodadasRepository;
	
	public ArrayList<RodadasModel> getRodadas() {
		return (ArrayList<RodadasModel>) rodadasRepository.findAll();
	}
	
	public RodadasModel saveRodadas(RodadasModel user) {
		return rodadasRepository.save(user);
	}
	
	public boolean deleteRodadas(Integer id) {
		try {
			rodadasRepository.deleteById(id);
			return true;
		}catch(Exception error) {
			return false;
		}
	}
	
	public ArrayList<RodadasModel> getRodadaByName(String name){
		return rodadasRepository.findByNombre(name);
	}

	public Optional<RodadasModel> getRodadaById(int id) {
		return rodadasRepository.findById(id);
	}

	}


	


