package groceries;

import groceries.data.GroceryDb;
import util.Input;

import java.io.FileNotFoundException;

public class GroceryApp {

    static GroceryDb db;

    private static Input input;
    public static void main(String[] args)  {

        try {
            db = new GroceryDb();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        input = new Input();

        //A user should be prompted if they would like to create a grocery list.
        if (input.yesNo("Would you like to create a grocery list? yes/no: ")) {
            //If they pick yes, they will be prompted if they would like to enter a new item.
            printMenu();
            //Enter the name of the item.
            System.out.format("Please enter the name of an item: ");
            //Enter how many of the item.
            System.out.format("Please enter a quantity: ");
            //The user will then be given the choice to finalize the list or add an item.
            input.yesNo("Do you need to add any more items? yes/no: ");
        }


        //TODO: Once the user finalizes the list, they will be presented with a complete list organized alphabetically and grouped by a category, and including quantity.

        //TODO: As a bonus, allow users to filter the results by only one category of items at a time.
        //
        //TODO: For a super gold star bonus, allow users to edit the list items.

    }

    private static void printMenu() {
        System.out.format("""
                Please choose one of the following categories
                1. Fruit
                2. Vegetables
                3. Dairy
                4. Meat
                5. Baking
                """);
    }

}
