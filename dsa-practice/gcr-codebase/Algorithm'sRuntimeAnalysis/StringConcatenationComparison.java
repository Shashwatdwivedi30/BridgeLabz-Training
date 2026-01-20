public class StringConcatenationComparison {
    public static void main(String[] args) {

        int N = 100_000; 
        String text = "a";

        long startString = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < N; i++) {
            str = str + text;
        }
        long endString = System.currentTimeMillis();

        long startBuilder = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(text);
        }
        long endBuilder = System.currentTimeMillis();

        long startBuffer = System.currentTimeMillis();
        StringBuffer sf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sf.append(text);
        }
        long endBuffer = System.currentTimeMillis();

        System.out.println("Operations Count: " + N);
        System.out.println("String Time: " + (endString - startString) + " ms");
        System.out.println("StringBuilder Time: " + (endBuilder - startBuilder) + " ms");
        System.out.println("StringBuffer Time: " + (endBuffer - startBuffer) + " ms");
    }
}