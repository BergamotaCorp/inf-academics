package co.bergamota.dataaccess;

import co.bergamota.business.objects.Usuario;
import org.springframework.data.repository.CrudRepository;

public abstract class UsuarioRepository implements CrudRepository<Usuario, Long> {

    public Usuario findByUsername(String username){
        //this.findAll().
    }

}