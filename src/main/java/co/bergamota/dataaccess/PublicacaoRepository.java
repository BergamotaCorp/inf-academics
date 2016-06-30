package co.bergamota.dataaccess;

import co.bergamota.business.objects.Publicacao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PublicacaoRepository extends CrudRepository<Publicacao, Long>
{
    @Query("select distinct p " +
            "from Publicacao p " +
            "left join p.campos pc " +
            "left join p.pesquisadores pe " +
            "left join p.tipoPublicacao tp " +
            "where p.nomepublicacao like %?1||'%' " +
            "or p.atributos like %?1||'%' " +
            "or p.ano like %?1||'%' " +
            "or pc.valorcampo like %?1||'%'" +
            "or pe.nomepesquisador like %?1||'%'"+
            "or tp.nometipopublicacao like %?1||'%'"
    )
    List<Publicacao> search(String search);
}