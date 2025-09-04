package prog6112_a1;

import java.util.ArrayList;
import java.util.Scanner;

public class Series {
    
    //Stores the series data in memory
    private static ArrayList<SeriesModel> seriesList = new ArrayList<>();
    
    //Captures the new series data
    public static void captureSeries(Scanner scanner){
        System.out.print("Enter Series ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter Series Name: ");
        String name = scanner.nextLine();
                      
        String age = "";
        //Initializing the boolean variable to false
        boolean validAge = false;
        while (!validAge){            
            System.out.print("Enter Series Age Restriction (between 2 and 18): ");
            age = scanner.nextLine();
            //Using try converts the string to integer
            try {
                //checking if the user input is valid
                int ageInt = Integer.parseInt(age);
                if (ageInt >= 2 & ageInt <= 18){
                    validAge = true;

                }else{
                    System.out.println("You have entered an incorrect series age!!!");
                }
                //Catches the exception of a user inputting a string and prompts them to enter an integer
            }catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a numeric value between 2 and 18");
            }           
        }       
        
        System.out.print("Enter Number of Episodes: ");
        String episodes = scanner.nextLine();
        
        //Adds the data to the array
        SeriesModel newSeries = new SeriesModel(id, name, age, episodes);
        seriesList.add(newSeries);
        
        //Displays the data once the user is done with their input
        System.out.println("CAPTURE A NEW SERIES");
        System.out.println("******************************");
        System.out.println("Enter the series ID: " + id);
        System.out.println("Enter the series name: " + name);
        System.out.println("Enter the series age: " + age);
        System.out.println("Enter the number of episodes for " + name + ": " + episodes);        
        System.out.println("Series processed successfully!!!");
        
        //Asks the user to choose to return to the menu or exit the application
        System.out.println("Enter (1) to return to menu or any other key to exit: ");
        String choice = scanner.nextLine();
        
        //determines the choice and either sends the user to the menu or exits the application
        if (!choice.equals("1")){
            System.out.println("You chose: Exit Application... goodbye!");
            System.exit(0);
        }
    }
    
    public static void searchSeries(Scanner scanner){           
        System.out.print("Enter series ID to search: ");
        String searchID = scanner.nextLine();
        
        boolean found = false;
        
        //setting temp variable to store the data from the array in
        for (SeriesModel s: seriesList){
            //using equalsIgnoreCase to disregard uppcase and lowercase in the two variables
            if (s.SeriesId.equalsIgnoreCase(searchID)){
                //calls the SeriesModel.toString()
                System.out.println(s);
                found = true;
                break;
            }
        }
        
        if (!found){
            System.out.println("Series with series id: " + searchID + " was not found");
        }
        
         System.out.println("Enter (1) to return to menu or any other key to exit: ");
         String choice = scanner.nextLine();
        
        //determines the choice and either sends the user to the menu or exits the application
        if (!choice.equals("1")){
            System.out.println("You chose: Exit Application... goodbye!");
            System.exit(0);
        }
    }
    
    public static void updateSeries(Scanner scanner){
        System.out.println("Enter the series id to update: ");
        String updateID = scanner.nextLine();
        
        boolean found = false;
        
        //setting temp variable to store the data from the array in
        for (SeriesModel s: seriesList){
            //allowing the user to input new data if the updateID matches the SeriesId
            if (s.SeriesId.equalsIgnoreCase(updateID)){
                System.out.println("Enter new series name: ");
                s.SeriesName = scanner.nextLine();
                
                System.out.println("Enter new series age restriction: ");
                s.SeriesAge = scanner.nextLine();
                
                System.out.println("Enter new series number of episodes: ");
                s.SeriesNumberOfEpisodes = scanner.nextLine();
                
                System.out.println("Series updated successfully");
                found = true;
                break;
            }
        }
        
        //If the variables dont match the user will be informed
        if (!found){
            System.out.println("series with series ID: " + updateID + " was not found");
        }
        
        System.out.println("Enter (1) to return to menu or any other key to exit: ");
        String choice = scanner.nextLine();
        
        //determines the choice and either sends the user to the menu or exits the application
        if (!choice.equals("1")){
            System.out.println("You chose: Exit Application... goodbye!");
            System.exit(0);
        }
    }
    
    public static void exitSeriesApplication(Scanner scanner){
        //Exiting the application
        System.out.println("You chose: Exit Application... goodbye!");             
        System.exit(0);
    }
    
    public static void seriesDelete(Scanner scanner){
        System.out.println("Enter series id to delete: ");
        String deleteID = scanner.nextLine();
        
        //Initializing the placeholder variable to be empty
        SeriesModel toDelete = null;
        
        for (SeriesModel s: seriesList){
            if (s.SeriesId.equalsIgnoreCase(deleteID)){
               //Setting the data to be deleted
                toDelete = s;
                break;
            }
        }
        
        if (toDelete != null){
            System.out.print("Are you sure you want to delete series " + deleteID + " from the system? Yes (y) to delete");
            String confirm = scanner.nextLine();
            
            //if the confirm variable equals "y" the series will be deleted
            //IgnoreCase works best here as if a user inputs a capital y the input will work anyway
            if (confirm.equalsIgnoreCase("y")){
                //Removes the data that was set to be deleted
                seriesList.remove(toDelete);
                System.out.println("------------------------------------");
                System.out.println("Series with series id: " + deleteID + " was deleted!");
                System.out.println("------------------------------------");
            }else{
                System.out.println("Deletion cancelled");
            }
        }else{
            System.out.println("series with series ID " + deleteID + " was not found");
        }
        
        System.out.println("Enter (1) to return to menu or any other key to exit: ");
        String choice = scanner.nextLine();
        
        //determines the choice and either sends the user to the menu or exits the application
        if (!choice.equals("1")){
            System.out.println("You chose: Exit Application... goodbye!");
            System.exit(0);
        }
    }
       
    public static void seriesReport(Scanner scanner){
        //Checks if seriesList is empty, if it is it prompts the user that there are series to display
        if (seriesList.isEmpty()){
            System.out.println("No series available to display");
            
        }else{
            //logging the first series stored in the array
            int count = 1;
            for (SeriesModel s: seriesList){
                System.out.println("series " + count);
                System.out.println("======================================");
                System.out.println("series ID: " + s.SeriesId);
                System.out.println("series Name: " + s.SeriesName);
                System.out.println("series Age Restriction: " + s.SeriesAge);
                System.out.println("series Number of episodes: " + s.SeriesNumberOfEpisodes);
                System.out.println("======================================");
                //incrementing the count after the first series is reported
                count++;
            }
        }
        
        System.out.println("Enter (1) to return to menu or any other key to exit: ");
        String choice = scanner.nextLine();
        
        //determines the choice and either sends the user to the menu or exits the application
        if (!choice.equals("1")){
            System.out.println("You chose: Exit Application... goodbye!");
            System.exit(0);
        }
        
    }
    
    // * FOR TESTING * //
    
    //adding a series directly to help the testing process
    public static void addSeries(SeriesModel series){
        seriesList.add(series);
    }
    
    //clearing all series to reset before testing
    public static void clearSeriesList(){
        seriesList.clear();
    }
    
    //searching for ID supplied and returning the series it matches with, if not returns prompt that it was not found
    public static String searchSeriesById(String searchID){
        for (SeriesModel s: seriesList){
            if (s.SeriesId.equalsIgnoreCase(searchID)){
                return s.toString();
            }
        }
        return "Series with series id: " + searchID + " was not found";        
    }
    //setting new data for the test series by storing it in placeholder varaibles
    public static boolean updateSeriesById(String updateID, String newName, String newAge, String newEpisodes){
        for (SeriesModel s: seriesList){
            if (s.SeriesId.equalsIgnoreCase(updateID)){
                s.SeriesName = newName;
                s.SeriesAge = newAge;
                s.SeriesNumberOfEpisodes = newEpisodes;
                //Update was a success
                return true;
            }
        }
        //test failed/ ID was not found
        return false; 
    }
    
    //Storing the series to delete in a placeholder variable and deleting if it matches
    public static boolean deleteSeriesById(String deleteID) {
        SeriesModel toDelete = null;
        for (SeriesModel s : seriesList) {
            if (s.SeriesId.equalsIgnoreCase(deleteID)) {
            toDelete = s;
            break;
            }            
        }
        
        if (toDelete != null) {
            seriesList.remove(toDelete);
            return true; // Deletion worked successfully
        }
        
        return false; //test failed/ ID was not found
    }

    public static boolean isValidAgeRestriction(String age){
        try {
            int ageInt = Integer.parseInt(age);
            return ageInt >= 2 & ageInt <= 18;
            
        }catch (NumberFormatException e){
            return false;
        }
    }
}

