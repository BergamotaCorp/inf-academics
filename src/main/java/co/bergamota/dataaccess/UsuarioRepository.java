package co.bergamota.dataaccess;

import co.bergamota.business.objects.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Usuario findByNomeusuario(String nomeusuario);

}