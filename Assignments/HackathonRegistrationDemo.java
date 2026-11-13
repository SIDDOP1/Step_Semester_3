public class HackathonRegistrationDemo {
    static class Participant {
        String name, teamName; boolean registered;
        Participant(String name, String teamName) { this.name = name; this.teamName = teamName; this.registered = true; }
        Participant(String name) { this(name, "Unassigned"); }
        void printStatus() { System.out.printf("%s | %s | Registered: %s%n", name, teamName, registered); }
    }
    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya"};
        String[] teams = {"ByteBusters", "", "CodeCrafters", ""};
        for (int i = 0; i < names.length; i++) { Participant p = teams[i].isEmpty() ? new Participant(names[i]) : new Participant(names[i], teams[i]); p.printStatus(); }
    }
}
