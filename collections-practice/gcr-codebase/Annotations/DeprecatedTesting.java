class LegacyAPI {
    @Deprecated
    public void oldFeature() {
        System.out.println("This is the OLD feature (deprecated).");
    }

    public void newFeature() {
        System.out.println("This is the NEW feature!");
    }
}

public class DeprecatedTesting {
    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature();   // Deprecated warning
        api.newFeature();
    }
}
