package exercises;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        //Create an int variable named myFavoriteNumber and assign your favorite number to it,
        // then print it out to the console.
        int myFavoriteNumber = 7;
        System.out.format("My favorite number:  %s%n", myFavoriteNumber);

        //Create a String variable named myString and assign a string value to it,
        // then print the variable out to the console.
        String myString = "I AM your father!";
        System.out.format("My string: '%s'%n", myString);

        //Change your code to assign a character value to myString. What do you notice?
        //myString = 'A';

        //Change your code to assign the value 3.14159 to myString. What happens?
        //myString = 3.14159; TODO: Cannot assign double to String

        //Declare a long variable named myNumber, but do not assign anything to it.
        // Next tr//y to print out myNumber to the console. What happens?
        //long myNumber;
        //System.out.println(myNumber); TODO: Cannot print out unassigned variable

        //Change your code to assign the value 3.14 to myNumber. What do you notice?
        //myNumber = 3.14; TODO: Cannot assign double to long

        //Change your code to assign the value 123L (Note the 'L' at the end) to myNumber.
        //myNumber = 123L;

        //Change your code to assign the value 123 to myNumber.
        //myNumber = 123;

        //Why does assigning the value 3.14 to a variable declared as a long not compile,
        // but assigning an integer value does? TODO: Because longs do not have a fractional part

        //Change your code to declare myNumber as a float. Assign the value 3.14 to it.
        // What happens? TODO: It does not compile
        // What are two ways we could fix this? TODO: Append 'F' to the literal
        //float myNumber = 3.14;

        //Copy and paste the following code blocks one at a time and execute them
        int x = 5;
        //TODO: Post-fixing prints the variable and then increments
        //System.out.println(x++);
        //System.out.println(x);
        //TODO: Prefixing increments the variable and then prints
        System.out.println(++x);
        System.out.println(x);

        //String class = "class";
        //TODO: using class as a variable name does not compile

        //String theNumberThree = "three";
        //Object o = theNumberThree;
        //int three = (int) o;
        //TODO: This causes ClassCastException

        //int three = (int) "three";
        //TODO: this one does not even compile


    }
    public void shortHandAdd() {
        int x = 4;
        //x = x + 5;
        x += 5;
    }

    public void shortHandMultiply() {
        int x = 3;
        int y = 4;
        //y = y * x;
        y *= x;
    }

    public void shortHandDivide() {
        int x = 10;
        int y = 2;
        //x = x / y;
        x /= y;
        //y = y - x;
        y -= x;
    }

}
