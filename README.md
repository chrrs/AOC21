# AOC21

> My Advent of Code solutions written in Kotlin

## Why Kotlin?

I think Kotlin is a really suitable language for Advent of Code, because it handles list interactions perfectly with
functions like `map` and `fold`. As most of the days in Advent of Code involve some kind of list manipulation /
analysis, this is a really important thing to get right.

Furthermore, Kotlin is very extendable. This allows me to write my own framework, which automates a lot of tasks and
allows me to extend normal Kotlin types like strings or lists with my own functions, which saves me a lot of time
writing boilerplate code.

## Framework? What framework?

I've written a small framework to ease writing solutions and executing them automatically. It fetches your own personal
input from the AoC API using a session cookie, caches it into a `yml` file and reuses this file when needed.

This is all reduced to a single class instantiation, allowing me to start writing solutions in only a couple lines of
code:

```kotlin
fun main() {
    Solution(2020, 1)
        .part1 {
            // Sum up all numbers
            lines.toInts().sum()
        }
        .part2 {
            // Multiply all numbers
            lines.toInts().product()
        }
}

```

Upon running this function, the results automatically get output to the console:

```sh
Part 1: 348920
Part 2: 428911409
```

## How do I run the solutions?

I've built this repository assuming you have an IDE to run individual main functions. If you don't, you're out of luck.

First, you'll need a session cookie from Advent of Code. To get it, log in to the [website](https://adventofcode.com/).
Then, open the inspector and navigate to the `Storage` section. You should be able to find a cookie called `session`.
Assign the contents of this cookie to the environment variable named `COOKIE`.

You can also do this using a `.env` file:

```properties
COOKIE=1234abcd
```

Then, using your favorite IDE (for example IntelliJ IDEA or Eclipse), execute the main function in the solution file you
want to execute (for example `nl.chrisb.aoc21.y21.Day1`.

#### Thanks for reading!
