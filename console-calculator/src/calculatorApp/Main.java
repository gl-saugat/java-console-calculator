package calculatorApp;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static UserInterface ui = new UserInterface(scanner);
    public static void main (String[] args){
        ui.startCalculator();
    }
}
