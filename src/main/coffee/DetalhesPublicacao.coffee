
class DetalhesPublicacao
  constructor : () ->
    if $('.detallhes-publicacao-container').length > 0
      urlRegex = /(https?:\/\/[^\s<]+)/g;
      html = $('.detallhes-publicacao-container').html()?.replace urlRegex, (url) ->
        "<a target='_blank' href=\"#{url}\">#{url}</a>"
      $('.detallhes-publicacao-container').html(html)

new DetalhesPublicacao()