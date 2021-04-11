var resultWithQuotes = regex.findAll(inputString).map { result -> result.value }.toList()
println(resultWithQuotes)
val resultWithoutQuotes: MutableList<String> = mutableListOf()
resultWithQuotes.forEach {
    resultWithoutQuotes += it.replace("\"", "")
}
println(resultWithoutQuotes)
