public class UnitConvertor2 {

    // Fahrenheit to Celsius
    public static double convertFarhenheitToCelsius(double farhenheit) {
        return (farhenheit - 32) * 5 / 9;
    }

    // Celsius to Fahrenheit
    public static double convertCelsiusToFarhenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Pounds to Kilograms
    public static double convertPoundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    // Kilograms to Pounds
    public static double convertKilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    // Gallons to Liters
    public static double convertGallonsToLiters(double gallons) {
        return gallons * 3.78541;
    }

    // Liters to Gallons
    public static double convertLitersToGallons(double liters) {
        return liters * 0.264172;
    }
}
