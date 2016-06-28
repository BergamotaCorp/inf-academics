package co.bergamota.business.objects;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    private long idpesquisador;
    private String nomeusuario;
    private String senha;
    private boolean ativo;
    private Date datacriacao;

    public long getIdpesquisador() {
        return idpesquisador;
    }

    public void setIdpesquisador(long idpesquisador) {
        this.idpesquisador = idpesquisador;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(Date datacriacao) {
        this.datacriacao = datacriacao;
    }
}