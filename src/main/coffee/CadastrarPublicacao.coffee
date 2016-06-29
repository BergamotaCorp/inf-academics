
class CadastrarPublicacao
  constructor : () ->
    $.get '/api/pesquisadores/getAll', (data) ->
      tokens = data.map (value) -> value.nomepesquisador
      $('#idpesquisador').tokenfield tokens

new CadastrarPublicacao()