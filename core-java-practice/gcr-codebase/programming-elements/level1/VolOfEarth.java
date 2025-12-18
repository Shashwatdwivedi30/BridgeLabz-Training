public class VolOfEarth {
    public static void main(String[] args) {
        int km_radius = 6378;
        double miles_radius = km_radius / 1.6;
        double volume_km = (4.0/3) * 3.14 * Math.pow(km_radius, 3);
        double volume_miles = (4.0/3) * 3.14 * Math.pow(miles_radius, 3);
        System.out.println("The volume of earth in cubic kilometers is "+volume_km+" and cubic miles is "+volume_miles);
    }
}