import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class MovieBookingProfile {
    private String name;
    private boolean confirmed;
    private String otpHash;

    public MovieBookingProfile() { }

    public MovieBookingProfile(String name) {
        this();
        setName(name);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isConfirmed() { return confirmed; }
    public void setConfirmed(boolean confirmed) { this.confirmed = confirmed; }

    // OTP is write-only; only a one-way hash is retained and no getter exists.
    public void setOtp(String otp) {
        if (otp == null || !otp.matches("\\d{4,6}")) return;
        try {
            byte[] hash = MessageDigest.getInstance("SHA-256")
                    .digest(otp.getBytes(StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) hex.append(String.format("%02x", b));
            otpHash = hex.toString();
        } catch (NoSuchAlgorithmException impossible) {
            throw new IllegalStateException("SHA-256 is unavailable", impossible);
        }
    }
}

public class Problem4_MovieBookingProfileJavaBean {
    public static void main(String[] args) {
        MovieBookingProfile profile = new MovieBookingProfile("Rahul Dev");
        profile.setConfirmed(true);
        profile.setOtp("4471");
        System.out.println(profile.getName());    // Rahul Dev
        System.out.println(profile.isConfirmed()); // true
    }
}