package co.bergamota.business.objects;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "publicacaocampos")
public class PublicacaoCampos {
	
	    @Id
	    private long idpublicacaocampos;
	    private String nomecampo;
	    private long idpublicacao;

	    public long getIdPublicacaoCampos() {
	        return idpublicacaocampos;
	    }

	    public void setIdPublicacaoCampos(long idpublicacaocampos) {
	        this.idpublicacaocampos = idpublicacaocampos;
	    }

	    public String getNomeCampo() {
	        return nomecampo;
	    }

	    public void setNomeCampo(String nomecampo) {
	        this.nomecampo = nomecampo;
	    }
	    
	    public long getIdPublicacao() {
	        return idpublicacao;
	    }

	    public void setIdPublicacao(long idpublicacao) {
	        this.idpublicacao = idpublicacao;
	    }

	    

}
