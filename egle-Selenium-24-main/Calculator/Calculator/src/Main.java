import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //System.out.println("Enter an operation");
        //String operator = scanner.next();

        //if operator =="quit"
        {
            while (true) {
                String operator = readText(scanner, "Enter an operation (or 'quit' to exit):");
                if (operator.equals("quit"))
                    break;

                int a = realNumber(scanner, "Enter first number");
                int b = realNumber(scanner, "Enter a second number");

                Integer result = null;
                Boolean comparison = null;
                switch (operator) {
                    case "+" -> result = a + b;
                    case "-" -> result = a - b;
                    case "*" -> result = a * b;
                    case "/" -> result = a / b;
                    case "%" -> result = a % b;
                    case ">" -> comparison = a > b;
                    case "<" -> comparison = a < b;
                    case ">=" -> comparison = a >= b;
                    case "<=" -> comparison = a <= b;
                    case "!=" -> comparison = a != b;
                    default -> {
                        System.err.println("Operator does not exist");
                        return;
                    }

                }

                if (comparison != null) {
                    System.out.println("Result= ");
                    System.out.println(comparison);
                    return;
                }
                System.out.println("Result= ");
                System.out.println(result);
            }
        }
       // System.out.println("Result= ");
       // System.out.println(a + b);
    }
    private static int realNumber(Scanner scanner, String prompt){
        System.out.println(prompt);
        return scanner.nextInt();
    }
    private static String readText(Scanner s, String prompt){
        System.out.println(prompt);
        return s.next();
    }
}