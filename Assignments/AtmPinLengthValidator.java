public class AtmPinLengthValidator {
    public static void checkPinLength(String pin) {
        if (pin.length() != 4) System.out.println("Invalid PIN - must be exactly 4 digits.");
        else if (!pin.chars().allMatch(Character::isDigit)) System.out.println("Invalid PIN - must contain only digits.");
        else System.out.println("PIN length OK.");
    }
    public static void main(String[] args) { checkPinLength(args.length == 0 ? "4820" : args[0]); }
}
