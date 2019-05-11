package au.edu.jcu.cp3406.foleyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    SoundHandler soundHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClicked(View view)
    {
        Button button = (Button) view;

        Category category = Category.valueOf(button.getText().toString().toUpperCase());

        Intent intent = new Intent(this, FoleyActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}
