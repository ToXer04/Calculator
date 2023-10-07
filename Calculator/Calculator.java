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
        if (arr.length == 0) {
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
    public static double sum(String[] arr, double result) {
        for (String s : arr) {
            result += Double.parseDouble(s);
        }
        return result;
    }
    public static double sub(String[] arr, double result) {
        result = Double.parseDouble(arr[0]);
        for (int i=1;i<arr.length;i++) {
            result -= Double.parseDouble(arr[i]);
        }
        return result;
    }
    public static double mul(String[] arr, double result) {
        result = Double.parseDouble(arr[0]);
        for (int i=1;i<arr.length;i++) {
            result *= Double.parseDouble(arr[i]);
        }
        return result;
    }
    public static double div(String[] arr, double result) {
        result = Double.parseDouble(arr[0]);
        for (int i=1;i<arr.length;i++) {
            if(Double.parseDouble(arr[i])==0) {
                System.out.println("You can't divide a number by 0");
                result = Double.parseDouble("NaN");
                break;
            } else {
                result /= Double.parseDouble(arr[i]);
            }
        }
        return result;
    }
    public static double pow(String[] arr, double result) {
        result = Double.parseDouble(arr[0]);
        if(arr.length != 2) {
            System.out.println("To use this operator you have to give as input two numbers");
            result = Double.parseDouble("NaN");
        } else {
            for(int i = 1;i<arr.length;i++) {
                double num = Double.parseDouble(arr[i]);
                while(num > 1) {
                    result *= Double.parseDouble(arr[0]);
                    num--;
                }
            }
        }
        return result;
    }
}
