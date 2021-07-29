package tlacuariders.mx.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tlacuariders.mx.models.UsuariosModel;
import tlacuariders.mx.repositories.UsuariosRepository;

@Service
public class UsuariosService {
	 
	@Autowired
	UsuariosRepository usuariosRepository;
	

	
	public ArrayList<UsuariosModel> getUsers() {
		return (ArrayList<UsuariosModel>) usuariosRepository.findAll();
	}
	
	public UsuariosModel saveUser(UsuariosModel user) {
		return usuariosRepository.save(user);
		
		
	}
	
	public boolean deleteUser(Integer id) {
		try {
			usuariosRepository.deleteById(id);
			return true;
		}catch(Exception error) {
			return false;
		}
	}
	
	public ArrayList<UsuariosModel> getUsersByName(String name){
		return usuariosRepository.findByNombre(name);
	}
	
	
	public Optional<UsuariosModel> getUserById(int id) {
		return usuariosRepository.findById(id);
	}
}
