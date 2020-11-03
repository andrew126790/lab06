import java.awt.*;
import java.io.*;
import java.util.Scanner;

public class NumericConversion {

    public static long hexStringDecode(String hex){
        String copy = hex; // copies the String
        int pow = 0; // sets the power value at 0
        long hexDecimal = 0; // creates the return variable
        // this loop runs through the hexCharDecode for each char in the String until it is done, while multiplying by 16^n
        for(int i = hex.length()-1; i >= 0; i--){
            hexDecimal += (hexCharDecode(copy.charAt(i)) * Math.pow(16,pow));
            pow++; // increases the power for 16
        }

        return hexDecimal;
    }
    public static short hexCharDecode(char digit){
        short hexChar = 0;
        String copy = String.valueOf(digit).toUpperCase(); // changes the char into an Uppercase value

            if(copy.charAt(0) >= '0' && copy.charAt(0) <= '9'){
                hexChar += (digit - 48); // decrements the char ASCII value to find decimal value
            }else if(copy.charAt(0) >= 'A' && copy.charAt(0) <= 'F' ){
                hexChar += (copy.charAt(0) -55); // decrements the char ASCII value to find decimal value
            }
        return hexChar;
    }
    public static short binaryStringDecode(String binary){
        short decimalNum = 0; // the decimal value variable for binary is created here
        String copy = binary; // creates a copy of the string
        int pow =0; // sets the power for 2 at 0
        short sum = 0; // a sum variable
        for(int i = binary.length()-1; i >= 0; i--){
            if (copy.charAt(i) == '1'){
                sum += Math.pow(2, pow);
            }
            pow++; // increments the power value
        }
        decimalNum = sum;

        return decimalNum;
    }

    public static String binaryToHex (String binary){
        String Hex = ""; // creates the return String
        int x = binaryStringDecode(binary);
        int count = 1;
        int y =x; // creates a second variable equal to binaryStringDecode
        //while loop manages the size of the String array
        while (y/16 >= 1){
            count++;
            y/= 16;
        }
        String arr[] = new String[count]; // String array is created to store the remainders
        for (int i = 0; i< arr.length; i++){
            arr[i] = "" + x%16;
            x/=16; // augments the value of x for the next loop
        }
        for(int j =0; j < arr.length; j++){
                // switch case changes the values of the String array to match Hexadecimal values
                switch (arr[j]){
                    case ""+ 10: arr[j] = "A"; break;
                    case ""+ 11: arr[j] = "B"; break;
                    case ""+ 12: arr[j] = "C"; break;
                    case ""+ 13: arr[j] = "D"; break;
                    case ""+ 14: arr[j] = "E"; break;
                    case ""+ 15: arr[j] = "F"; break;
                    // default case is necessary for when it does not meet the cases above
                    default:
                        break;
            }
        }
        // for loop adds the new hexadecimal values to the Hex String
        for(int j = 0; j <= arr.length; j++){
            Hex += arr[j];
        }

        return Hex;
    }

    public static int countRuns(byte[] flatData){
        int group = 1;
        for(int i = 0; i< flatData.length - 1; i++){
            int count = 1;
            for(int j = 0; j<flatData.length - 1; j++){
                if(flatData[j] == flatData[j+1]){
                    count++;
                }
                if(count > 15){
                    group++;
                }
            }
            group++;
        }
    }


    public static void main(String []args){
        Scanner input = new Scanner(System.in);
        boolean run = true; // boolean that keeps the while loop running
        while(run){
            // prints out the menu
            System.out.println(
                    "Decoding Menu\n"
                    +"-------------\n"
                    +"1. Decode hexadecimal\n"
                    +"2. Decode binary\n"
                    +"3. Convert binary to hexadecimal\n"
                    +"4. Quit ");

            System.out.println("Please enter an option: ");


            int z = input.nextInt();

            // while loop catches if the user entered in an incorrect value
            while (z != 1 && z != 2 && z != 3 && z != 4){
                System.out.println("Error: Invalid selection!");
                System.out.println("\nEnter Menu Selection: "); // prompts to enter in a new value
                z = input.nextInt();
            }

            //checks for the menu value at 1,2,3,4
            if(z == 1){
                System.out.println("Please enter the numeric string to convert: ");
                String x = input.next();
                    System.out.println("Result: "+hexStringDecode(x)); // prints out the result
            } else if(z == 2){
                System.out.println("Please enter the numeric string to convert:");
                String x = input.next();
                System.out.println("Result: "+binaryStringDecode(x)); // prints out the result
            }else if(z == 3){
                System.out.println("Please enter the numeric string to convert:");
                String x = input.next();
                System.out.println("Result: "+binaryToHex(x)); //prints out the result
            }else{
                //sets the value of the while loop to false
                run = false;
                System.out.println("Goodbye!");
            }
        }
    }
}
