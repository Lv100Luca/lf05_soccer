package Models;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Gameplay {
    private static final int PLAYING_TIME = 90;
    private static final int MAX_ADDITIONAL_TIME = 5;
    private static final int MAX_DURATION_UNTIL_NEXT_ACTION = 15;

    private Game game;

    public Gameplay(Game game) {
        this.game = game;
    }

    public int calculateForceOfTheTeam(Team team) {
        // -3 -2 -1 0 1 2 3
        var random = new Random();
        var forceOffset = random.nextInt(4) - 1;

        return team.getTotalForce() * team.getTotalMotivation() * team.getCoach().getExperience() + forceOffset;
    }

    public void play() {
        // print matchup
        System.out.println(String.format("%s (%d) vs %s (%d)", this.game.getHome().getName(), calculateForceOfTheTeam(this.game.getHome()), this.game.getAway().getName(), calculateForceOfTheTeam(this.game.getAway())));

        Random random = new Random();
        var playimeOffset = random.nextInt(MAX_ADDITIONAL_TIME);
        var playingTime = PLAYING_TIME + playimeOffset;
        int currentMinute = 0;
        int actionScore = 0;

        while (currentMinute < playingTime) {
            playingTime = PLAYING_TIME + playimeOffset + (actionScore / 7);
            var team = this.getTeamForAction();
            Player player = team.getRandomPlayer();
            Goalkeeper goalkeeper = getOpponent(team).getGoalkeeper();

            var wasGoal = this.doGameAction(player, goalkeeper, currentMinute, team);

            if (wasGoal) {
                actionScore = 10;
            }
            actionScore++;

            var timeUntilNextAction = this.getTimeUntilNextAction();
            currentMinute += timeUntilNextAction;

            this.delay(timeUntilNextAction);
            System.out.println("-----------------------------------");
        }

        // print winner and score
        var winner = this.game.getLeadingTeam();

        if (winner == null) {
            System.out.println("It's a draw!");
            System.out.println(this.game.getScore());
            return;
        }

        System.out.println(this.game.getLeadingTeam().getName() + " wins the game after " + playingTime + " minutes!");
        System.out.println(this.game.getScore());

        System.out.println(this.game.getHome().getName());
        printScorers(this.game.getHome());

        System.out.println(this.game.getAway().getName());
        printScorers(this.game.getAway());
    }

    private void printScorers(Team team) {
        for (Player player : team.getPlayers()) {
            if (player.numberOfGoals > 0) {
                System.out.println(String.format("%s (%d)", player.getName(), player.getNumberOfGoals()));
            }
        }
    }

    private int getTimeUntilNextAction() {
        var random = new Random();
        return random.nextInt(1, MAX_DURATION_UNTIL_NEXT_ACTION);
    }

    private Team getTeamForAction() {
        var random = new Random();
        var homeForce = this.calculateForceOfTheTeam(this.game.getHome());
        var awayForce = this.calculateForceOfTheTeam(this.game.getAway());

        int totalForce = homeForce + awayForce;

        var randomNumber = random.nextInt(totalForce);

        if (randomNumber > homeForce)
            return this.game.getAway();

        return this.game.getHome();
    }

    private boolean doGameAction(Player player, Goalkeeper goalkeeper, int minute, Team team) {
        System.out.println(printMinutes(minute));
        System.out.printf("Chance for %s ...", team.getName());
        System.out.println();
        System.out.printf("%s shoots", player.getName());
        System.out.println();

        var powerAtGoalKick = player.shootAtGoal();

        var ballHold = goalkeeper.ballHold(powerAtGoalKick);

        if (ballHold) {
            System.out.printf(" and %s holds the ball", goalkeeper.getName());
            System.out.println();
            return false;
        }
        player.addGoal();
        game.increaseGoals(team);
        System.out.printf("GOAL!!!    %s %s(%d)", this.game.getScore(), player.getName(), player.getNumberOfGoals());
        System.out.println();
        return true;

    }

    private String printMinutes(int minutes) {
        if (minutes <= PLAYING_TIME)
            return String.format("%d. minute: ", minutes);

        return String.format("%d (+%d). minute: ", PLAYING_TIME, minutes - PLAYING_TIME);

    }

    private Team getOpponent(Team team) {
        if (team == this.game.getHome()) {
            return this.game.getAway();
        } else {
            return this.game.getHome();
        }
    }

    private void delay(int timeTillNextAction) {
        Random random = new Random();

        try {
            TimeUnit.SECONDS.sleep(1 + (timeTillNextAction / 5));
        } catch (InterruptedException e) {
            // do nothing
        }
    }
}
