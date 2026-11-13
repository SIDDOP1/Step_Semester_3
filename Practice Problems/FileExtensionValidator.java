public class FileExtensionValidator {
    public static String validateFileExtension(String filename) {
        int dot = filename.lastIndexOf('.');
        if (dot < 0 || dot == filename.length() - 1) return "Rejected - invalid file type";
        String ext = filename.substring(dot + 1);
        return ext.equalsIgnoreCase("pdf") || ext.equalsIgnoreCase("docx") || ext.equalsIgnoreCase("zip")
                ? "Accepted" : "Rejected - invalid file type";
    }
    public static void main(String[] args) { System.out.println(validateFileExtension(args.length == 0 ? "Assignment1.PDF" : args[0])); }
}
