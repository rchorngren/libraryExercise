fun main() {
    var runProgram = true

    while(runProgram) {
        var selectedOption = menu()
        println("You chose option $selectedOption")

        when (selectedOption) {
            "1" -> {
                addBook()
            }
            "2" -> {
                findBook()
            }
            "3" -> {
                listAvailableBooks()
            }
            "4" -> {
                returnBook()
            }
            "5" -> {
                println("Exiting - have a fantastic day ^^")
                runProgram = false
            }
            else -> {
                println("unknown command - please try again:\n")
            }
        }
    }
}

fun menu(): String? {
    println("Welcome to the library - what would you like to do?")
    println("1. Add a book to the library")
    println("2. Search for a book by name")
    println("3. List all available books")
    println("4. Return a book")
    println("5. Quit")

    return readLine().toString()

}

fun myLibrary() : MutableList<Book> {
    var myLibrary = mutableListOf<Book>()
    var myFirstBook = Book(
            "Das Book",
            "Someone with a pen",
            1900,
            1,
            true
    )
    var mySecondBook = Book(
            "A better book",
            "Typewriter Machinegun",
            1984,
            12,
            false
    )
    var myThirdBook = Book(
            "Perhaps the best book ever written",
            "Veteran writer",
            2025,
            2,
            true
    )

    myLibrary.add(myFirstBook)
    myLibrary.add(mySecondBook)
    myLibrary.add(myThirdBook)

    return myLibrary
}

fun addBook() {
    var myLibrary = myLibrary()

    println("Add a book:\n")
    println("Enter the title of the book:")
    var newTitle = readLine()

    println("Enter the name of the author:")
    var newAuthor = readLine()

    println("Enter the year which the book was published:")
    var newPublished : Int? = readLine()?.toInt()

    println("Enter the edition of the book (numerical value):")
    var newEdition : Int? =  readLine()?.toInt()

    val newBook = Book(
            newTitle!!,
            newAuthor!!,
            newPublished!!,
            newEdition!!
    )

    myLibrary.add(newBook)
    for(book in myLibrary) {
        println(book.title)
    }
    println("")
}

fun findBook() {
    var myLibrary = myLibrary()
    var bookFound = false

    println("Enter the title of the book you are searching for:")
    var titleToFind = readLine() ?: ""

    for(book in myLibrary) {
        if(book.title == titleToFind && book.available) {
            bookFound = true
            println("The book was found - would you like to borrow it(y/n)?")
            var loanBook = readLine() ?: "n"
            if(loanBook == "y") {
                book.loan()
                println("Thank you - you are now borrowing $titleToFind")
                println("Updating status:")
                println(book.toString())
            } else {
                println("Loan cancelled - returning to main menu")
            }
        } else if(book.title == titleToFind && !book.available) {
            bookFound = true
            println("The book was found but sadly it is already on loan")
        }
    }
    if(!bookFound) {
        println("Sorry, we could not find the book you're looking for :(")
    }
    println("")
}

fun listAvailableBooks() {
    var myLibrary = myLibrary()
    println("Available books:\n")
    for(book in myLibrary) {
        if(book.available) {
            println(book.toString())
        }
    }
    println("")
}

fun returnBook() {
    var myLibrary = myLibrary()
    println("Which book would you like to return?")
    var bookToReturn = readLine() ?: ""
    for(book in myLibrary) {
        if(bookToReturn == book.title && !book.available) {
            println(book.toString())
            println("Would you like to return the book now (y/n)")
            var returnBook = readLine() ?: "n"
            if(returnBook == "y") {
                println("Returning book...")
                book.returnBook()
                println(book.toString())
            } else {
                println("Return cancelled - returning to main menu")
            }
        }
    }
    println("")
}