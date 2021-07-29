package tlacuariders.mx.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tlacuariders.mx.models.UsuariosModel;
 
@Repository
public interface UsuariosRepository extends CrudRepository<UsuariosModel,
Integer>
 {
	
	public abstract ArrayList<UsuariosModel> findByNombre(String nombre);

}
