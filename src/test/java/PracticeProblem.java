import java.util.*;
public class PracticeProblem {

	public static void main(String args[]) {

	}

    public static ArrayList<String> permDemo(String word) {
        ArrayList<String> permutations = new ArrayList<>();
        permDemoHelper("", word, permutations);
        return permutations;
    }

    
    public static void permDemoHelper(String usedLetters, String unusedLetters, ArrayList<String> permutations) {
        if (unusedLetters.length() == 0) {
            permutations.add(usedLetters);
            return;
        }

        
        for (int i = 0; i < unusedLetters.length(); i++) {
            char c = unusedLetters.charAt(i);
            String nextUsed = usedLetters + c;
            String nextUnused = unusedLetters.substring(0, i) + unusedLetters.substring(i + 1);
            permDemoHelper(nextUsed, nextUnused, permutations);
        }
    }

    public static ArrayList<String> perms(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null) return res;
        permDemoHelper("", str, res);
        return res;
    }

    public static ArrayList<String> permsUnique(String str) {
        ArrayList<String> all = new ArrayList<>();
        if (str == null) return all;
        permDemoHelper("", str, all);

        Set<String> seen = new LinkedHashSet<>(all);
        return new ArrayList<>(seen);
    }
}

