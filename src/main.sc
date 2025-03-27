require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        a: Здравствуйте! Я бот-помощник. Вы можете спросить меня про погоду или курсы валют
        event: noMatch || toState = "/NoMatch"

    state: Hello
        intent!: /привет
        a: Привет привет. Я бот-помощник. Вы можете спросить меня про погоду или курсы валют.
        event: noMatch || toState = "/NoMatch"

    state: Weather
        intent!: /погода
        a: Введите название города, для которого хотите узнать погоду.
        go: /CityInput
        event: noMatch || toState = "./"

    state: CityInput
        intent!: /Город
        a: Погода в {{$request.query}}: +15°C, солнечно.
        go!: /Bye
        event: noMatch || toState = "/NoMatch"

    state: Currency
        intent!: /currency
        a: Введите код валюты (например, USD, EUR), чтобы узнать курс.
        go!: /CurrencyInput
        event: noMatch || toState = "/NoMatch"

    state: CurrencyInput
        intent!: /валюта
        a: Курс {{$request.query}} к рублю: 90.5.
        go!: /Bye
        event: noMatch || toState = "/NoMatch"

    state: Bye
        intent!: /пока
        a: Пока пока

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

    state: Match
        event!: match
        a: {{$context.intent.answer}}
        
        