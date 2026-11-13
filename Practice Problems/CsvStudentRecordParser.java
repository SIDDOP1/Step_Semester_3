public class CsvStudentRecordParser {
    public static void parseStudentRecord(String csvLine) {
        String[] f = csvLine.split(",", -1);
        if (f.length != 3) System.out.println("Invalid Record");
        else System.out.printf("Name: %s | Roll No: %s | Dept: %s%n", f[0].trim(), f[1].trim(), f[2].trim());
    }
    public static void main(String[] args) { parseStudentRecord(args.length == 0 ? "Ananya Verma,RA2211003010123,CSE" : String.join(" ", args)); }
}
