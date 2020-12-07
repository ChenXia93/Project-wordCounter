# Project-wordCounter

Purpose
To gain experience using Sets and Maps in Java.
To learn a very common application of Sets and Maps.
To become familiar with JSON format.
Background
In class, you have learned about Sets and Maps and how they are used in Java.

If you are going to store data, you probably want to be able to pass it from one computer to another, or one program to another. How do you do that? This can be troublesome, especially if the two different programs are using different programming languages.

A common way to transmit information from one computer or one program to another is to encode Sets and Maps in a filetype called JSON.

JSON stands for JavaScript Object Notation. In JavaScript, Maps are called Objects, so JSON just means "the way that we write (notate) maps in JavaScript." Although the first two letters of JSON stand for JavaScript, JSON can be used between any programming languages.

JSON (JavaScript Object Notation) is a lightweight, text-based, language-independent data exchange format that is easy for humans and machines to read and write. JSON can represent two structured types: objects and arrays.

An object is an unordered collection of zero or more name/value pairs.
An array is an ordered sequence of zero or more values.
The values can be strings, numbers, booleans, null, and these two structured types.

Below is a simple example from Wikipedia that shows JSON representation of an object that describes a person. The object has string values for first name and last name, a number value for age, an object value representing the person’s address, and an array value of phone number objects.

{
    "firstName": "John",
    "lastName": "Smith",
    "age": 25,
    "address": {
        "streetAddress": "21 2nd Street",
        "city": "New York",
        "state": "NY",
        "postalCode": 10021
    },
    "phoneNumbers": [
        {
            "type": "home",
            "number": "212 555-1234"
        },
        {
            "type": "fax",
            "number": "646 555-4567" 
        }
    ] 
}
Learn more about JSON by reading this article.

In this project, you will be writing a Word Counting program which uses HashMaps to find number of word occurrences in a file (a very common application of Maps). This output will be converted automatically to a JSON format.

Key Words
You must, in your code, determine if two words are the same or not. If they are the same, they should be considered "key words", and get stored at the same key of your map.

Two words are considered the same if their only differences are:

capitalization
final character(s) 's, s, ed, or ing on the end
or added ending punctuation.
For instance, the words "CALL", "called", "call", "calling", "calls" would all be “cleaned up” to form the keyword "call".

Required Methods
public String get(K word):
Return values of a json entry for a word.
In other words, the returned String should contain the count for the word, followed by a comma, followed by all unique occurrences of the word separated by commas.
public int getCount(K word):
Return the part of the WordSet entry value that stores the number occurences of the word in the text.
public void put(K keyWord, V word):
Add a new entry or update an existing one in the implemented Set
public Set<K> keySet():
Implemented for you.
Returns the map's set of keys. (Should be the key words of your text.)
Example input
Nory's family were all Catholics. Nory was a Catholic because her mother was a catholic, and Nory’s mother was a CATHOLIC because her father was a Catholic, and her father was a Catholic because his mother was a Catholic, or had been.
A typical line of the report might read:

"catholic":{
    "forms":["CATHOLIC","Catholic","Catholics","catholic"],
    "count":"7"
},
This means that Catholic was found 9 times and appeared in 4 different forms as Catholics, Catholic, catholic, and CATHOLIC.

You must complete an implementation for the class WordSet which is used to count generic Objects.

Examples
Example 1:
Input:

A professor is teaching CS111 and gets to the topic of recursion, but after reading his prepared notes, one of his students seems particularly perplexed and questions the teacher.
"I don't understand, you said a recursive algorithm one that calls itself?" The student asks.
"Yes," says the teacher.
"So it's like a phone? Wouldn't it get a busy signal trying to call itself?"
"No, not like a phone, it's more like ..." The teacher starts to explain, but is cut off by the student.
"Is it like a roll call? Like when you call your own name?"
"No," the teacher continues "It's not-"
But the student immediately interrupts.
"Like calling a bet? You bet on yourself?"
"No!" the teacher finally blurts. "Look, I can see you're confused. Why don't I tell you a joke my professor taught me..."
He clears his throat and begins.
"A professor is teaching CS111..."
Output:

{
    "but":{
        "count":"3",
        "forms":["But","but"]
    },
    "a":{
        "count":"8",
        "forms":["A","a"]
    },
    "hi":{
        "count":"3",
        "forms":["his"]
    },
    "\"no":{
        "count":"3",
        "forms":["\"No"]
    },
    "like":{
        "count":"5",
        "forms":["Like","like"]
    },
    "student":{
        "count":"4",
        "forms":["student","students"]
    },
    "i":{
        "count":"5",
        "forms":["I","is"]
    },
    "it":{
        "count":"4",
        "forms":["it","it's"]
    },
    "call":{
        "count":"5",
        "forms":["call","calling","calls"]
    },
    "the":{
        "count":"9",
        "forms":["The","the"]
    },
    "professor":{
        "count":"3",
        "forms":["professor"]
    },
    "teacher":{
        "count":"5",
        "forms":["teacher"]
    },
    "and":{
        "count":"3",
        "forms":["and"]
    },
    "to":{
        "count":"3",
        "forms":["to"]
    },
    "you":{
        "count":"4",
        "forms":["You","you"]
    }
}
Example 2:
Input:

I felt happy because I saw the others were happy and because I knew I should feel happy, but I wasn’t really happy.
Output:

{
    "happy":{
        "count":"4",
        "forms":["happy"]
    },
    "i":{
        "count":"5",
        "forms":["I"]
    }
}
Example 3:
Input:

ha#$@ Ha* haha* ha! ha? hA.
Output:

{
    "ha":{
        "forms":["Ha","hA","ha"],
        "count":"5"
    }
}
