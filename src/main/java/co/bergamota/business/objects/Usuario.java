package co.bergamota.business.objects;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue
    @Column(name = "idpesquisador")
    private long idusuario;
    private String nomeusuario;
    private String senha;
    private Integer ativo;
    private Date datacriacao;
    @OneToOne(mappedBy = "usuario")
    @JoinColumn(name = "idpesquisador")
    @JsonBackReference
    private Pesquisador pesquisador;

    public long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(long idpesquisador) {
        this.idusuario = idpesquisador;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }
    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }
    public String getSenha() {
        return new BCryptPasswordEncoder().encode(senha);
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public boolean isAtivo() {
        return ativo == 1;
    }
    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }
    public Date getDatacriacao() {
        return datacriacao;
    }
    public void setDatacriacao(Date datacriacao) {
        this.datacriacao = datacriacao;
    }
    public Pesquisador getPesquisador() {
        return pesquisador;
    }
    public void setPesquisador(Pesquisador pesquisador) {
        this.pesquisador = pesquisador;
    }
}