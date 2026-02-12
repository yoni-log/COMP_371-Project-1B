# TopWords - Word Frequency Cloud

A Scala application that reads a stream of words from stdin and prints an updated "word cloud" showing the most frequent words within a sliding window.

## Overview

**TopWords** maintains a sliding window of recent words and continuously outputs the N most frequent words in real-time. It's built as a Scala application demonstrating stream processing, data structure management, and observer pattern design.

### Key Features

- **Accepts** three command-line arguments: `cloudSize`, `minLength`, and `windowSize`
- **Maintains** a sliding window of recent words and their frequencies
- **Prints** the top N most frequent words (by frequency descending) each time the window fills
- **Handles** SIGPIPE gracefully for piped output operations
- **Ignores** words shorter than `minLength`
- **No output** for the first `(windowSize - 1)` words, only once the window is full

## Building the Application

    sbt stage

## Running the Application

The application accepts command-line arguments for customization:

    ./target/universal/stage/bin/topwords -c <cloudSize> -m <minLength> -w <windowSize> < input.txt

**Arguments:**
- `-c` or `--cloudSize`: Number of top words to display (default: 10)
- `-m` or `--minLength`: Minimum word length to consider (default: 1)
- `-w` or `--windowSize`: Size of the sliding window (default: 100)

**Example Usage:**

    ./target/universal/stage/bin/topwords -c 10 -m 3 -w 50 < test_input.txt | head

**Output Format:**

    word1: 25 word2: 18 word3: 15 word4: 12 word5: 10

## Running the Tests

    sbt test

## Determining Test Coverage

    sbt clean coverage test coverageReport

Now open this file in a web browser:

    target/scala-*/scoverage-report/index.html

Note that the Scala version number might vary depending on what's defined in the build configuration (`build.sbt`).

## Running a Scala Console

This allows you to explore the functionality of the classes in this project in a Scala REPL while letting sbt set the classpath for you:

    sbt console
