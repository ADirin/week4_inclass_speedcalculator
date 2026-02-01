import java.util.Scanner;

public class SpeedCalculator {

    // Converts kilometers to miles
    public static double convertKilometersToMiles(double kilometers) {
        return kilometers * 0.62;
    }

    // Converts miles to kilometers
    public static double convertMilesToKilometers(double miles) {
        return miles / 0.62;
    }

    // Calculates speed (distance per hour)
    public static double calculateSpeed(double distance, double timeInHours) {
        if (timeInHours <= 0) {
            throw new IllegalArgumentException("Time must be greater than zero.");
        }
        return distance / timeInHours;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get distance from user
        System.out.print("Enter the distance to travel: ");
        double distance = input.nextDouble();

        // Ask for distance unit
        System.out.print("Is the distance in (K)ilometers or (M)iles? ");
        char unit = input.next().toUpperCase().charAt(0);

        // Convert distance to kilometers if needed
        double distanceInKilometers;
        if (unit == 'M') {
            distanceInKilometers = convertMilesToKilometers(distance);
            System.out.printf("Distance converted to kilometers: %.2f km%n"+ distanceInKilometers);
        } else {
            distanceInKilometers = distance;
            System.out.printf("Distance in miles: %.2f mi%n"+ convertKilometersToMiles(distance));
        }

        // Get travel time
        System.out.print("Enter the travel time (in hours): ");
        double timeInHours = input.nextDouble();

        // Calculate speed using kilometers
        double speedInKilometersPerHour = calculateSpeed(distanceInKilometers, timeInHours);

        // Display final speed
        if (unit == 'M') {
            double speedInMilesPerHour = convertKilometersToMiles(speedInKilometersPerHour);
            System.out.printf("Average speed: %.2f miles per hour%n"+ speedInMilesPerHour);
        } else {
            System.out.printf("Average speed: %.2f kilometers per hour%n"+ speedInKilometersPerHour);
        }

        input.close();
    }
}
