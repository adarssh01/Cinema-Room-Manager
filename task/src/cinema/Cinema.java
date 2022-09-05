package cinema;
import java.util.*;
public class Cinema {
    private static char[][] array;
    static int ticket = 0;
    static Scanner scanner = new Scanner(System.in);
    static int n,m;
    static int currentIncome = 0;
   
    
    public static void main(String[] args) {
        // Write your code here
        createCinema();
        System.out.println(); 
         int input;
         do {
                System.out.println("1. Show the seats");
                System.out.println("2. Buy a ticket");
                System.out.println("3. Statistics");
                System.out.println("0. Exit");
                input = scanner.nextInt();
                switch (input) {
                    case 1:
                        printCinema();
                        break;
                    case 2:
                        while(true) {
       
       System.out.println("\nEnter a row number:");
       int row = scanner.nextInt();
       
       System.out.println("Enter a seat number in that row:");
       int seat = scanner.nextInt();
        
        System.out.println(); 

         //here is the exception part

        if ((row > n ) || (seat > m)) {
            System.out.println("Wrong Input!");
        } else if (array[row-1][seat-1] == 'B') {
            System.out.println("\nThat ticket has already been purchased!");
        } else {
            array[row-1][seat-1] = 'B';
            ticket++;

             if (n * m < 60) {
             System.out.println("\nTicket price: $10");
             currentIncome += 10;
             } else {

             if (row <= (n / 2)) {

            System.out.println("\nTicket price: $10");
            currentIncome += 10;
            } else {
            System.out.println("\nTicket price: $8");
            currentIncome += 8;
            }
            }
            break;
        
        }
    } 
        break;

                            
    case 3:
        statistics();
        break;
    case 0:
        return;
                    // default:
                    //     System.out.println("Invalid input!");
                        
        }
        } while(input != 0);

        
        
    }

    
    public static void createCinema(){
        System.out.println("Enter the number of rows:");
         n = scanner.nextInt();
        
        System.out.println("Enter the number of seats in each row:");
         m = scanner.nextInt();
        
       array = new char[n][m];
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                array[i][j] = 'S';
            }
        }
        }



      //printing the seats 
    public static void printCinema(){
        System.out.println("Cinema:");
        System.out.print(" ");
                for (int i = 1; i <= array[0].length; i++) {
                    System.out.print(" " + i);
                }
                System.out.println();
        
        for (int i = 0; i < array.length; i++) {
        System.out.print(i + 1);
            for (int j = 0; j < array[0].length; j++) {
            System.out.print(" " + array[i][j]);
        }
        System.out.println(); 
        }
        
        }

    // calculation part
    
    // public static void takeCoordinate() {
    
           
    //    System.out.println(); 
    //    System.out.println("\nEnter a row number:");
    //    int row = scanner.nextInt();
       
    //    System.out.println("Enter a seat number in that row:");
    //    int seat = scanner.nextInt();
        
    //     System.out.println(); 

    //      //here is the exception part

    //     if ((row > n ) || (seat > m)) {
    //         System.out.println("Wrong Input!");
    //     } else if (array[row-1][seat-1] == 'B') {
    //         System.out.println("\nThat ticket has already been purchased!");
    //     } else {
    //         array[row-1][seat-1] = 'B';
    //         ticket++;

    //          if (n * m < 60) {
    //          System.out.println("\nTicket price: $10");
    //          currentIncome += 10;
    //          } else {

    //          if (row <= (n / 2)) {

    //         System.out.println("\nTicket price: $10");
    //         currentIncome += 10;
    //         } else {
    //         System.out.println("\nTicket price: $8");
    //         currentIncome += 8;
    //         }
    //         }
            
        
    //     }
        
        
    //     int totalSeats = array.length*array[0].length;
        
    //     if (totalSeats <= 60) {
    //      ticket = 10;
            
    //     } else {
    //         int frontHalf = array.length / 2;
    //         if (row <= frontHalf) {
    //             ticket = 10;
    //         } else {
    //             ticket = 8;
    //         }
    //     }
    //     System.out.println("\nTicket price: $" + ticket);
    //     array[row-1][seat-1] = 'B';
         
    
   
    // }

    //statistics
    
    public static void statistics() {
        double percentage = ( (100.00 / (n * m)) * (double) ticket);
         int totalIncome = ((n * m) <= 60) ? (n * m * 10) : (((n / 2) * m * 10) + ((n - (n / 2)) * m * 8));
                    System.out.println("\nNumber of purchased tickets: " + ticket);
                    System.out.printf("Percentage: %.2f%%\n", percentage);
                    System.out.println("Current income: $" + currentIncome);
                    System.out.println("Total income: $" + totalIncome);
    }
}
