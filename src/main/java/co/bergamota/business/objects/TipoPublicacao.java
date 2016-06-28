package co.bergamota.business.objects;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "tipopublicacao")
public class TipoPublicacao {
    @Id
    private long idtipopublicacao;


}