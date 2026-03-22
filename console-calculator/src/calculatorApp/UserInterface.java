    package calculatorApp;

    import java.util.Scanner;
    import java.util.concurrent.ExecutionException;

    public class UserInterface {
        Scanner scan;
        Calculation logic;

        public UserInterface(Scanner scanner) {
            this.scan = scanner;
            logic = new Calculation();
        }

        public void startCalculator() {
            boolean run = true;
            while (run) {

                int input = getChoice(scan);
                if (input == 5) {
                    run = false;
                    System.out.println("Thanks for trying.");
                } else {

                    double input1 = getNumberInput(scan, "first", input);
                    double input2 = getNumberInput(scan, "second", input);

                    switch (input) {
                        case 1:
                            System.out.println(logic.add(input1, input2));
                            break;
                        case 2:
                            System.out.println(logic.difference(input1, input2));
                            ;
                            break;

                        case 3:
                            System.out.println(logic.multiplication(input1, input2));
                            ;
                            break;
                        case 4:
                            System.out.println(logic.division(input1, input2));
                            ;
                            break;

                    }

                }
            }
        }

        private void printMenu() {
            System.out.println("What operations would you like to perform? Press the equivalent number to the operation.");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiply");
            System.out.println("4. Division");
            System.out.println("5. Exit");
        }

        private int getChoice(Scanner scanner){
            int input= 0;
            while(!(input>0 && input <6)){
                printMenu();
                try{
                    input = Integer.parseInt(scanner.nextLine());
                    if(input <= 0 || input > 5){
                        System.out.println("Enter a valid number.");
                    }
                }catch (Exception e){
                    System.out.println("Enter a valid number.");

                }

            }
            return input;
        }

        private double getNumberInput(Scanner scanner, String text, int choice){
            double number = 0.0;
            boolean loop =true;
            while(loop){
                System.out.println("Enter the "+text+" number:");
                try{
                    number = Double.parseDouble(scanner.nextLine());

                    if(choice == 4 && number == 0 && text.equals("second")){
                        System.out.println("Error: Division by zero.");
                        continue;
                    }
                    loop = false;

                }catch(Exception e){
                    System.out.println("Enter a valid number");
                }
            }

            return number;
        }
    }
