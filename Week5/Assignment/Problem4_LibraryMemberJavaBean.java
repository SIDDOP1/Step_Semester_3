import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class LibraryMemberBean {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswerHash;

    public LibraryMemberBean() { }

    public String getMembershipId() { return membershipId; }

    // The first non-null ID is write-once; later setter calls are ignored.
    public void setMembershipId(String id) {
        if (membershipId == null && id != null && !id.isEmpty()) membershipId = id;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isPremiumMember() { return premiumMember; }
    public void setPremiumMember(boolean premium) { this.premiumMember = premium; }

    // No getter is provided: the original answer cannot be retrieved.
    public void setSecurityAnswer(String answer) {
        if (answer == null) {
            securityAnswerHash = null;
            return;
        }
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = digest.digest(answer.getBytes(StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder();
            for (byte b : bytes) hex.append(String.format("%02x", b));
            securityAnswerHash = hex.toString();
        } catch (NoSuchAlgorithmException impossible) {
            throw new IllegalStateException("SHA-256 is unavailable", impossible);
        }
    }
}

public class Problem4_LibraryMemberJavaBean {
    public static void main(String[] args) {
        LibraryMemberBean member = new LibraryMemberBean();
        member.setMembershipId("LIB-8841");
        member.setName("Priya Nair");
        member.setPremiumMember(true);
        member.setMembershipId("FAKE-0000");
        member.setSecurityAnswer("BlueMountain");

        System.out.println(member.getMembershipId()); // LIB-8841
        System.out.println(member.getName());          // Priya Nair
        System.out.println(member.isPremiumMember());  // true
    }
}