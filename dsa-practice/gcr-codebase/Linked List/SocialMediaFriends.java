public class SocialMediaFriends {

    // User Node
    static class User {
        int userId;
        String name;
        int age;

        int[] friends = new int[10]; // store friend IDs
        int friendCount = 0;

        User next;

        User(int userId, String name, int age) {
            this.userId = userId;
            this.name = name;
            this.age = age;
            this.next = null;
        }
    }

    static User head = null;

    // Add new user
    static void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);

        if (head == null) {
            head = newUser;
            return;
        }

        User temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newUser;
    }

    // Search user by ID
    static User searchById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Search user by Name
    static User searchByName(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add friend connection
    static void addFriend(int id1, int id2) {
        User u1 = searchById(id1);
        User u2 = searchById(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        u1.friends[u1.friendCount++] = id2;
        u2.friends[u2.friendCount++] = id1;
    }

    // Remove friend connection
    static void removeFriend(int id1, int id2) {
        User u1 = searchById(id1);
        User u2 = searchById(id2);

        if (u1 == null || u2 == null) return;

        removeFriendFromList(u1, id2);
        removeFriendFromList(u2, id1);
    }

    static void removeFriendFromList(User user, int friendId) {
        for (int i = 0; i < user.friendCount; i++) {
            if (user.friends[i] == friendId) {
                for (int j = i; j < user.friendCount - 1; j++) {
                    user.friends[j] = user.friends[j + 1];
                }
                user.friendCount--;
                return;
            }
        }
    }

    // Display friends of a user
    static void displayFriends(int userId) {
        User user = searchById(userId);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        System.out.print("Friends of " + user.name + ": ");
        for (int i = 0; i < user.friendCount; i++) {
            System.out.print(user.friends[i] + " ");
        }
        System.out.println();
    }

    // Find mutual friends
    static void mutualFriends(int id1, int id2) {
        User u1 = searchById(id1);
        User u2 = searchById(id2);

        if (u1 == null || u2 == null) return;

        System.out.print("Mutual Friends: ");
        for (int i = 0; i < u1.friendCount; i++) {
            for (int j = 0; j < u2.friendCount; j++) {
                if (u1.friends[i] == u2.friends[j]) {
                    System.out.print(u1.friends[i] + " ");
                }
            }
        }
        System.out.println();
    }

    // Count friends of each user
    static void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(
                    temp.name + " has " + temp.friendCount + " friends"
            );
            temp = temp.next;
        }
    }

    // Display all users
    static void displayUsers() {
        User temp = head;
        while (temp != null) {
            System.out.println(
                    temp.userId + " | " + temp.name + " | Age: " + temp.age
            );
            temp = temp.next;
        }
    }

    // Main method
    public static void main(String[] args) {

        addUser(1, "Amit", 22);
        addUser(2, "Riya", 21);
        addUser(3, "Karan", 23);
        addUser(4, "Neha", 20);

        addFriend(1, 2);
        addFriend(1, 3);
        addFriend(2, 3);
        addFriend(2, 4);

        displayUsers();

        displayFriends(2);

        mutualFriends(1, 2);

        removeFriend(1, 3);

        System.out.println("\nAfter removing friendship:");
        displayFriends(1);

        countFriends();
    }
}