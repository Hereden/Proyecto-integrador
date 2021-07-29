package tlacuariders.mx.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tlacuariders.mx.models.CodigoPostalModel;

@Repository
public interface CodigoPostalRepository extends CrudRepository
<CodigoPostalModel, Integer>
{

}
