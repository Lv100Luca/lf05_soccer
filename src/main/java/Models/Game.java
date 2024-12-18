package Models;

import lombok.Getter;

public class Game {
    @Getter
    private Team home;
    @Getter
    private Team away;

    private int goalsHome;
    private int goalsAway;

    public Game(Team home, Team away) {
        this.home = home;
        this.away = away;

        this.goalsHome = 0;
        this.goalsAway = 0;
    }

    private void increaseGoalsHome() {
        this.goalsHome++;
    }

    private void increaseGoalsAway() {
        this.goalsAway++;
    }

    public void increaseGoals(Team team) {
        if (team == home) {
            increaseGoalsHome();
        } else {
            increaseGoalsAway();
        }
    }

    public void printScore() {
        System.out.printf("%s %s %s", home.getName(), this.getScore(), away.getName());
        System.out.println("\n");
    }

    @Override
    public String toString() {
        return home.getName() + " - " + away.getName();
    }

    public String getScore() {
        return goalsHome + " - " + goalsAway;
    }

    public Team getLeadingTeam() {
        if (goalsHome == goalsAway) {
            return null;
        }
        if (goalsHome > goalsAway) {
            return home;
        } else {
            return away;
        }
    }
}