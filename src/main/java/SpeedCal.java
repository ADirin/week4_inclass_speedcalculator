import java.util.Scanner;

public class SpeedCal {

        // Convert kilometers to miles
        public static double kilometersToMiles(double kilometers) {
            return kilometers * 0.621371;
        }

        // Convert miles to kilometers
        public static double milesToKilometers(double miles) {
            return miles / 0.621371;
        }

        // Calculate speed (distance / time)
        public static double calculateSpeed(double distance, double time) {
            if (time <= 0) {
                throw new IllegalArgumentException("Time must be greater than zero.");
            }
            return distance / time;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Ask for distance
            System.out.print("Enter the distance to travel: ");
            double distance = scanner.nextDouble();

            // Ask for unit
            System.out.print("Is the distance in (K)ilometers or (M)iles? ");
            char unit = scanner.next().toUpperCase().charAt(0);

            // Convert if necessary
            double distanceInKm;
            if (unit == 'M') {
                distanceInKm = milesToKilometers(distance);
                System.out.printf("That is %.2f kilometers.%n", distanceInKm);
            } else {
                distanceInKm = distance;
                System.out.printf("That is %.2f miles.%n", kilometersToMiles(distance));
            }

            // Ask for time
            System.out.print("Enter the travel time (in hours): ");
            double time = scanner.nextDouble();

            // Calculate speed
            double speed = calculateSpeed(distance, time);

            // Show result
            if (unit == 'M') {
                System.out.printf("Your speed is %.2f miles per hour.%n", speed);
            } else {
                System.out.printf("Your speed is %.2f kilometers per hour.%n", speed);
            }

            scanner.close();
        }
}
