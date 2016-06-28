package co.bergamota.business.objects;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pesquisador")
public class Pesquisador {
    @Id
    @GeneratedValue
    private long idpesquisador;
    private String nomepesquisador;
    private Date datacadastro;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    @JsonManagedReference
    private Usuario usuario;
    @ManyToMany(mappedBy="pesquisadores")
    @JsonBackReference
    private List<Publicacao> publicacacoes;

    public long getIdpesquisador() {
        return idpesquisador;
    }
    public void setIdpesquisador(long idpesquisador) {
        this.idpesquisador = idpesquisador;
    }
    public String getNomepesquisador() {
        return nomepesquisador;
    }
    public void setNomepesquisador(String nomepesquisador) {
        this.nomepesquisador = nomepesquisador;
    }
    public Date getDatacadastro() {
        return datacadastro;
    }
    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }
}