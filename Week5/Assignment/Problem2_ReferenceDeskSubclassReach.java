public class Problem2_ReferenceDeskSubclassReach {
    static String classifyAccess(String fieldModifier, String accessorContext) {
        if ("SAME_CLASS".equals(accessorContext)) return "ALLOWED";
        if ("SAME_PACKAGE".equals(accessorContext)) {
            return "private".equals(fieldModifier) ? "DENIED" : "ALLOWED";
        }
        if ("DIFFERENT_PACKAGE".equals(accessorContext)) {
            return "public".equals(fieldModifier) ? "ALLOWED" : "DENIED";
        }
        if ("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE".equals(accessorContext)) {
            return ("protected".equals(fieldModifier) || "public".equals(fieldModifier))
                    ? "ALLOWED" : "DENIED";
        }
        if ("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE".equals(accessorContext)) {
            return "public".equals(fieldModifier) ? "ALLOWED" : "DENIED";
        }
        return "DENIED";
    }

    static String firstDeniedAttempt(String[][] attempts) {
        if (attempts == null) return "None Denied";
        for (int i = 0; i < attempts.length; i++) {
            String[] attempt = attempts[i];
            if (attempt == null || attempt.length < 2) continue;
            if ("DENIED".equals(classifyAccess(attempt[0], attempt[1]))) {
                return attempt[0] + " via " + attempt[1] + " (attempt #" + (i + 1) + ")";
            }
        }
        return "None Denied";
    }

    public static void main(String[] args) {
        String[][] attempts = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println(firstDeniedAttempt(attempts));
        System.out.println(classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
    }
}