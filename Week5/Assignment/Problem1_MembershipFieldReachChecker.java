class LibraryMember {
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;
}

public class Problem1_MembershipFieldReachChecker {
    static String classifyAccess(String fieldModifier, String accessorContext) {
        boolean sameClass = "SAME_CLASS".equals(accessorContext);
        boolean samePackage = "SAME_PACKAGE".equals(accessorContext);
        boolean differentPackage = "DIFFERENT_PACKAGE".equals(accessorContext);

        if (sameClass) return "ALLOWED";
        switch (fieldModifier) {
            case "private": return "DENIED";
            case "default": return samePackage ? "ALLOWED" : "DENIED";
            case "protected": return (samePackage || differentPackage) ? "ALLOWED" : "DENIED";
            case "public": return "ALLOWED";
            default: return "DENIED";
        }
    }

    static String summarizeByModifier(String[][] attempts) {
        String[] modifiers = {"private", "default", "protected", "public"};
        int[][] counts = new int[4][2]; // allowed, denied

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt == null || attempt.length < 2) continue;
                for (int i = 0; i < modifiers.length; i++) {
                    if (modifiers[i].equals(attempt[0])) {
                        int result = classifyAccess(attempt[0], attempt[1]).equals("ALLOWED") ? 0 : 1;
                        counts[i][result]++;
                        break;
                    }
                }
            }
        }

        StringBuilder report = new StringBuilder();
        for (int i = 0; i < modifiers.length; i++) {
            if (i > 0) report.append(" | ");
            report.append(modifiers[i]).append(": ")
                  .append(counts[i][0]).append(" allowed / ")
                  .append(counts[i][1]).append(" denied");
        }
        return report.toString();
    }

    public static void main(String[] args) {
        String[][] attempts = {
            {"private", "SAME_CLASS"}, {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"}, {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"}, {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));
        System.out.println(summarizeByModifier(attempts));
    }
}