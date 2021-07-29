package tlacuariders.mx.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tlacuariders.mx.models.ArticulosModel;

@Repository
public interface ArticulosRepository extends CrudRepository<ArticulosModel,
Integer>{
	 
	public abstract ArrayList<ArticulosModel> findByNombre(String nombre);

}
