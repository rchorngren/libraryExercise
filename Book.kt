class Book(
    var title : String = "",
    var author : String = "",
    var published : Int = 0,
    var edition : Int = 1,
    var available : Boolean = true
){
    fun loan() : Boolean {
        if(available) {
            available = false
            return true
        } else {
            return false
        }
    }

    fun returnBook() : Boolean {
        if(!available) {
            available = true
            return true
        } else {
            return false
        }
    }

    override fun toString() : String {
        return ("Title: $title Author: $author  Published: $published Edition: $edition Available for loan: $available")
    }
}