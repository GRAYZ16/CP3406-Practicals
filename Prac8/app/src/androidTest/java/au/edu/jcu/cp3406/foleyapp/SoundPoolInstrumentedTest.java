package au.edu.jcu.cp3406.foleyapp;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class SoundPoolInstrumentedTest
{
    @Test
    public void useAppContext()
    {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("au.edu.jcu.cp3406.foleyapp", appContext.getPackageName());
    }

    @Test
    public void soundTest()
    {
        SoundHandler soundHandler = new SoundHandler(InstrumentationRegistry.getTargetContext().getAssets(), "raw/");

        soundHandler.play(Sound.COW_MOO);
    }
}
