public class BankTransactionReferenceValidator {
    public static String normalizeReference(String raw) {
        String ref = raw.trim(); return ref.length() < 3 ? ref.toUpperCase() : ref.substring(0, 3).toUpperCase() + ref.substring(3);
    }
    public static String validateAndFormat(String ref) {
        if (ref.length() != 14) return "Invalid: reference must be exactly 14 characters";
        for (int i = 0; i < 3; i++) if (!Character.isLetter(ref.charAt(i))) return "Invalid: bank code must be 3 letters";
        for (int i = 3; i < 14; i++) if (!Character.isDigit(ref.charAt(i))) return "Invalid: reference body must contain 11 digits";
        return new StringBuilder("[").append(ref, 0, 3).append("] DATE: ").append(ref, 3, 5).append('/')
                .append(ref, 5, 7).append('/').append(ref, 7, 9).append(" | SEQ: ").append(ref, 9, 14).toString();
    }
    public static void main(String[] args) { String raw = args.length == 0 ? " hdf03022600042 " : String.join(" ", args); System.out.println(validateAndFormat(normalizeReference(raw))); }
}
