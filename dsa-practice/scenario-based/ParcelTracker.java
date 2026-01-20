public class ParcelTracker {

    static class Stage {
        String name;
        Stage next;

        Stage(String name) {
            this.name = name;
            this.next = null;
        }
    }

    static Stage head = null;

    static void addStage(String stageName) {
        Stage newStage = new Stage(stageName);

        if (head == null) {
            head = newStage;
            return;
        }

        Stage temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStage;
    }

    static void addAfter(String existingStage, String newStage) {
        Stage temp = head;

        while (temp != null && !temp.name.equals(existingStage)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Stage not found: " + existingStage);
            return;
        }

        Stage stage = new Stage(newStage);
        stage.next = temp.next;
        temp.next = stage;
    }

    static void displayJourney() {
        if (head == null) {
            System.out.println("Parcel lost or missing!");
            return;
        }

        Stage temp = head;
        System.out.print("Parcel Journey: ");
        while (temp != null) {
            System.out.print(temp.name + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {

        addStage("Packed");
        addStage("Shipped");
        addStage("In Transit");
        addStage("Delivered");

        addAfter("Shipped", "Custom Checkpoint");

        displayJourney();
    }
}