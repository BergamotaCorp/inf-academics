
class CadastrarPublicacao
  constructor : () ->
    ms = $('#idpesquisador').magicSuggest
      resultAsString : true
      valueField: 'idpesquisador'
      displayField: 'nomepesquisador'
      data:'/api/pesquisadores/getAll'
    $('#idtipopublicacao').magicSuggest
      resultAsString : true
      maxSelection: 1
      valueField: 'idtipopublicacao'
      displayField: 'nometipopublicacao'
      data:'/api/tipopublicacoes/getAll'
    $('#ano').magicSuggest
      resultAsString : true
      maxSelection: 1
      data: [1900..2016].map (n) -> "#{n}"

new CadastrarPublicacao()