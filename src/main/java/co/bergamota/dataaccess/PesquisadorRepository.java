package co.bergamota.dataaccess;

import co.bergamota.business.objects.Pesquisador;
import org.springframework.data.repository.CrudRepository;

public interface PesquisadorRepository extends CrudRepository<Pesquisador, Long> {
    Pesquisador findByNomepesquisador(String nomePesquisador);
}