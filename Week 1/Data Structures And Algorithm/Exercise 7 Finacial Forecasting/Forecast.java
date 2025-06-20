import java.util.Scanner;

public class Forecast {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the initial amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter the growth rate: ");
        double rate = sc.nextDouble();

        System.out.print("Enter the number of years: ");
        int years = sc.nextInt();

        sc.close();

        double result = calcForecast(amount, rate, years);
        System.out.printf("The forecasted amount after %d years is: %.2f\n", years, result);
    }

    public static double calcForecast(double amount, double rate, int years) {
        if (years == 0)
            return amount;
        return calcForecast(amount * (1 + rate), rate, years - 1);
    }
}
