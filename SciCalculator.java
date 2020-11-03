import java.util.Scanner;
public class SciCalculator {
    public static void main(String []args) {
        boolean continuous = true;
        Scanner input = new Scanner(System.in);
        int count = 0;
        double sum = 0;
        System.out.println("Current Result: 0.0\n"); // prints out the result without any calculations
        while(continuous) {
            System.out.println(
                            "Calculator Menu \n"
                            + "--------------- \n"
                            + "0. Exit Program \n"
                            + "1. Addition \n" // the \n's allow me to create a new line in the console within one print statement
                            + "2. Subtraction \n"
                            + "3. Multiplication \n"
                            + "4. Division \n"
                            + "5. Exponentiation \n"
                            + "6. Logarithm \n"
                            + "7. Display Average \n"
                            + "\nEnter Menu Selection: ");

            int z = input.nextInt();
            while (z != 1 && z != 2 && z != 3 && z != 4 && z != 5 && z != 6 && z != 7 && z != 0){ // while loop catches if the user entered in an incorrect value
                System.out.println("Error: Invalid selection!");
                System.out.println("\nEnter Menu Selection: ");
                z = input.nextInt();
            }
            while(z ==7 && count ==0){ // while loop catches if the 7 has been pressed before any calculations
                System.out.println("Error: No calculations yet to average!");
                System.out.println("\nEnter Menu Selection: ");
                z = input.nextInt();
            }
            while(z == 7){
                int op = (int)(sum/count *100); // integer caste and division allows me to use 2 decimal places
                double ops = op;
                System.out.println(
                        "Sum of calculations: \n" + sum +
                                "Number of calculations: \n" + count +
                                "Average of calculations: \n" + (ops/100)); // divide by 100 to have two decimal places for the answer
                System.out.println("Enter Menu Selection: "); // prompts the user to do a new value while the program is running
                z = input.nextInt();
            }

            double operation; // the result of any Calculator operation

            switch (z) {
                case 0:
                    continuous = false; // makes the loop stop, which ends the program
                    System.out.println("Thanks for using this calculator. Goodbye!");
                    break;
                case 1:
                    System.out.println("Enter first operand: ");
                    double x1 = input.nextDouble();
                    System.out.println("Enter second operand: ");
                    double y1 = input.nextDouble();

                    operation = x1 + y1;
                    System.out.println("Current Result: " + operation); // prints out result
                    sum += operation;
                    break;
                case 2:
                    System.out.println("Enter first operand: ");
                    double x2 = input.nextDouble();
                    System.out.println("Enter second operand: ");
                    double y2 = input.nextDouble();

                    operation = x2 - y2;
                    System.out.println("Current Result: " + operation); // prints out result
                    sum += operation;
                    break;
                case 3:
                    System.out.println("Enter first operand: ");
                    double x3 = input.nextDouble();
                    System.out.println("Enter second operand: ");
                    double y3 = input.nextDouble();

                    operation = x3 * y3;
                    System.out.println("Current Result: " + operation); // prints out result
                    sum += operation;
                    break;
                case 4:
                    System.out.println("Enter first operand: ");
                    double x4 = input.nextDouble();
                    System.out.println("Enter second operand: ");
                    double y4 = input.nextDouble();

                    operation = x4 / y4;
                    System.out.println("Current Result: " + operation); // prints out result
                    sum += operation;
                    break;
                case 5:
                    System.out.println("Enter first operand: ");
                    double x5 = input.nextDouble();
                    System.out.println("Enter second operand: ");
                    double y5 = input.nextDouble();

                    operation = Math.pow(x5,y5);
                    System.out.println("Current Result: " + operation); // prints out result
                    sum += operation;
                    break;
                case 6:
                    System.out.println("Enter first operand: ");
                    double x6 = input.nextDouble();
                    System.out.println("Enter second operand: ");
                    double y6 = input.nextDouble();

                    operation = Math.log(y6) / Math.log(x6);
                    System.out.println("Current Result: " + operation); // prints out result
                    sum += operation;
                    break;
                default:
                    // this case is needed if the other cases are not met
                    break;
            }
            count++; // adds to the number of calculations done
        }
    }
}
