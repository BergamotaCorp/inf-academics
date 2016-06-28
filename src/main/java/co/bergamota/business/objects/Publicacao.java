package co.bergamota.business.objects;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "publicacao")
public class Publicacao {
    @Id
    private long idpublicacao;
    private long idtipopublicacao;
    private String nomepublicacao;
    private String atributos;
    private Integer ano;
    private Date datacadastro;

    public long getIdpublicacao() {
        return idpublicacao;
    }

    public void setIdpublicacao(long idpublicacao) {
        this.idpublicacao = idpublicacao;
    }

    public long getIdtipopublicacao() {
        return idtipopublicacao;
    }

    public void setIdtipopublicacao(long idtipopublicacao) {
        this.idtipopublicacao = idtipopublicacao;
    }

    public String getNomepublicacao() {
        return nomepublicacao;
    }

    public void setNomepublicacao(String nomepublicacao) {
        this.nomepublicacao = nomepublicacao;
    }

    public String getAtributos() {
        return atributos;
    }

    public void setAtributos(String atributos) {
        this.atributos = atributos;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }
}