
class EditarPublicacao
  @msidpesquisador : null
  @msidtipopublicacao : null
  @msano: null
  constructor : () ->
    EditarPublicacao.msidpesquisador = $('#idpesquisador').magicSuggest
      resultAsString : true
      valueField: 'idpesquisador'
      displayField: 'nomepesquisador'
      data:'/api/pesquisadores/getAll'
    EditarPublicacao.msidtipopublicacao = $('#idtipopublicacao').magicSuggest
      resultAsString : true
      maxSelection: 1
      valueField: 'idtipopublicacao'
      displayField: 'nometipopublicacao'
      data:'/api/tipopublicacoes/getAll'
    EditarPublicacao.msano = $('#ano').magicSuggest
      resultAsString : true
      maxSelection: 1
      data: [1900..2016].map (n) -> "#{n}"
    if AddPesquisadoresToSelection?
      AddPesquisadoresToSelection()
    if AddTipoPublicacaoToSelection?
      AddTipoPublicacaoToSelection()
    if AddAnoToSelection?
      AddAnoToSelection()

new EditarPublicacao()
