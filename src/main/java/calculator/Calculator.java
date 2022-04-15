package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public Calculator() {
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double d_number1, d_number2;
        int i_number1, i_number2;

        // When the Docker container is started in the background via Ansible and you attach your terminal to it,
        // the initial application System.out.println statements are wiped out, to avoid that we use this stop-gap fix
        // Only enter the application once the user has pressed Enter key on the terminal.
        System.out.println("Press Enter key to start the application\n");
        scanner.nextLine();

        do {
            System.out.println("Calculator-DevOps, Choose to perform operation");
            System.out.print(
                "Press 1 to find Factorial\n" +
                "Press 2 to find Square Root\n" +
                "Press 3 to find Power\n" +
                "Press 4 to find Natural Logarithm\n" +
                "Press 5 to Exit\n" +
                "Enter your choice: "
            );

            int choice;

            try {
                choice = scanner.nextInt();
            }
            catch (InputMismatchException error) {
                return;
            }

            switch (choice) {
                case 1:
                    // find factorial
                    System.out.print("Enter a number : ");
                    i_number1 = scanner.nextInt();
                    System.out.println("Factorial of " + i_number1 + " is : " + calculator.factorial(i_number1));
                    System.out.println("\n");

                    break;

                case 2:
                    // find square root
                    System.out.print("Enter a number : ");
                    d_number1 = scanner.nextDouble();
                    System.out.println("Square root of " + d_number1 + " is : " + calculator.squareRoot(d_number1));
                    System.out.println("\n");
                    break;

                case 3:
                    // find power
                    System.out.print("Enter the first number : ");
                    d_number1 = scanner.nextDouble();
                    System.out.print("Enter the second number : ");
                    d_number2 = scanner.nextDouble();
                    System.out.println(d_number1 + " raised to " + d_number2 +" is : " + calculator.power(d_number1, d_number2));
                    System.out.println("\n");
                    break;

                case 4:
                    // find natural log
                    System.out.print("Enter a number : ");
                    d_number1 = scanner.nextDouble();
                    System.out.println("Natural log of " + d_number1 + " is : " + calculator.naturalLog(d_number1));
                    System.out.println("\n");
                    break;

                default:
                    System.out.println("Exiting....");
                    return;
            }
        } while (true);
    }

    public int factorial(int number1) {
        logger.info("[FACTORIAL] - " + number1);

        int result = 1;
        for(int i = 1; i <= number1; i++)
            result *= i;

        logger.info("[RESULT - FACTORIAL] - " + result);
        return result;
    }

    public double squareRoot(double number1) {
        logger.info("[SQ ROOT] - " + number1);
        double result = Math.sqrt(number1);
        logger.info("[RESULT - SQ ROOT] - " + result);
        return result;
    }

    public double power(double number1, double number2) {
        logger.info("[POWER - " + number1 + " RAISED TO] " + number2);
        double result = Math.pow(number1,number2);
        logger.info("[RESULT - POWER] - " + result);
        return result;
    }

    public double naturalLog(double number1) {
        logger.info("[NATURAL LOG] - " + number1);
        double result = 0;

        try {
            if (number1 < 0) {
                result = Double.NaN;
                throw new ArithmeticException("Case of NaN 0.0/0.0");
            }
            else
                result = Math.log(number1);
        }
        catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - LOG] - Cannot find log of negative numbers " + error.getLocalizedMessage());
        }
        logger.info("[RESULT - NATURAL LOG] - " + result);
        return result;
    }
}
