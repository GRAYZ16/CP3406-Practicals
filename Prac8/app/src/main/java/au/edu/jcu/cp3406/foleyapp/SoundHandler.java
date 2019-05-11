package au.edu.jcu.cp3406.foleyapp;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;

import java.io.IOException;
import java.util.ArrayList;

class SoundHandler
{
    private SoundPool soundPool;
    private boolean loadedOkay;


    private int sounds[];

    SoundHandler(AssetManager assetManager, String assetPath)
    {
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener((soundPool, sampleID, status) -> {
            loadedOkay = status == 0;
        });

        sounds = new int[Sound.values().length];

        for (Sound sound : Sound.values())
        {
            String fileName = sound.toString().toLowerCase().concat(".mp3");

            try
            {
                AssetFileDescriptor assetFileDescriptor = assetManager.openFd(assetPath + fileName);
                sounds[sound.ordinal()] = soundPool.load(assetFileDescriptor, 0);
            }
            catch (IOException e)
            {
                System.out.println(String.format("Incorrect Path or Asset %s Does not Exist", fileName));
                e.printStackTrace();
            }
        }
    }

    SoundHandler(AssetManager assetManager, String assetPath, Category category)
    {
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener((soundPool, sampleID, status) -> {
            loadedOkay = status == 0;
        });

        ArrayList<Sound> categorySounds = new ArrayList<>();

        switch (category)
        {
            case BALLOON:
                categorySounds.add(Sound.BALLOON_STRETCH);
                break;
            case COW:
                categorySounds.add(Sound.COW_MOO);
                categorySounds.add(Sound.COW_HOOVES);
                categorySounds.add(Sound.COW_SPLAT);
                break;
            case OFFICE:
                categorySounds.add(Sound.OFFICE_COPIER);
                categorySounds.add(Sound.OFFICE_PUNCH);
                categorySounds.add(Sound.OFFICE_STAPLER);
                categorySounds.add(Sound.OFFICE_TYPEWRITER);
                break;
            case WORK:
                categorySounds.add(Sound.WORK_HAMMER);
                categorySounds.add(Sound.WORK_HANDSAW);
                categorySounds.add(Sound.WORK_SANDER);
                categorySounds.add(Sound.WORK_TABLESAW);
                break;
        }

        sounds = new int[Sound.values().length];

        for (Sound sound : categorySounds)
        {
            String fileName = sound.toString().toLowerCase().concat(".mp3");

            try
            {
                AssetFileDescriptor assetFileDescriptor = assetManager.openFd(assetPath + fileName);
                sounds[sound.ordinal()] = soundPool.load(assetFileDescriptor, 0);
            }
            catch (IOException e)
            {
                System.out.println(String.format("Incorrect Path or Asset %s Does not Exist", fileName));
                e.printStackTrace();
            }
        }
    }

    void play(Sound sound)
    {
        if(!loadedOkay) return;

        soundPool.play(sounds[sound.ordinal()], 1, 1, 1, 0, 1);
    }

}
