package tlacuariders.mx.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tlacuariders.mx.models.RodadasModel;


@Repository
public interface RodadasRepository extends CrudRepository<RodadasModel,
Integer> {
	
	public abstract ArrayList<RodadasModel> findByNombre(String nombre);

}
