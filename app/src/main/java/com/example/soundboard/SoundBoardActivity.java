package com.example.soundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.view.View;

import java.util.HashMap;
import java.util.Map;

public class SoundBoardActivity extends AppCompatActivity implements View.OnClickListener {


    private Button ButtonA, ButtonB, ButtonBfl, ButtonC, ButtonCsh, ButtonD, ButtonDsh, ButtonE, ButtonF, ButtonFSh, ButtonG, ButtonGsh, ButtonchangeOctave;
    private Button buttonScale1, buttonSong1;
    public boolean octave, mode;
    private SoundPool soundPool;
    private int soundID;
    boolean loaded = false;
    private int[] sounds1, sounds2, record;
    private Map<Integer, Integer> noteMap, noteMap2;
    private int counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_board);
        wireWidgets();
        setListeners();
        createSoundList();
        createSounds();


        // Set the hardware buttons to control the music


    }

    public void wireWidgets() {
        ButtonA = findViewById(R.id.button_main_a);
        ButtonB = findViewById(R.id.button_main_B);
        ButtonBfl = findViewById(R.id.button_main_Bfl);
        ButtonC = findViewById(R.id.button_main_C);
        ButtonCsh = findViewById(R.id.button_main_Csh);
        ButtonD = findViewById(R.id.button_main_D);
        ButtonDsh = findViewById(R.id.button_main_Dsh);
        ButtonE = findViewById(R.id.button_main_e);
        ButtonF = findViewById(R.id.button_main_F);
        ButtonFSh = findViewById(R.id.button_main_Fsh);
        ButtonG = findViewById(R.id.button_main_g);
        ButtonGsh = findViewById(R.id.button_main_Gsh);
        ButtonchangeOctave = findViewById(R.id.button_main_changeOctave);
        buttonScale1 = findViewById(R.id.button_main_scale1);
        buttonSong1 = findViewById(R.id.button_main_scale2);


    }

    public void setListeners() {
        ButtonchangeOctave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                octave = !octave;

            }
        });

        buttonScale1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playScale1();
            }
        });
        buttonSong1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playArray(record);
            }
        });

        KeyBoardListener keyBoardLister = new KeyBoardListener();
        ButtonA.setOnClickListener(keyBoardLister);
        ButtonB.setOnClickListener(keyBoardLister);
        ButtonBfl.setOnClickListener(keyBoardLister);
        ButtonC.setOnClickListener(keyBoardLister);
        ButtonCsh.setOnClickListener(keyBoardLister);
        ButtonD.setOnClickListener(keyBoardLister);
        ButtonDsh.setOnClickListener(keyBoardLister);
        ButtonE.setOnClickListener(keyBoardLister);
        ButtonF.setOnClickListener(keyBoardLister);
        ButtonFSh.setOnClickListener(keyBoardLister);
        ButtonG.setOnClickListener(keyBoardLister);
        ButtonGsh.setOnClickListener(keyBoardLister);

    }

    private void delay(int millisDelay) {
        try {
            Thread.sleep(millisDelay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void createSounds() {


        noteMap = new HashMap<>();
        noteMap.put(ButtonA.getId(), sounds1[0]);
        noteMap.put(ButtonB.getId(), sounds1[1]);
        noteMap.put(ButtonBfl.getId(), sounds1[2]);
        noteMap.put(ButtonC.getId(), sounds1[3]);
        noteMap.put(ButtonCsh.getId(), sounds1[4]);
        noteMap.put(ButtonD.getId(), sounds1[5]);
        noteMap.put(ButtonDsh.getId(), sounds1[6]);
        noteMap.put(ButtonE.getId(), sounds1[7]);
        noteMap.put(ButtonF.getId(), sounds1[8]);
        noteMap.put(ButtonFSh.getId(), sounds1[9]);
        noteMap.put(ButtonG.getId(), sounds1[10]);
        noteMap.put(ButtonGsh.getId(), sounds1[11]);
        noteMap2 = new HashMap<>();
        noteMap2.put(ButtonA.getId(), sounds2[0]);
        noteMap2.put(ButtonB.getId(), sounds2[1]);
        noteMap2.put(ButtonBfl.getId(), sounds2[2]);
        noteMap2.put(ButtonC.getId(), sounds2[3]);
        noteMap2.put(ButtonCsh.getId(), sounds2[4]);
        noteMap2.put(ButtonD.getId(), sounds2[5]);
        noteMap2.put(ButtonDsh.getId(), sounds2[6]);
        noteMap2.put(ButtonE.getId(), sounds2[7]);
        noteMap2.put(ButtonF.getId(), sounds2[8]);
        noteMap2.put(ButtonFSh.getId(), sounds2[9]);
        noteMap2.put(ButtonG.getId(), sounds2[10]);
        noteMap2.put(ButtonGsh.getId(), sounds2[11]);

    }

    public void createSoundList() {
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        // Load the sound
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {
                loaded = true;
            }
        });
        sounds1 = new int[12];
        sounds1[0] = soundPool.load(this, R.raw.scalea, 1);
        sounds1[1] = soundPool.load(this, R.raw.scaleb, 1);
        sounds1[2] = soundPool.load(this, R.raw.scalebb, 1);
        sounds1[3] = soundPool.load(this, R.raw.scalec, 1);
        sounds1[4] = soundPool.load(this, R.raw.scalecs, 1);
        sounds1[5] = soundPool.load(this, R.raw.scaled, 1);
        sounds1[6] = soundPool.load(this, R.raw.scaleds, 1);
        sounds1[7] = soundPool.load(this, R.raw.scalee, 1);
        sounds1[8] = soundPool.load(this, R.raw.scalef, 1);
        sounds1[9] = soundPool.load(this, R.raw.scalefs, 1);
        sounds1[10] = soundPool.load(this, R.raw.scaleg, 1);
        sounds1[11] = soundPool.load(this, R.raw.scalegs, 1);

        sounds2 = new int[12];
        sounds2[0] = soundPool.load(this, R.raw.scalehigha, 1);
        sounds2[1] = soundPool.load(this, R.raw.scalehighb, 1);
        sounds2[2] = soundPool.load(this, R.raw.scalehighbb, 1);
        sounds2[3] = soundPool.load(this, R.raw.scalehighc, 1);
        sounds2[4] = soundPool.load(this, R.raw.scalehighcs, 1);
        sounds2[5] = soundPool.load(this, R.raw.scalehighd, 1);
        sounds2[6] = soundPool.load(this, R.raw.scalehighds, 1);
        sounds2[7] = soundPool.load(this, R.raw.scalehighe, 1);
        sounds2[8] = soundPool.load(this, R.raw.scalehighf, 1);
        sounds2[9] = soundPool.load(this, R.raw.scalehighfs, 1);
        sounds2[10] = soundPool.load(this, R.raw.scalehighg, 1);
        sounds2[11] = soundPool.load(this, R.raw.scalehighgs, 1);

        record = new int[10000];
    }

    public void playNote(int arrayNum,int note)
    {
        if (arrayNum == 1) {
            soundPool.play(sounds1[note], 1, 1, 1, 0, 1f);
        }
        else
        {
            soundPool.play(sounds2[note], 1, 1, 1, 0, 1f);
        }
    }
    public void playScale1()
    {
        playNote(1,3);
        delay(500);
        playNote(1,5);
        delay(500);
        playNote(1,7);
        delay(500);
        playNote(1,8);
        delay(500);
        playNote(1,10);
        delay(500);
        playNote(2,0);
        delay(500);
        playNote(2,1);
        delay(500);
        playNote(2,3);
    }

    public void playArray(int[] array)
    {
        for (int x = 0; x < counter; x++)
        {
            soundPool.play(array[x], 1, 1, 1, 0, 1f);
            delay(500);
        }
    }

    @Override
    public void onClick(View view) {
    }

    private class KeyBoardListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {


            if (!octave) {
                int songId = noteMap.get(view.getId());
                if (songId != 0) {
                    soundPool.play(songId, 1, 1, 1, 0, 1f);
                    if (mode == false)
                    {
                        record[counter] = songId;
                        counter++;
                    }
                }
            } else {
                int songId2 = noteMap2.get(view.getId());
                if (songId2 != 0) {
                    soundPool.play(songId2, 1, 1, 1, 0, 1f);
                    if (mode == false)
                    {
                        record[counter] = songId2;
                        counter++;
                    }
                }
            }


        }
    }
}
