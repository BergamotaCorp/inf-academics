package co.bergamota.services;

import co.bergamota.business.objects.Credenciais;
import co.bergamota.business.objects.Usuario;
import co.bergamota.dataaccess.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrentUserDetailsService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public CurrentUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Credenciais loadUserByUsername(String nomeusuario) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByNomeusuario(nomeusuario);
        return new Credenciais(user);
    }
}