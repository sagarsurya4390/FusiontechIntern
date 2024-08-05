import java.util.Scanner;

public class TempConvert{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display the menu
            System.out.println("Temperature Conversion Program");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Celsius to Kelvin");
            System.out.println("4. Kelvin to Celsius");
            System.out.println("5. Fahrenheit to Kelvin");
            System.out.println("6. Kelvin to Fahrenheit");
            System.out.println("7. Exit");
            System.out.print("Choose a conversion type: ");

            int choice = scanner.nextInt();

            if (choice == 7) {
                System.out.println("Exiting program...");
                break;
            }

            System.out.print("Enter the temperature value: ");
            double temperature = scanner.nextDouble();

            double convertedTemperature = 0;
            switch (choice) {
                case 1:
                    convertedTemperature = celsiusToFahrenheit(temperature);
                    System.out.printf("Temperature in Fahrenheit: %.2f\n", convertedTemperature);
                    break;
                case 2:
                    convertedTemperature = fahrenheitToCelsius(temperature);
                    System.out.printf("Temperature in Celsius: %.2f\n", convertedTemperature);
                    break;
                case 3:
                    convertedTemperature = celsiusToKelvin(temperature);
                    System.out.printf("Temperature in Kelvin: %.2f\n", convertedTemperature);
                    break;
                case 4:
                    convertedTemperature = kelvinToCelsius(temperature);
                    System.out.printf("Temperature in Celsius: %.2f\n", convertedTemperature);
                    break;
                case 5:
                    convertedTemperature = fahrenheitToKelvin(temperature);
                    System.out.printf("Temperature in Kelvin: %.2f\n", convertedTemperature);
                    break;
                case 6:
                    convertedTemperature = kelvinToFahrenheit(temperature);
                    System.out.printf("Temperature in Fahrenheit: %.2f\n", convertedTemperature);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5/9 + 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        return (kelvin - 273.15) * 9/5 + 32;
    }
}
