package co.bergamota.modelview;


import co.bergamota.business.objects.Pesquisador;
import co.bergamota.business.objects.TipoPublicacao;
import co.bergamota.dataaccess.PesquisadorRepository;
import co.bergamota.dataaccess.TipoPublicacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class PublicacaoModelView {
    private HttpServletRequest request;
    private boolean isValid = true;
    private List<Pesquisador> idpesquisador = new ArrayList<>();
    private TipoPublicacao tipopublicacao;
    private String nomepublicacao;
    private String campos;
    private Integer anopublicacao;
    private String publicador;
    private String atributos;

    private PesquisadorRepository pesquisadorRepository;
    private TipoPublicacaoRepository tipoPublicacaoRepository;

    public PublicacaoModelView() {}

    public PublicacaoModelView(HttpServletRequest request, PesquisadorRepository pesquisadorRepository, TipoPublicacaoRepository tipoPublicacaoRepository)
    {
        this.request = request;

        if(request.getParameterMap().containsKey("idpesquisador[]")){
            String[] _idpesquisador = request.getParameterValues("idpesquisador[]");
            for(String _id : _idpesquisador){
                Long _lid = tryParseLong(_id);
                if(_lid != null) idpesquisador.add(pesquisadorRepository.findOne(_lid));
            }
        }

        if(request.getParameterMap().containsKey("idtipopublicacao[]")){
            Long _idpesquisador = tryParseLong(request.getParameter("idtipopublicacao[]"));
            tipopublicacao = _idpesquisador != null ? tipoPublicacaoRepository.findOne(_idpesquisador) : null;
        }

        if(request.getParameterMap().containsKey("ano[]")){
            Long _ano = tryParseLong(request.getParameter("ano[]"));
            setAnopublicacao(_ano.intValue());
        }

        if(request.getParameterMap().containsKey("nomepublicacao")){
            setNomepublicacao(request.getParameter("nomepublicacao"));
        }

        if(request.getParameterMap().containsKey("publicador")){
            setPublicador(request.getParameter("publicador"));
        }
    }

    private Long tryParseLong(String _id) {
        try{
            return Long.parseLong(_id);
        }catch (NumberFormatException e){
            return null;
        }
    }

    public boolean isValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public List<Pesquisador> getIdpesquisador() {
        return idpesquisador;
    }

    public void setIdpesquisador(List<Pesquisador> idpesquisador) {
        this.idpesquisador = idpesquisador;
    }

    public TipoPublicacao getTipopublicacao() {
        return tipopublicacao;
    }

    public void setTipopublicacao(TipoPublicacao tipopublicacao) {
        this.tipopublicacao = tipopublicacao;
    }

    public String getNomepublicacao() {
        return nomepublicacao;
    }

    public void setNomepublicacao(String nomepublicacao) {
        this.nomepublicacao = nomepublicacao;
    }

    public String getCampos() {
        return campos;
    }

    public void setCampos(String campos) {
        this.campos = campos;
    }

    public Integer getAnopublicacao() {
        return anopublicacao;
    }

    public void setAnopublicacao(Integer anopublicacao) {
        this.anopublicacao = anopublicacao;
    }

    public String getPublicador() {
        return publicador;
    }

    public void setPublicador(String publicador) {
        this.publicador = publicador;
    }

    public String getAtributos() {
        return atributos;
    }

    public void setAtributos(String atributos) {
        this.atributos = atributos;
    }
}
