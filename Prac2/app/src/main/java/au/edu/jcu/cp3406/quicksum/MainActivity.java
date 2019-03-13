package au.edu.jcu.cp3406.quicksum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private int sum;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sum = 0;
    }

    public void buttonClicked(View view)
    {
        Button button = (Button) view;

        int number = Integer.parseInt(button.getText().toString());
        sum += number;

        setDisplay(sum);
    }

    public void buttonClear(View view)
    {
        sum = 0;
        setDisplay(sum);
    }

    private void setDisplay(int num)
    {
        TextView textView = findViewById(R.id.sum);
        String result = "" + num;
        textView.setText(result);
    }
}
