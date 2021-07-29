package tlacuariders.mx.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tlacuariders.mx.models.PedidosModel;


@Repository
public interface PedidosRepository extends CrudRepository<PedidosModel,
Integer> {

}
