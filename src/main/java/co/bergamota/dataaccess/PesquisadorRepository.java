package co.bergamota.dataaccess;

import co.bergamota.business.objects.Pesquisador;
import co.bergamota.business.objects.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface PesquisadorRepository extends CrudRepository<Pesquisador, Long> {

}