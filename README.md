[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/XmS0pe_R)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=23894403)
# Problem Set Unit 5

## Create a Text Analyzer:



### Option 1: Basic Text Analyzer (80%)

Create a text analyzer program where the user inputs a sentence or paragraph and the program analyzes the text.

The program must follow the following specifications:

Display a welcome message.

Ask the user to input a sentence or paragraph.

Count and output:

  - Total number of characters
  - Total number of words
  - Total number of vowels
  - Total number of spaces
  - All unique words and how many times they occur.
  - Ignore capitalization when counting words. For example, "Java" and "java" should count as the same word.

Do not forget to comment and document your code!

Example Run:

```
Welcome to the Text Analyzer.

Please enter a sentence or paragraph: Java is fun and java is powerful.

Total Characters: 37
Total Words: 7
Total Vowels: 12
Total Spaces: 6

Word Frequency:

java - 2
is - 2
fun - 1
and - 1
powerful - 1
```

### Option 2: Remove Punctuation and Ignore Common Words (+10%)

Do all of the above but add one extra feature.

Before analyzing the text, remove punctuation from all words.

For example:

  - "hello,"
  - "hello!"
  - "hello."

should all count as:

  - "hello"

Also ignore the following words for the purpose of word frequency:

  - the
  - a
  - an
  - and
  - is

Example Run:

```
Welcome to the Text Analyzer.

Please enter a sentence or paragraph:

Hello, hello! Java programming is fun.

Total Characters: 40
Total Words: 6
Total Vowels: 12
Total Spaces: 5

Word Frequency:

hello - 2
java - 1
programming - 1
is - 1
fun - 1
```

### Option 3: Advanced Statistics (+10%)

In Option 3, do all of the above options plus add more statistics about the text.

Add the following features:

  - Output the longest word
  - Output the shortest word
  - Output the average word length
  - Output the number of sentences
  - Output how many unique words there are

If there are multiple longest, shortest, or most common words, you must output all of them.

Example Run:

```
Welcome to the Text Analyzer.

Please enter a sentence or paragraph:

Data structures and algorithms are important. Data is powerful.

Total Characters: 64
Total Words: 9
Total Vowels: 22
Total Spaces: 8

Word Frequency:

data - 2
structures - 1
and - 1
algorithms - 1
are - 1
important - 1
is - 1
powerful - 1

Longest Word: algorithms, structures
Shortest Word: is
Average Word Length: 6.00
Number of Sentences: 2
Unique Words: 8
```
