package co.bergamota.business.objects;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipopublicacao")
public class TipoPublicacao {
    @Id
    private long idtipopublicacao;
    private String nometipopublicacao;
    
    public long getIdTipopublicacao() {
        return idtipopublicacao;
    }

    public void setIdpublicacao(long idtipopublicacao) {
        this.idtipopublicacao = idtipopublicacao;
    }
    
    public String getNomeTipopublicacao() {
        return nometipopublicacao;
    }

    public void setNomeTipopublicacao(String nometipopublicacao) {
        this.nometipopublicacao = nometipopublicacao;
    }

}