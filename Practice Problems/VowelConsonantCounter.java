public class VowelConsonantCounter {
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0, consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            if (Character.isLetter(c)) { if ("aeiou".indexOf(c) >= 0) vowels++; else consonants++; }
        }
        System.out.printf("Vowels: %d | Consonants: %d%n", vowels, consonants);
    }
    public static void main(String[] args) { countVowelsAndConsonants(args.length == 0 ? "Java Programming" : String.join(" ", args)); }
}
