package co.bergamota.dataaccess;

import co.bergamota.business.objects.Publicacao;
import org.springframework.data.repository.CrudRepository;

public interface PublicacaoRepository extends CrudRepository<Publicacao, Long> {

}