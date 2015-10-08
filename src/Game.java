public class Game {
    private int score = 0;
    private int allRolls[] = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        allRolls[currentRoll++] = pins;
    }

    public int score() {
        int roll = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(roll)) {
                score += 10 + strikeBonus(roll);
                roll++;
            } else if (isSpare(roll)) {
                score += 10 + spareBonus(roll);
                roll += 2;
            } else {
                score += sumBallsInFrame(roll);
                roll += 2;
            }
        }
        return score;
    }

    private int sumBallsInFrame(int roll) {
        return allRolls[roll] + allRolls[roll + 1];
    }

    private int strikeBonus(int roll) {
        return allRolls[roll + 1] + allRolls[roll + 2];
    }

    private int spareBonus(int roll) {
        return allRolls[roll + 2];
    }

    private boolean isSpare(int roll) {
        return allRolls[roll] + allRolls[roll + 1] == 10;
    }

    private boolean isStrike(int roll) {
        return allRolls[roll] == 10;
    }
}
