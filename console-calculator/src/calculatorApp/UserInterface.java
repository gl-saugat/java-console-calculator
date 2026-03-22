    package calculatorApp;

    import java.util.ArrayList;
    import java.util.Scanner;
    import java.util.concurrent.ExecutionException;

    public class UserInterface {
        Scanner scan;
        Calculation logic;
        ArrayList<String> history = new ArrayList<>();

        public UserInterface(Scanner scanner) {
            this.scan = scanner;
            logic = new Calculation();
        }

        public void startCalculator() {
            boolean run = true;
            while (run) {

                int input = getChoice();
                if (input == 6) {
                    run = false;
                    System.out.println("Thanks for trying.");
                    break;
                }

                if(input == 5){
                    getHistory().forEach(System.out::println);
                }else{
                    double input1 = getNumberInput("first", input);
                    double input2 = getNumberInput("second", input);
                    System.out.println(getResult(input, input1, input2));
                }



            }
        }

        private void printMenu() {
            System.out.println("What operations would you like to perform? Press the equivalent number to the operation.");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiply");
            System.out.println("4. Division");
            System.out.println("5. History");
            System.out.println("6. Exit");
        }

        private int getChoice(){
            int input= 0;
            while(!(input>0 && input <7)){
                printMenu();
                try{
                    input = Integer.parseInt(scan.nextLine());
                    if(input <= 0 || input > 6){
                        System.out.println("Enter a valid number.");
                    }
                }catch (Exception e){
                    System.out.println("Enter a valid number.");

                }

            }
            return input;
        }

        private double getNumberInput(String text, int choice){
            double number = 0.0;
            boolean loop =true;
            while(loop){
                System.out.println("Enter the "+text+" number:");
                try{
                    number = Double.parseDouble(scan.nextLine());

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

        private String getResult(int input, double input1, double input2){
            String result = "";
            double tmp = 0.0;
            switch (input) {
                case 1:
                    tmp = logic.add(input1, input2);
                    result = "Sum = " + tmp;
                    addToHistory("+", input1, input2, tmp);
                    break;
                case 2:
                    tmp = (logic.difference(input1, input2));
                    result ="Difference = " + tmp;
                    addToHistory("-", input1, input2, tmp);
                    break;

                case 3:
                    tmp = (logic.multiplication(input1, input2));
                    result ="Multiplication = " + tmp;
                    addToHistory("*", input1, input2, tmp);
                    break;
                case 4:
                    try{
                        tmp = (logic.division(input1, input2));
                        result ="Division = " + tmp;
                        addToHistory("/", input1, input2, tmp);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;

            }

            return result;
        }

        public ArrayList<String> getHistory(){
            return this.history;
        }

        public void addToHistory(String operator, double input1, double input2, double result){
            history.add(input1 + operator + input2 + " = " + result);
        }
    }
