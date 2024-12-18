package Models;

import lombok.Getter;

import java.util.Random;

public class Player extends Person {
    private final int MIN_NUMBER = 0;
    private final int MAX_NUMBER = 10;

    @Getter
    protected int force;
    protected int powerAtGoalKick;
    @Getter
    protected int motivation;
    @Getter
    protected int numberOfGoals;

    public Player(String name, int age, int force, int powerAtGoalKick, int motivation, int numberOfGoals) {
        super(name, age);

        this.force = validate(force);
        this.powerAtGoalKick = validate(powerAtGoalKick);
        this.motivation = validate(motivation);
        this.numberOfGoals = validate(numberOfGoals);
    }

    public int shootAtGoal() {
        var strengthOffset = getStrengthOffset();

        var strength = this.powerAtGoalKick + strengthOffset;

        return validate(strength);
    }

    protected int validate(int number) {
        if (number < MIN_NUMBER) {
            return MIN_NUMBER;
        } else return Math.min(number, MAX_NUMBER);
    }

    public void addGoal() {
        this.numberOfGoals++;
    }

    private int getStrengthOffset() {
        // -1 0 1 2
        var random = new Random();
        return random.nextInt(3) - 2;
    }


    @Override
    public String toString() {
        return "\nPlayer\n" + "name: "
                + this.name + "\nage: "
                + this.age + "\nforce: "
                + this.force + "\npowerAtGoalKick: "
                + this.powerAtGoalKick + "\nmotivation: "
                + this.motivation + "\nnumberOfGoals: "
                + this.numberOfGoals;
    }
}
