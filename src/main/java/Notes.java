public class Notes {
    public static void main(String args[]) {
        
        //REGULAR EXPRESSION
        //by using [] in your parameter, if it matches any characters inside the brackets, it will split there
        String words = "Hello there, how are you!";
        System.out.println(words.replaceAll("[,!]", ""));
       
        
        words = "HAHAHAHA, LOOK AT ! ALL ? THE SYMBOL...";
        String[] breaks = words.split("[.?!]");
        for (int i = 0 ; i < breaks.length; i++) {
            System.out.print(breaks[i] + ", ");
        }

        //returns true when the word is only blanks (empty, spaces, tabs)
        String word = "help";
        System.out.println(word.isBlank());

        //May use any arraylist, hashmap, arraydeque methods.

    }
}
