package Models;

import java.util.Random;

public class Goalkeeper extends Player {
    public Goalkeeper(String name, int age, int force, int powerAtGoalKick, int motivation, int reaction) {
        super(name, age, force, powerAtGoalKick, motivation, 0);

        this.reaction = validate(reaction);
    }

    private int reaction;

    public boolean ballHold(int powerAtGoalKick) {
        var reaction = this.reaction + getReactionOffset();
        return reaction >= powerAtGoalKick;
    }

    public int getReactionOffset() {
        // -1 0 1
        var random = new Random();
        return random.nextInt(3) - 1;
    }

    @Override
    public String toString() {
        return "\nGoalkeeper\n" + "name: " + this.name + "\nage: " + this.age + "\nforce: " + this.force + "\npowerAtGoalKick: " + this.powerAtGoalKick + "\nmotivation: " + this.motivation + "\nnumberOfGoals: " + this.numberOfGoals + "\nreaction: " + this.reaction;
    }
}
