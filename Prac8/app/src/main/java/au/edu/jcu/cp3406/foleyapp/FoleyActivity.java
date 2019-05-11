package au.edu.jcu.cp3406.foleyapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class FoleyActivity extends AppCompatActivity
{
    private ImageView imageView;

    private SoundHandler soundHandler;

    private Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foley);

        Intent intent = getIntent();
        category = (Category) intent.getSerializableExtra("category");

        imageView = findViewById(R.id.image);

        soundHandler = new SoundHandler(getAssets(), "raw/", category);

        try
        {
            String fileName = category.toString().toLowerCase().concat(".jpg");
            InputStream stream = getAssets().open("img/" + fileName);
            Bitmap image = BitmapFactory.decodeStream(stream);
            imageView.setImageBitmap(image);
        }
        catch (IOException e)
        {
            System.out.println("File does not exist");
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);


        float x_percent = event.getX()/size.x;
        float y_percent = event.getY()/size.y;

        System.out.println(y_percent);

        switch (category)
        {
            case BALLOON:
                soundHandler.play(Sound.BALLOON_STRETCH);
                break;

            case COW:
                if(y_percent < 0.6)
                {
                    if(x_percent < 0.5)
                    {
                        soundHandler.play(Sound.COW_MOO);
                    }
                    else
                    {
                        soundHandler.play(Sound.COW_SPLAT);
                    }
                }
                else
                {
                    soundHandler.play(Sound.COW_HOOVES);
                }
                break;

            case OFFICE:
                if(y_percent < 0.6)
                {
                    if(x_percent < 0.5)
                    {
                        soundHandler.play(Sound.OFFICE_COPIER);
                    }
                    else
                    {
                        soundHandler.play(Sound.OFFICE_PUNCH);
                    }
                }
                else
                {
                    if(x_percent < 0.5)
                    {
                        soundHandler.play(Sound.OFFICE_STAPLER);
                    }
                    else
                    {
                        soundHandler.play(Sound.OFFICE_TYPEWRITER);
                    }
                }
                break;

            case WORK:
                if(y_percent < 0.6)
                {
                    if(x_percent < 0.5)
                    {
                        soundHandler.play(Sound.WORK_HAMMER);
                    }
                    else
                    {
                        soundHandler.play(Sound.WORK_HANDSAW);
                    }
                }
                else
                {
                    if(x_percent < 0.5)
                    {
                        soundHandler.play(Sound.WORK_SANDER);
                    }
                    else
                    {
                        soundHandler.play(Sound.WORK_TABLESAW);
                    }
                }
        }






        return true;
    }
}
