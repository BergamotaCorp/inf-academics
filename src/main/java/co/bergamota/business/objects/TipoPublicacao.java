package co.bergamota.business.objects;


import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;

@Entity
@Table(name = "tipopublicacao")
public class TipoPublicacao {
    @Id
    private long idtipopublicacao;
    private String nometipopublicacao;


    @OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "idtipopublicacao")
    @JsonBackReference
    private Publicacao publicacao;

    public long getIdtipopublicacao() {
        return idtipopublicacao;
    }

    public void setIdtipopublicacao(long idtipopublicacao) {
        this.idtipopublicacao = idtipopublicacao;
    }

    public String getNometipopublicacao() {
        return nometipopublicacao;
    }

    public void setNometipopublicacao(String nometipopublicacao) {
        this.nometipopublicacao = nometipopublicacao;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }
}