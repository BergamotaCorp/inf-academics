package co.bergamota.business.objects;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipopublicacao")
public class TipoPublicacao {
    @Id
    @GeneratedValue
    private long idtipopublicacao;
    private String nometipopublicacao;

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
}