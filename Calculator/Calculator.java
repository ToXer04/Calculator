import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        String[] arr = {};
        double result = 0;
        boolean bool = true;
        Scanner in = new Scanner(System.in);
        while (bool) {
            System.out.println("Type a list of numbers (ex: 1, 2, 3.4, 5)");
            String numbers = in.nextLine();
            arr = numbers.split(", ");
            for (String x : arr) {
                try {
                    if (Double.parseDouble(x) % 2 == 0) {
                        System.out.println("The number " + x + " is even");
                    } else if (Double.parseDouble(x) % 2 != 0) {
                        System.out.println("The number " + x + " is odd");
                    }
                    bool = false;
                } catch (NumberFormatException nfe) {
                    System.out.println(x + " is a not valid a number");
                    bool = true;
                    break;
                }
            }
        }
        System.out.println("Type an operator ( + | - | * | / | ^ )");
        String operator = in.nextLine();
        if(arr.length == 0) {
            System.out.println("To use the calculator you have to give as input at least a number");
        } else {
            switch (operator) {
                case "+":
                    result = sum(arr, result);
                    break;
                case "-":
                    result = sub(arr, result);
                    break;
                case "*":
                    result = mul(arr, result);
                    break;
                case "/":
                    result = div(arr, result);
                    break;
                case "^":
                    result = pow(arr, result);
                    break;
                default:
            }
            System.out.println(result);
        }
    }