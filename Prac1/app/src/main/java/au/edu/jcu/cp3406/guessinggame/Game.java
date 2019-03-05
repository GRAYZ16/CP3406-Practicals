package au.edu.jcu.cp3406.guessinggame;

import java.util.Random;

public class Game
{
    private int secret_number;

    public Game()
    {
        Random random = new Random();

        secret_number = random.nextInt(10) + 1;
    }

    public boolean check(int guess)
    {
        return guess == secret_number;
    }
}
