import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static final String[] MOVES = {"Rock", "Paper", "Scissors"};
    public static String playRound(String player, String computer) {
        if (player.equalsIgnoreCase(computer)) return "Draw";
        boolean wins = (player.equalsIgnoreCase("Rock") && computer.equalsIgnoreCase("Scissors"))
                || (player.equalsIgnoreCase("Paper") && computer.equalsIgnoreCase("Rock"))
                || (player.equalsIgnoreCase("Scissors") && computer.equalsIgnoreCase("Paper"));
        return wins ? "Player Wins" : "Computer Wins";
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); Random random = new Random();
        String[] players = new String[5], computers = new String[5], results = new String[5];
        int wins = 0, losses = 0, draws = 0;
        for (int i = 0; i < players.length; i++) {
            System.out.print("Round " + (i + 1) + " - enter Rock, Paper, or Scissors: ");
            players[i] = in.nextLine().trim();
            while (!players[i].equalsIgnoreCase("Rock") && !players[i].equalsIgnoreCase("Paper") && !players[i].equalsIgnoreCase("Scissors")) {
                System.out.print("Invalid move. Try again: "); players[i] = in.nextLine().trim();
            }
            computers[i] = MOVES[random.nextInt(MOVES.length)]; results[i] = playRound(players[i], computers[i]);
            if (results[i].equals("Player Wins")) wins++; else if (results[i].equals("Computer Wins")) losses++; else draws++;
        }
        System.out.println("Round | Player | Computer | Result");
        for (int i = 0; i < players.length; i++) System.out.printf("%d | %s | %s | %s%n", i + 1, players[i], computers[i], results[i]);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, wins * 100.0 / players.length);
    }
}
