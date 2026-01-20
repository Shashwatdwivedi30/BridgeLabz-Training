import java.util.Stack;

public class BrowserBuddy {
    static class Page {
        String url;
        Page prev;
        Page next;

        Page(String url) {
            this.url = url;
        }
    }

    static class BrowserTab {
        Page current;
        void visit(String url) {
            Page newPage = new Page(url);

            if (current != null) {
                current.next = newPage;
                newPage.prev = current;
            }

            current = newPage;
            System.out.println("Visited: " + url);
        }

        void back() {
            if (current == null || current.prev == null) {
                System.out.println("No page to go back");
                return;
            }
            current = current.prev;
            System.out.println("Back to: " + current.url);
        }

        void forward() {
            if (current == null || current.next == null) {
                System.out.println("No page to go forward");
                return;
            }
            current = current.next;
            System.out.println("Forward to: " + current.url);
        }

        String getCurrentPage() {
            return current != null ? current.url : "No page open";
        }
    }

    static Stack<BrowserTab> closedTabs = new Stack<>();

    static void closeTab(BrowserTab tab) {
        closedTabs.push(tab);
        System.out.println("Tab closed");
    }

    static BrowserTab restoreTab() {
        if (closedTabs.isEmpty()) {
            System.out.println("No closed tabs to restore");
            return null;
        }
        System.out.println("Tab restored");
        return closedTabs.pop();
    }

    public static void main(String[] args) {

        BrowserTab tab1 = new BrowserTab();

        tab1.visit("google.com");
        tab1.visit("github.com");
        tab1.visit("stackoverflow.com");

        tab1.back();
        tab1.back();
        tab1.forward();

        System.out.println("Current Page: " + tab1.getCurrentPage());

        closeTab(tab1);

        BrowserTab restoredTab = restoreTab();
        if (restoredTab != null) {
            System.out.println("Restored Tab Current Page: " +
                    restoredTab.getCurrentPage());
        }
    }
}