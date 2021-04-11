fun listWithoutQuotes() {
    val resultWithQuotes = mutableListOf(
        "\"Block\":\"A\"",
        "\"Floor\":1",
        "\"ID\":1",
        "\"Reading\":\"123123.42\"",
        "\"date\":\"2020.01.07\"",
        "\"path\":\"/storage/emulated/0/Pictures/1578377524095.jpg\""
    )
    val resultWithoutQuotes: MutableList<String> = mutableListOf()
    println(resultWithQuotes)
    resultWithQuotes.forEach {
        resultWithoutQuotes += it.replace("\"", "")
    }
    println(resultWithoutQuotes)
}

fun getWaterMeterReadingList(
    viewRecordMain: ViewRecordMain,
    block: String,
    floor: String,
    unit: String,
    date: String
): ArrayAdapter<String> {

    var fileName = viewRecordMain.filesDir.absolutePath + "/UnitJson.json"

    val inputStream: InputStream = File(fileName).inputStream()

    // Read the text from buffferReader and store in String variable
    val inputString = inputStream.bufferedReader().use { it.readText() }

    var regex = Regex(
        "\"Block\":\"(" + block + ")\",\"Floor\":(" + floor + "),\"ID\":(" + unit + "),\"Reading\":\"(\\S+)\",\"date\":\"(" + date + ")\",\"path\":\"(\\S+)\"",
        RegexOption.MULTILINE
    )
    var resultWithQuotes = regex.findAll(inputString).map { result -> result.value }.toList()
    println(resultWithQuotes)
    val resultWithoutQuotes: MutableList<String> = mutableListOf()
    resultWithQuotes.forEach {
        resultWithoutQuotes += it.replace("\"", "")
    }
    println(resultWithoutQuotes)
    var adapter = ArrayAdapter<String>(viewRecordMain, R.layout.listview, resultWithQuotes)

    return adapter
}
