package nl.chrisb.aoc21.common

import com.charleskorn.kaml.Yaml
import com.github.ajalt.mordant.rendering.TextColors.blue
import io.github.cdimascio.dotenv.dotenv
import kotlinx.serialization.encodeToString
import java.io.File
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class Solution(private val year: Int, private val day: Int, input: String? = null) {
    private val cookie = dotenv()["COOKIE"]
    private val httpClient = HttpClient.newHttpClient()

    private val cacheFile = File("cache/$year.yml")
    private val cache = if (cacheFile.exists()) {
        Yaml.default.decodeFromStream(Cache.serializer(), cacheFile.inputStream())
    } else {
        Cache(mutableMapOf())
    }

    val lines: List<String> = input?.lines() ?: getDayCache().input.lines()

    private fun fetchInput(): String =
        httpClient.send(
            HttpRequest.newBuilder()
                .header("Cookie", "session=$cookie")
                .uri(URI.create("https://adventofcode.com/$year/day/$day/input"))
                .build(),
            HttpResponse.BodyHandlers.ofString()
        ).body()

    private fun saveCache() {
        cacheFile.parentFile.mkdirs()
        cacheFile.createNewFile()
        cacheFile.writeText(Yaml.default.encodeToString(cache))
    }

    private fun getDayCache() = cache.days.getOrElse(day) {
        println("Input not yet cached, fetching it...")

        val dayCache = Day(fetchInput().let { if (it.last() == '\n') it.dropLast(1) else it })
        cache.days[day] = dayCache
        saveCache()

        dayCache
    }

    fun part1(answer: Solution.() -> Any?) = apply {
        println("${blue("Part 1:")} ${run(answer)}")
    }

    fun part2(answer: Solution.() -> Any?) = apply {
        println("${blue("Part 2:")} ${run(answer)}")
    }
}
