package com.example;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Scanner;


public class GroceryList
{
    private ArrayList groceries;

    public GroceryList()
    {
        groceries = new ArrayList();
    }

    public void menuchoice()
    {
        System.out.println("\n" + "1. Add item");
        System.out.println("2. View list");
        System.out.println("3. Clear list");
        System.out.println("4. Export to txt file");
        System.out.println("5. Quit");
    }

    public void addItem(String item)
    {
        groceries.add(item);
    }

    public int numberOfItems()
    {
        return groceries.size();
    }

    public String toString()
    {
        String s = "";

        for (int i = 0; i < groceries.size(); i++)
        {
            s += "\n" + groceries.get(i) + "\n";
        }

        return s;
    }

    public void clear()
    {
        groceries.clear();
    }

    public static void main(String[] args)
    {
        //Create a new grocery list
        GroceryList myList = new GroceryList();

        //get input
        Scanner menuinput = new Scanner (System.in);
        int choice = 0;

        while (choice != 5)
        {   //display menu
            myList.menuchoice();
            choice = menuinput.nextInt();
            switch(choice)
            {
                case 1:  //Add some items
                    System.out.println("Enter the item");
                    Scanner iteminput = new Scanner(System.in);
                    String a = iteminput.next();
                    myList.addItem(a);
                    break;
                case 2: //Print out the list
                    System.out.println(myList);
                    //Print number of items in list
                    System.out.println("Number of items: " + myList.numberOfItems() + "\n");
                    break;
                case 3:     //Clear list
                    myList.clear();
                    break;
                case 4:
                    try{
                        PrintWriter writer = new PrintWriter("shoppingList.txt", "UTF-8");
                        writer.println(myList);
                        writer.close();
                    }
                    catch(IOException e){
                        System.out.println("ERROR");
                    }
            }
        }
        while (choice == 5)
        {
            System.exit(0);
        }
    }
}

