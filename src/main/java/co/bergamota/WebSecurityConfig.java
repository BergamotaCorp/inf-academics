package co.bergamota;

import co.bergamota.business.objects.Usuario;
import co.bergamota.dataaccess.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/css/**","/js/**").permitAll();
        //http
//                .authorizeRequests()
//                .antMatchers("/", "/home").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login/index")
//                .permitAll()
//                .and()
//                .logout()
        http.authorizeRequests().antMatchers("/**").permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Autowired
            UsuarioRepository usuarioRepository;
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Usuario usuario = this.usuarioRepository.findByNomeusuario(username);
                return new UserDetails() {
                    @Override
                    public Collection<? extends GrantedAuthority> getAuthorities() {
                        return null;
                    }

                    @Override
                    public String getPassword() {
                        return usuario.getSenha();
                    }

                    @Override
                    public String getUsername() {
                        return usuario.getNomeusuario();
                    }

                    @Override
                    public boolean isAccountNonExpired() {
                        return usuario.isAtivo();
                    }

                    @Override
                    public boolean isAccountNonLocked() {
                        return usuario.isAtivo();
                    }

                    @Override
                    public boolean isCredentialsNonExpired() {
                        return usuario.isAtivo();
                    }

                    @Override
                    public boolean isEnabled() {
                        return usuario.isAtivo();
                    }
                };
            }
        });
    }
}
