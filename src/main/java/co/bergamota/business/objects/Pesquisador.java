package co.bergamota.business.objects;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pesquisador")
public class Pesquisador {
    @Id
    @GeneratedValue
    @Column(name = "idpesquisador")
    private long idpesquisador;
    private String nomepesquisador;
    private Date datacadastro;
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