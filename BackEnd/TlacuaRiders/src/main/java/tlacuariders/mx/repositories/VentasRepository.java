package tlacuariders.mx.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tlacuariders.mx.models.VentasModel;

@Repository
public interface VentasRepository extends CrudRepository<VentasModel,
Integer>{

	
}
