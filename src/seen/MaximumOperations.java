package seen;

public class MaximumOperations {
    static long getMaximumOperations(String s){
        int maxOperations = 0;

        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i - 1) == s.charAt(i) && s.charAt(i) != s.charAt(i + 1)) {
                maxOperations++;
                s = s.substring(0, i + 1) + s.charAt(i) + s.substring(i + 2);
            }
        }

        return maxOperations;
    }
    public static void main(String[] args) {
        System.out.println(getMaximumOperations("accept"));
    }
}
