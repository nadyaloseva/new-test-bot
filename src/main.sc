require: slotfilling/slotFilling.sc
  module = sys.zb-common

theme: /

    state: Start
        q!: $regex</start>
        a: Начнём!

    state: hello
        q!: * (привет/здравствуй*/~добрый (~утро/~день/~вечер/~ночь))*
        a: Привет!

    state: Bye
        q!: * (пока/до свидания*/~хороший (~утро/~день/~вечер/~ночь))*
        a: Пока

    state: NoMatch
        event!: noMatch
        a: Извините, я не понял:( Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}
        
    state: weather
        q!: * (~погода/~прогноз/завтра)*
        a: +4

    state: currency
        q!: * (~курс (~валюта)/валют*/~курс)*
        a: 100.03