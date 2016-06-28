package co.bergamota.business.objects;


import org.springframework.context.annotation.Role;
import org.springframework.security.core.authority.AuthorityUtils;

import java.lang.annotation.Annotation;

public class Credenciais extends org.springframework.security.core.userdetails.User{
    private Usuario usuario;

    public Credenciais(Usuario usuario) {
        super(usuario.getNomeusuario(), usuario.getSenha(), AuthorityUtils.createAuthorityList(new String[]{"ADMIN"}));
        this.usuario = usuario;
    }

    public Usuario getUser() {
        return usuario;
    }

    public Long getId() {
        return usuario.getIdusuario();
    }

    public Role getRole() {
        return new Role(){

            @Override
            public Class<? extends Annotation> annotationType() {
                return null;
            }

            @Override
            public int value() {
                return 1;
            }
        };
    }

}
