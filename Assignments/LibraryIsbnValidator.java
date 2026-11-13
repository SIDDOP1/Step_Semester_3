public class LibraryIsbnValidator {
    public static String normalizeCode(String raw) {
        String code = raw.trim(); return code.length() < 3 ? code.toUpperCase() : code.substring(0, 3).toUpperCase() + code.substring(3);
    }
    public static String validateAndFormat(String code) {
        if (code.length() != 13) return "Invalid: code must be exactly 13 characters";
        for (int i = 0; i < 3; i++) if (!Character.isLetter(code.charAt(i))) return "Invalid: publisher code must be 3 letters";
        for (int i = 3; i < code.length(); i++) if (!Character.isDigit(code.charAt(i))) return "Invalid: code body must contain 10 digits";
        StringBuilder result = new StringBuilder("[").append(code, 0, 3).append("] YEAR: ")
                .append(code, 3, 7).append(" | CATALOG: ").append(code, 7, 13);
        return result.toString();
    }
    public static void main(String[] args) { String raw = args.length == 0 ? " pen2026004251 " : String.join(" ", args); System.out.println(validateAndFormat(normalizeCode(raw))); }
}
