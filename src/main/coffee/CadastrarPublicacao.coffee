
class CadastrarPublicacao
  @loaded = 0
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

    $('#importar-bibtex').on 'click', () ->
      $('#bibtex-file').trigger 'click'
      $('#bibtex-file').on 'change', () ->
        formData = new FormData $('#bibtex-import-form')[0]
        $.ajax
          url: '/api/importar-publicacoes'
          type: 'POST'
          data: formData
          cache: false
          contentType: false
          processData: false
          xhr: () ->
            myXhr = $.ajaxSettings.xhr()
            if myXhr.upload
              myXhr.upload.addEventListener 'progress', (e) ->
                $('.uploading').show()
                CadastrarPublicacao.loaded += e.loaded
                $('.uploading progress').val Math.ceil((CadastrarPublicacao.loaded/e.total)*100)
              , false
            return myXhr
          success : completeHandler : (data) ->
            console.log data
        .done () ->
          window.location.href = '/';
        .error (jqXHR, error) ->
          $('.uploading').hide()
          error = jqXHR.responseText || "Talves seja muit grande."
          alert "Ocorreu um erro para fazer o upload do arquivo.\n\n #{error}"
          window.location.href = window.location.href

new CadastrarPublicacao()