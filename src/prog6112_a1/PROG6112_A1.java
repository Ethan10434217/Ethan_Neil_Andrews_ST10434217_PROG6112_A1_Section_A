package prog6112_a1;

import java.util.Scanner;

public class PROG6112_A1 {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        //Screen displayed on starting the application
        System.out.println("LATEST SERIES - 2025");
        System.out.println("******************************");
        System.out.println("Enter (1) to launch menu or any other key to exit: ");
        
        String choice = scanner.nextLine();
        
        //If the user clicks one the menu will launch, if not the application will close
        if (choice.equals("1")){
            showMenu(scanner);
        }else{
            System.out.println("Exiting application");
        }
        
        scanner.close();
        
          
    }
    
    private static void showMenu(Scanner scanner){
        boolean running = true;
        
        //Menu options choice using a switch/case option
        while (running){
          System.out.println();
          System.out.println("Please select one of the following menu items:");
          System.out.println("(1) Capture a new series.");
          System.out.println("(2) Search for a series.");
          System.out.println("(3) Update series age restriction.");
          System.out.println("(4) Delete a series.");
          System.out.println("(5) Print series report - 2025.");
          System.out.println("(6) Exit Application.");   
          
          //Using nextLine() to read the entire line of input from the user
          String option = scanner.nextLine();
          
          switch (option){
              case "1":
                  Series.captureSeries(scanner);
                  break;
              case "2":
                  System.out.println("You chose: Search for a series");
                  Series.searchSeries(scanner);
                  break;
              case "3":
                  System.out.println("You chose: Update series age restriction");
                  Series.updateSeries(scanner);
                  break;
              case "4":
                  System.out.println("You chose: Delete a series");
                  Series.seriesDelete(scanner);
                  break;
              case "5":
                  System.out.println("You chose: Print a series report - 2025");
                  Series.seriesReport(scanner);
                  break;
              case "6":
                  Series.exitSeriesApplication(scanner);
                  running = false;
                  break;
              default:
                  System.out.println("Invalid option. Please try again");
                  break;                    
          }
          
        }
        
    }
    
}
