package converter

import java.util.*

/**
 * Standard units enum class with several possible input strings
 */
enum class Unit(
    val s1: String,
    val s2: String,
    val s3: String,
    val s4: String,
    val s5: String,
    val unit: String,
    val type: String
) {
    METER("m", "M", "Meter","meter", "meter", "meters", "distance"),
    KILOMETER("km","KM", "Kilometer", "kilometer", "kilometer", "kilometers", "distance"),
    CENTIMETER("cm","CM", "Centimeter", "centimeter", "centimeter", "centimeters", "distance"),
    MILLIMETER("mm","MM", "Millimeter", "millimeter", "millimeter", "millimeters", "distance"),
    MILE("mi", "MI", "Mile","mile", "miles", "miles", "distance"),
    YARD("yd", "YD", "Yard","yard", "yards", "yards", "distance"),
    FOOT("ft", "FT", "Foot","foot", "feet", "feet", "distance"),
    INCH("in", "IN", "INCH","inch", "inches", "inches", "distance"),

    GRAM("G", "Gram", "g", "gram", "grams", "grams", "weight"),
    KILOGRAM("KG", "Kilogram", "kg", "kilogram", "kilogram", "kilograms", "weight"),
    MILLIGRAM("MG", "Milligram", "mg", "milligram", "milligram", "milligrams", "weight"),
    POUND("LB", "Pound", "lb", "pound", "pounds", "pounds", "weight"),
    OUNCE("OZ", "Ounce", "oz", "ounce", "ounces", "ounces", "weight"),

    CELSIUS("degree celsius", "celsius", "dc", "c", "degrees celsius", "degrees Celsius", "temperature"),
    FAHRENHEIT("degree fahrenheit", "fahrenheit", "df", "f", "degrees fahrenheit", "degrees Fahrenheit", "temperature"),
    KELVIN("degree kelvin", "degrees kelvin", "kelvin","k", "Kelvins", "kelvins", "temperature")
}

/**
 * Checks user input unit for the right one from enum class,
 * returns a pair of values: the unit type and the approved unit name
 */
fun unitApproved(unit: String): Pair<String, String> {
    var unitType = "unknown"
    var unitApproved = "???"
    for (enum in Unit.values()) {
        if (unit == enum.s1 ||
            unit == enum.s2 ||
            unit == enum.s3 ||
            unit == enum.s4 ||
            unit == enum.s5 ||
            unit == enum.unit
        ) {
            unitType = enum.type
            unitApproved = enum.unit
        }
    }
    return Pair(unitType, unitApproved)
}

/**
 * Converts distance values through "meter" and prints the result in a certain formatting
 */
fun convertDistance(measureFrom: String, measureTo: String, number: Double) {
    var toMeters: Double = 0.0
    when (measureFrom) {
        "meters" -> {
            toMeters = number
            print("$number ${if (number == 1.0) "meter" else "meters"} is ")
        }
        "kilometers" -> {
            toMeters = number * 1000
            print("$number ${if (number == 1.0) "kilometer" else "kilometers"} is ")
        }
        "centimeters" -> {
            toMeters = number * 0.01
            print("$number ${if (number == 1.0) "centimeter" else "centimeters"} is ")
        }
        "millimeters" -> {
            toMeters = number * 0.001
            print("$number ${if (number == 1.0) "millimeter" else "millimeters"} is ")
        }
        "miles" -> {
            toMeters = number * 1609.35
            print("$number ${if (number == 1.0) "mile" else "miles"} is ")
        }
        "yards" -> {
            toMeters = number * 0.9144
            print("$number ${if (number == 1.0) "yard" else "yards"} is ")
        }
        "feet" -> {
            toMeters = number * 0.3048
            print("$number ${if (number == 1.0) "foot" else "feet"} is ")
        }
        "inches" -> {
            toMeters = number * 0.0254
            print("$number ${if (number == 1.0) "inch" else "inches"} is ")
        }
    }
    when (measureTo) {
        "meters" ->
            print("$toMeters ${if (toMeters == 1.0) "meter" else "meters"}\n\n")
        "kilometers" ->
            print("${toMeters / 1000} ${if (toMeters / 1000 == 1.0) "kilometer" else "kilometers"}\n\n")
        "centimeters" ->
            print("${toMeters / 0.01} ${if (toMeters / 0.01 == 1.0) "centimeter" else "centimeters"}\n\n")
        "millimeters" ->
            print("${toMeters / 0.001} ${if (toMeters / 0.001 == 1.0) "millimeter" else "millimeters"}\n\n")
        "miles" ->
            print("${toMeters / 1609.35} ${if (toMeters / 1609.35 == 1.0) "mile" else "miles"}\n\n")
        "yards" ->
            print("${toMeters / 0.9144} ${if (toMeters / 0.9144 == 1.0) "yard" else "yards"}\n\n")
        "feet" ->
            print("${toMeters / 0.3048} ${if (toMeters / 0.3048 == 1.0) "foot" else "feet"}\n\n")
        "inches" ->
            print("${toMeters / 0.0254} ${if (toMeters / 0.0254 == 1.0) "inch" else "inches"}\n\n")
    }
}

/**
 * Converts weight values through "gram" and prints the result in a certain formatting
 */
fun convertWeight(measureFrom: String, measureTo: String, number: Double) {
    var toGrams: Double = 0.0
    when (measureFrom) {
        "grams" -> {
            toGrams = number
            print("$number ${if (number == 1.0) "gram" else "grams"} is ")
        }
        "kilograms" -> {
            toGrams = number * 1000
            print("$number ${if (number == 1.0) "kilogram" else "kilograms"} is ")
        }
        "milligrams" -> {
            toGrams = number * 0.001
            print("$number ${if (number == 1.0) "milligram" else "milligrams"} is ")
        }
        "pounds" -> {
            toGrams = number * 453.592
            print("$number ${if (number == 1.0) "pound" else "pounds"} is ")
        }
        "ounces" -> {
            toGrams = number * 28.3495
            print("$number ${if (number == 1.0) "ounce" else "ounces"} is ")
        }
    }
    when (measureTo) {
        "grams" ->
            print("$toGrams ${if (toGrams == 1.0) "gram" else "grams"}\n\n")
        "kilograms" ->
            print("${toGrams / 1000} ${if (toGrams / 1000 == 1.0) "kilogram" else "kilograms"}\n\n")
        "milligrams" ->
            print("${toGrams / 0.001} ${if (toGrams / 0.001 == 1.0) "milligram" else "milligrams"}\n\n")
        "pounds" ->
            print("${toGrams / 453.592} ${if (toGrams / 453.592 == 1.0) "pound" else "pounds"}\n\n")
        "ounces" ->
            print("${toGrams / 28.3495} ${if (toGrams / 28.3495 == 1.0) "ounce" else "ounces"}\n\n")
    }
}

/**
 * Converts temperature values using formulas and prints the result in a certain formatting
 */
fun convertTemperature(measureFrom: String, measureTo: String, number: Double) {
    if (measureFrom == "degrees Celsius" && measureTo == "degrees Fahrenheit") {
        val cToF = number * 9 / 5 + 32
        println("$number ${if (number == 1.0) "degree Celsius" else "degrees Celsius"} is $cToF ${if (cToF == 1.0) "degree Fahrenheit" else "degrees Fahrenheit"}\n")
    } else if (measureFrom == "degrees Fahrenheit" && measureTo == "degrees Celsius") {
        val cToF = (number - 32) * 5 / 9
        println("$number ${if (number == 1.0) "degree Fahrenheit" else "degrees Fahrenheit"} is $cToF ${if (cToF == 1.0) "degree Celsius" else "degrees Celsius"}\n")
    } else if (measureFrom == "degrees Celsius" && measureTo == "kelvins") {
        val cToF = number + 273.15
        println("$number ${if (number == 1.0) "degree Celsius" else "degrees Celsius"} is $cToF ${if (cToF == 1.0) "kelvin" else "kelvins"}\n")
    } else if (measureFrom == "kelvins" && measureTo == "degrees Celsius") {
        val cToF = number - 273.15
        println("$number ${if (number == 1.0) "kelvin" else "kelvins"} is $cToF ${if (cToF == 1.0) "degree Celsius" else "degrees Celsius"}\n")
    } else if (measureFrom == "kelvins" && measureTo == "degrees Fahrenheit") {
        val cToF = number * 9 / 5 - 459.67
        println("$number ${if (number == 1.0) "kelvin" else "kelvins"} is $cToF ${if (cToF == 1.0) "degree Fahrenheit" else "degrees Fahrenheit"}\n")
    } else if (measureFrom == "degrees Fahrenheit" && measureTo == "kelvins") {
        val cToF = (number + 459.67) * 5 / 9
        println("$number ${if (number == 1.0) "degree Fahrenheit" else "degrees Fahrenheit"} is $cToF ${if (cToF == 1.0) "kelvin" else "kelvins"}\n")
    } else if (measureFrom == "degrees Celsius" && measureTo == "degrees Celsius") {
        println("$number ${if (number == 1.0) "degree Celsius" else "degrees Celsius"} is $number ${if (number == 1.0) "degree Celsius" else "degrees Celsius"}\n")
    } else if (measureFrom == "degrees Fahrenheit" && measureTo == "degrees Fahrenheit") {
        println("$number ${if (number == 1.0) "degree Fahrenheit" else "degrees Fahrenheit"} is $number ${if (number == 1.0) "degree Fahrenheit" else "degrees Fahrenheit"}\n")
    } else if (measureFrom == "kelvins" && measureTo == "kelvins") {
        println("$number ${if (number == 1.0) "kelvin" else "kelvins"} is $number ${if (number == 1.0) "kelvin" else "kelvins"}\n")
    }

}

/**
 * Unit converter app offers to convert a value from one unit to another
 * if the units are convertible, filters wrong input, allows to exit
 */
fun converter() {
    var exitCommand = false
    do {
        try {
            print("Enter what you want to convert (or exit): ")
            val userInput = readln()
            if (userInput == "exit") {
                exitCommand = true
            } else {
                // creating an array of user input in lowercase
                val wordList: List<String> = userInput.split(" ").map { it.lowercase(Locale.getDefault()) }
                val number = wordList[0].toDouble()
                // analysing user input unit types for different array lengths
                var measureFrom = ""
                var measureTo = ""
                if (wordList.size == 4) {
                    measureFrom = wordList[1]
                    measureTo = wordList[3]
                } else if (wordList.size == 5) {
                    if (wordList[1] == "degree" || wordList[1] == "degrees") {
                        measureFrom = "${wordList[1]} ${wordList[2]}"
                        measureTo = wordList[4]
                    } else if (wordList[3] == "degree" || wordList[3] == "degrees") {
                        measureFrom = wordList[1]
                        measureTo = "${wordList[3]} ${wordList[4]}"
                    }
                } else if (wordList.size == 6) {
                    if ((wordList[1] == "degree" || wordList[1] == "degrees") && (wordList[4] == "degree" || wordList[4] == "degrees")) {
                        measureFrom = "${wordList[1]} ${wordList[2]}"
                        measureTo = "${wordList[4]} ${wordList[5]}"
                    }
                }
                // checking user input unit types for approved units
                val (unitFromType, unitFromApproved) = unitApproved(measureFrom)
                val (unitToType, unitToApproved) = unitApproved(measureTo)
                // converting units
                if (unitFromType == unitToType) {
                    when (unitFromType) {
                        "distance" -> {
                            if (number < 0) {
                                println("Length shouldn't be negative\n")
                            } else {
                                convertDistance(unitFromApproved, unitToApproved, number)
                            }
                        }
                        "weight" -> {
                            if (number < 0) {
                                println("Weight shouldn't be negative\n")
                            } else {
                                convertWeight(unitFromApproved, unitToApproved, number)
                            }
                        }
                        "temperature" -> convertTemperature(unitFromApproved, unitToApproved, number)
                        else -> println("Conversion from $unitFromApproved to $unitToApproved is impossible\n")
                    }
                } else {
                    println("Conversion from $unitFromApproved to $unitToApproved is impossible\n")
                }
            }
        } catch (e: Exception) {
            println("Parse error\n")
        }
    } while (!exitCommand)
}

fun main() {
    converter()
}