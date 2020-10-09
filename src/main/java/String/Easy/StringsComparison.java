package String.Easy;

import java.util.Arrays;

public class StringsComparison {
    public static String[] uniqueNames(String[] names1, String[] names2) {



        java.util.Set<String> res = new java.util.HashSet<>();
        res.addAll(Arrays.asList(names1));
        res.addAll(Arrays.asList(names2));
        String ans[] = new String[res.size()];
        return res.toArray(ans);

        }

        public static void main(String[] args) {
            String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
            String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
            System.out.println(String.join(", ", StringsComparison.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
        }

}
