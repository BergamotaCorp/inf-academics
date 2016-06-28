package co.bergamota.business.objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "publicacaopesquisador")
public class PublicacaoPesquisador {
	    @Id
	    private long idpublicacao;
	    private long idpesquisador;
	    
	    public long getIdpublicacao() {
	        return idpublicacao;
	    }

	    public void setIdpublicacao(long idpublicacao) {
	        this.idpublicacao = idpublicacao;
	    }
	    
	    public long getIdpesquisador() {
	        return idpesquisador;
	    }

	    public void setIdpesquisador(long idpesquisador) {
	        this.idpesquisador = idpesquisador;
	    }

}
