package au.edu.jcu.cp3406.guessinggame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        game = new Game();
    }

    public void checkGuess(View view)
    {
        // Gain Access to the text input
        EditText text = findViewById(R.id.editText);

        // Parse Text input
        int guess = Integer.parseInt(text.getText().toString());

        //Input validation
        if(guess < 1 || guess > 10)
            Toast.makeText(getApplicationContext(), "Number must be 1-10. Try Again", Toast.LENGTH_LONG).show();
        else
        {
            // Visual Game Logic
            if (game.check(guess))
            {
                Toast.makeText(getApplicationContext(), "Correct!, Restarting...", Toast.LENGTH_LONG).show();

                game = new Game();
            }
            else
            {
                Toast.makeText(getApplicationContext(), "Incorrect. Try again...", Toast.LENGTH_LONG).show();
            }
        }
    }
}
