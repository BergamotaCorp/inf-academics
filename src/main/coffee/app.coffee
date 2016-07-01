
class Publicacoes
  @searchTimeout : null
  constructor : () ->
    $('.search-trigger').click () =>
      this.search $('input[name="search-value"]').val()
    $('input[name="search-value"]').on 'keyup', () =>
      if Publicacoes.searchTimeout != null
        clearTimeout Publicacoes.searchTimeout
      Publicacoes.searchTimeout = setTimeout () =>
        Publicacoes.searchTimeout = null
        this.search $('input[name="search-value"]').val()
      , 200

  getAll : () ->
    $.get '/api/publicacoes/getAll', (data) ->
      container = $('.publicacoes-container')
      container.empty()
      data.forEach (item) ->
        container.append """
          <div class="row">
              <div class="col-xs-12">
                  <h2 style="border-bottom: solid 1px;">#{item.nomepublicacao}</h2>
                  <p><b>Autores</b> #{item.pesquisadores.map (el) => el.nomepesquisador}</p>
                  <p><a class="btn btn-secondary" href="/detalhes/#{item.idpublicacao}" role="button">Detalhes &raquo;</a></p>
              </div>
          </div>
        """

  search : (search) ->
    $.get "/api/publicacoes/search", search : search, (data) ->
      container = $('.publicacoes-container')
      container.empty()
      if data.length == 0
        container.append """
            <div class="row">
                <div class="col-xs-12">
                    <h2>Nenhum Resultado encontrado</h2>
                </div>
            </div>
          """
      else
        data.forEach (item) ->
          container.append """
            <div class="row">
                <div class="col-xs-12">
                    <h2 style="border-bottom: solid 1px;">#{item.nomepublicacao}</h2>
                    <p><b>Autores</b> #{item.pesquisadores.map (el) => el.nomepesquisador}</p>
                    <p><a class="btn btn-secondary" href="/detalhes/#{item.idpublicacao}" role="button">Detalhes &raquo;</a></p>
                </div>
            </div>
          """

new Publicacoes().getAll()