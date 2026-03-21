package calculatorApp;

import java.util.Scanner;

public class UserInterface {
    Scanner scan;
    Calculation logic;
    public UserInterface(Scanner scanner){
        this.scan = scanner;
        logic = new Calculation();
    }

    public void start(){
        boolean run = true;
        while(run){
            System.out.println("What operations would you like to perform? Press the equivalent number to the operation.");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiply");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            int input = scan.nextInt();
            scan.nextLine();

            if(input == 5){
                run = false;
                System.out.println("Thanks for trying.");
            }else{
                System.out.println("Enter the first number");
                double input1 = Double.parseDouble(scan.nextLine());
                System.out.println("Enter the second number");
                double input2 = Double.parseDouble(scan.nextLine());



                switch (input){
                    case 1:
                        System.out.println(logic.add(input1, input2));
                        break;
                    case 2:
                        System.out.println(logic.difference(input1, input2));;
                        break;

                    case 3:
                        System.out.println(logic.multiplication(input1, input2));;
                        break;
                    case 4:
                        System.out.println(logic.division(input1, input2));;
                        break;

                }



            }
        }
    }




}
