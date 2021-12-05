package nl.chrisb.aoc21.runner

import com.charleskorn.kaml.Yaml
import com.github.ajalt.mordant.rendering.TextColors.blue
import com.github.ajalt.mordant.rendering.TextColors.yellow
import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.default
import com.xenomachina.argparser.mainBody
import io.github.cdimascio.dotenv.dotenv
import kotlinx.serialization.encodeToString
import nl.chrisb.aoc21.common.Solution
import nl.chrisb.aoc21.common.allSolutions
import java.io.File
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

private val cookie = dotenv()["COOKIE"]
    ?: throw RuntimeException("No environment variable COOKIE found.")
private val httpClient = HttpClient.newHttpClient()

private fun fetchInput(year: Int, day: Int): String =
    httpClient.send(
        HttpRequest.newBuilder()
            .header("Cookie", "session=$cookie")
            .uri(URI.create("https://adventofcode.com/$year/day/$day/input"))
            .build(),
        HttpResponse.BodyHandlers.ofString()
    ).body()

private fun getInput(year: Int, day: Int): String {
    val file = File("cache/$year.yml")
    val cache = if (file.exists()) {
        Yaml.default.decodeFromStream(Days.serializer(), file.inputStream())
    } else {
        Days(mutableMapOf())
    }

    return cache.days[day]?.input ?: run {
        file.parentFile.mkdirs()
        file.createNewFile()

        println(yellow("Input not yet cached, fetching it..."))

        val input = fetchInput(year, day)
            .let { if (it.last() == '\n') it.dropLast(1) else it }
        cache.days[day] = Day(input)
        file.writeText(Yaml.default.encodeToString(cache))
        input
    }
}

private fun run(solution: Solution) {
    println(blue("Running solution for ${solution.year} - ${solution.day}: ${solution.title}"))
    solution.input = getInput(solution.year, solution.day)
    println("${blue("Part 1:")} ${solution.part1()}")
    println("${blue("Part 2:")} ${solution.part2()}")
}

class Args(parser: ArgParser) {
    val unfinished by parser.flagging("-u", "--unfinished", help = "select all unfinished solutions")
    val year by parser.positional("YEAR", "select all solution from a specific year") { toInt() }.default(null)
    val day by parser.positional("DAY", "select a specific solution from specified year and day") { toInt() }
        .default(null)
}

fun main(args: Array<String>) = mainBody("aoc21") {
    ArgParser(args).parseInto(::Args).run {
        var solutions = allSolutions

        if (unfinished) {
            solutions = solutions.filter { !it.finished }
        }

        year?.let { year ->
            solutions = solutions.filter { it.year == year }
        }

        day?.let { day ->
            solutions = solutions.filter { it.day == day }
        }

        if (solutions.isEmpty()) {
            System.err.println("No solutions were executed.")
        } else {
            solutions.forEach(::run)
        }
    }
}
