package co.bergamota.business.objects;




import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


@Entity
@Table(name = "publicacaocampos")
public class PublicacaoCampos {
	
	@Id
	private long idpublicacaocampos;
	private String nomecampo;
	private String valorcampo;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idpublicacao")
	@JsonBackReference
	private Publicacao publicacao;

	public long getIdpublicacaocampos() {
		return idpublicacaocampos;
	}

	public void setIdpublicacaocampos(long idpublicacaocampos) {
		this.idpublicacaocampos = idpublicacaocampos;
	}

	public String getNomecampo() {
		return nomecampo;
	}

	public void setNomecampo(String nomecampo) {
		this.nomecampo = nomecampo;
	}

	public String getValorcampo() {
		return valorcampo;
	}

	public void setValorcampo(String valorcampo) {
		this.valorcampo = valorcampo;
	}

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}
}
