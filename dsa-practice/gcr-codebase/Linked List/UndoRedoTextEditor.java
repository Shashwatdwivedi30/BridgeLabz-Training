public class UndoRedoTextEditor {

    // Node class
    static class TextState {
        String text;
        TextState prev;
        TextState next;

        TextState(String text) {
            this.text = text;
            this.prev = null;
            this.next = null;
        }
    }

    static TextState head = null;
    static TextState tail = null;
    static TextState current = null;
    static int size = 0;
    static final int MAX_HISTORY = 10;

    // Add new text state
    static void addState(String newText) {

        TextState newState = new TextState(newText);

        // Clear redo history if adding after undo
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
            size = countStates();
        }

        if (head == null) {
            head = tail = current = newState;
            size = 1;
            return;
        }

        tail.next = newState;
        newState.prev = tail;
        tail = newState;
        current = newState;
        size++;

        // Limit history size
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo operation
    static void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo available");
        }
    }

    // Redo operation
    static void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo available");
        }
    }

    // Display current text
    static void displayCurrentState() {
        if (current != null) {
            System.out.println("Current Text: " + current.text);
        } else {
            System.out.println("Editor is empty");
        }
    }

    // Count states (helper)
    static int countStates() {
        int count = 0;
        TextState temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Main method
    public static void main(String[] args) {

        addState("H");
        addState("He");
        addState("Hel");
        addState("Hell");
        addState("Hello");

        displayCurrentState();

        undo();
        undo();
        displayCurrentState();

        redo();
        displayCurrentState();

        addState("Hello World");
        displayCurrentState();

        redo(); // no redo possible
    }
}