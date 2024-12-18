import Models.*;

public class Main {
    public static void main(String[] args) {
//        testCoach();
//        System.out.println("=================");
//        testPlayer();
//        System.out.println("=================");
//        testGoalkeeper();
//        System.out.println("=================");
//        testShootAtGoal();
//        System.out.println("=================");
//        testTeamExample();
//        testGame();
        gaming();
    }

    private static void testCoach() {
        var coach = new Coach("Diego", 30, 10);

        System.out.println(coach);
    }

    private static void testPlayer() {
        var player = new Player("Messi", 30, 10, 9, 5, 0);

        System.out.println(player);
    }

    private static void testGoalkeeper() {
        var goalkeeper = new Goalkeeper("Neuer", 30, 10, 5, 5, 9);

        System.out.println(goalkeeper);
    }

    private static void testShootAtGoal() {
        var player = new Player("Messi", 30, 10, 9, 5, 0);
        var goalkeeper = new Goalkeeper("Neuer", 30, 10, 5, 5, 9);

        var shotAtGoal = player.shootAtGoal();

        System.out.println("Power: " + shotAtGoal);
        System.out.println("Defense: " + goalkeeper.ballHold(shotAtGoal));
    }

    private static void testTeamExample() {
        Coach coach = new Coach("Terzic", 38, 5);
        Goalkeeper goalkeeper = new Goalkeeper("Bürki", 30, 7, 2, 10, 7);
        Team dortmund = new Team("Borussia Dortmund", coach, goalkeeper);
        dortmund.addPlayer(new Player("Meunier", 29, 7, 5, 8, 0));
        dortmund.addPlayer(new Player("Akanji", 25, 8, 6, 8, 0));
        dortmund.addPlayer(new Player("Hummels", 31, 9, 5, 8, 0));
        dortmund.addPlayer(new Player("Guerreiro", 26, 8, 9, 8, 0));
        dortmund.addPlayer(new Player("Witsel", 31, 9, 6, 8, 0));
        dortmund.addPlayer(new Player("Brandt", 24, 9, 8, 8, 0));
        dortmund.addPlayer(new Player("Sancho", 20, 10, 8, 8, 0));
        dortmund.addPlayer(new Player("Bellingham", 17, 7, 7, 7, 0));
        dortmund.addPlayer(new Player("Reus", 31, 10, 8, 8, 0));
        dortmund.addPlayer(new Player("Haaland", 20, 9, 9, 8, 0));
        System.out.println(dortmund.toString());
        System.out.println("Mannschaftsstärke: " + dortmund.getTotalForce());
        System.out.println("Motivation: " + dortmund.getTotalMotivation());
    }

    private static Team createDortmund() {
        Coach coach = new Coach("Terzic", 38, 5);
        Goalkeeper goalkeeper = new Goalkeeper("Bürki", 30, 7, 2, 10, 7);
        Team dortmund = new Team("Borussia Dortmund", coach, goalkeeper);

        dortmund.addPlayer(new Player("Meunier", 29, 7, 5, 8, 0));
        dortmund.addPlayer(new Player("Akanji", 25, 8, 6, 8, 0));
        dortmund.addPlayer(new Player("Hummels", 31, 9, 5, 8, 0));
        dortmund.addPlayer(new Player("Guerreiro", 26, 8, 9, 8, 0));
        dortmund.addPlayer(new Player("Witsel", 31, 9, 6, 8, 0));
        dortmund.addPlayer(new Player("Brandt", 24, 9, 8, 8, 0));
        dortmund.addPlayer(new Player("Sancho", 20, 10, 8, 8, 0));
        dortmund.addPlayer(new Player("Bellingham", 17, 7, 7, 7, 0));
        dortmund.addPlayer(new Player("Reus", 31, 10, 8, 8, 0));
        dortmund.addPlayer(new Player("Haaland", 20, 9, 9, 8, 0));

        return dortmund;
    }

    private static Team createWerder() {
        Coach coach = new Coach("Kohfeld", 38, 9);
        Goalkeeper goalkeeper = new Goalkeeper("Pavlenka", 28, 6, 2, 10, 6);
        Team werder = new Team("Werder Bremen", coach, goalkeeper);

        werder.addPlayer(new Player("Gebre Selassie", 34, 7, 6, 8, 0));
        werder.addPlayer(new Player("Friedl", 22, 6, 6, 8, 0));
        werder.addPlayer(new Player("Veljkoviv", 24, 6, 5, 8, 0));
        werder.addPlayer(new Player("Augustinsson", 26, 7, 5, 7, 0));
        werder.addPlayer(new Player("Mbom", 20, 6, 6, 8, 0));
        werder.addPlayer(new Player("Eggestein", 24, 8, 6, 8, 0));
        werder.addPlayer(new Player("Füllkrug", 27, 8, 9, 8, 0));
        werder.addPlayer(new Player("Osako", 30, 7, 8, 8, 0));
        werder.addPlayer(new Player("Rashica", 24, 8, 8, 8, 0));
        werder.addPlayer(new Player("Bittencourt", 27, 7, 7, 8, 0));

        return werder;
    }

//    private static void testGame() {
//        Game game = new Game(createDortmund(), createWerder());
//
//        game.increaseGoalsHome();
//        game.increaseGoalsAway();
//        game.increaseGoalsHome();
//        game.increaseGoalsAway();
//    }

    private static void gaming() {
        var teamA = createDortmund();
        var teamB = createWerder();

        Game game = new Game(teamA, teamB);
        Gameplay gameplay = new Gameplay(game);
        gameplay.play();
    }
}
