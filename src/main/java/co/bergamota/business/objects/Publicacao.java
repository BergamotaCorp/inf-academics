package co.bergamota.business.objects;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "publicacao")
public class Publicacao {
    @Id
    private long idpublicacao;
    private String nomepublicacao;
    private String atributos;
    private Integer ano;
    private Date datacadastro;
    @OneToMany(mappedBy="publicacao")
    @JsonManagedReference
    private List<PublicacaoCampos> campos;
    @ManyToMany
    @JoinTable(name = "publicacaopesquisador",
            joinColumns = {@JoinColumn(name = "idpublicacao")},
            inverseJoinColumns = {@JoinColumn(name = "idpesquisador")}
    )
    @JsonManagedReference
    private List<Pesquisador> pesquisadores;

    @OneToOne(mappedBy = "publicacao")
    @JsonManagedReference
    private TipoPublicacao tipoPublicacao;

    public long getIdpublicacao() {
        return idpublicacao;
    }
    public void setIdpublicacao(long idpublicacao) {
        this.idpublicacao = idpublicacao;
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

    public List<PublicacaoCampos> getCampos() {
        return campos;
    }

    public void setCampos(List<PublicacaoCampos> campos) {
        this.campos = campos;
    }

    public TipoPublicacao getTipoPublicacao() {
        return tipoPublicacao;
    }

    public void setTipoPublicacao(TipoPublicacao tipoPublicacao) {
        this.tipoPublicacao = tipoPublicacao;
    }
}