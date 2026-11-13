class MovieTicket {
    private String seatNumber;
    String screenId;
    protected double ticketPrice;
    public String movieTitle;
}

public class Problem1_MovieTicketFieldVisibilityChecker {
    static String classifyAccess(String fieldModifier, String accessorContext) {
        if ("SAME_CLASS".equals(accessorContext)) return "ALLOWED";
        if ("SAME_PACKAGE".equals(accessorContext)) {
            return "private".equals(fieldModifier) ? "DENIED" : "ALLOWED";
        }
        if ("DIFFERENT_PACKAGE".equals(accessorContext)) {
            return "public".equals(fieldModifier) ? "ALLOWED" : "DENIED";
        }
        return "DENIED";
    }

    static String summarizeBatch(String[][] attempts) {
        int allowed = 0, denied = 0;
        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt == null || attempt.length < 2) continue;
                if ("ALLOWED".equals(classifyAccess(attempt[0], attempt[1]))) allowed++;
                else denied++;
            }
        }
        return "Allowed: " + allowed + " | Denied: " + denied;
    }

    public static void main(String[] args) {
        String[][] attempts = {
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));
        System.out.println(summarizeBatch(attempts)); // Allowed: 2 | Denied: 1
    }
}