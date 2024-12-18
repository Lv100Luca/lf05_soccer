package Models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Random;

public class Team {
    @Getter
    private String name;
    @Getter
    private Coach coach;
    @Getter
    private Goalkeeper goalkeeper;
    @Getter
    private ArrayList<Player> players = new ArrayList<>();

    public Team(String name, Coach coach, Goalkeeper goalkeeper) {
        this.name = name;
        this.coach = coach;
        this.goalkeeper = goalkeeper;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public Player getRandomPlayer() {
        var random = new Random();
        return this.players.get(random.nextInt(this.players.size()));
    }

    public int getTotalMotivation() {
        var totalMotivation = 0;
        for (var player : this.players) {
            totalMotivation += player.getMotivation();
        }

        totalMotivation += this.goalkeeper.getMotivation();

        return totalMotivation / (this.players.size() + 1);
    }

    public int getTotalForce() {
        var totalForce = 0;
        for (var player : this.players) {
            totalForce += player.getForce();
        }

        return totalForce / this.players.size();
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        sb.append("\nTeam\n");
        sb.append("name: ").append(this.name).append("\n");
        sb.append("coach: ").append(this.coach.name).append("\n");

        for (var player : this.players) {
            sb.append("player: ").append(player.name).append("\n");
        }

        return sb.toString();
    }
}
