package com.example.soundboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.view.View;

public class SoundBoardActivity extends AppCompatActivity implements View.OnClickListener {


    private Button buttonA, ButtonB, ButtonBfl, ButtonC, ButtonCsh, ButtonD, ButtonDsh, ButtonE, ButtonF, ButtonFSh, ButtonG, ButtonGsh, ButtonchangeOctave;
    private Button buttonScale1, buttonScale2;
    private boolean octave;
    private SoundPool soundPool;
    private int soundID;
    boolean loaded = false;
    private int[] sounds1,sounds2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_board);
        wireWidgets();
        setListeners();
        createSounds();
        createSoundList();

        // Set the hardware buttons to control the music


        }
    public void wireWidgets()
    {
        buttonA = findViewById(R.id.button_main_a);
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
        buttonScale2 = findViewById(R.id.button_main_scale2);


    }

public void setListeners()
{
    ButtonchangeOctave.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            octave = !octave;

        }
    });

    buttonA.setOnClickListener(this);
    ButtonB.setOnClickListener(this);
    ButtonBfl.setOnClickListener(this);
    ButtonC.setOnClickListener(this);
    ButtonCsh.setOnClickListener(this);
    ButtonD.setOnClickListener(this);
    ButtonDsh.setOnClickListener(this);
    ButtonE.setOnClickListener(this);
    ButtonF.setOnClickListener(this);
    ButtonFSh.setOnClickListener(this);
    ButtonG.setOnClickListener(this);
    ButtonGsh.setOnClickListener(this);

}

private void delay(int millisDelay)
{
    try {
        Thread.sleep(millisDelay);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

    public void createSounds() {
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
    }

    public void createSoundList()
    {
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
    }
    @Override
    public void onClick(View view) {
        if (!octave) {
        switch (view.getId()) {

                case R.id.button_main_a: {
                    soundPool.play(sounds1[0], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_B: {
                    soundPool.play(sounds1[1], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_Bfl: {
                    soundPool.play(sounds1[2], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_C: {
                    soundPool.play(sounds1[3], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_Csh: {
                    soundPool.play(sounds1[4], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_D: {
                    soundPool.play(sounds1[5], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_Dsh: {
                    soundPool.play(sounds1[6], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_e: {
                    soundPool.play(sounds1[7], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_F: {
                    soundPool.play(sounds1[8], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_Fsh: {
                    soundPool.play(sounds1[9], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_g: {
                    soundPool.play(sounds1[10], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_Gsh: {
                    soundPool.play(sounds1[11], 1, 1, 1, 0, 1f);
                    break;
                }
            }
        }
        else
        {
            switch (view.getId()) {

                case R.id.button_main_a: {
                    soundPool.play(sounds2[0], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_B: {
                    soundPool.play(sounds2[1], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_Bfl: {
                    soundPool.play(sounds2[2], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_C: {
                    soundPool.play(sounds2[3], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_Csh: {
                    soundPool.play(sounds2[4], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_D: {
                    soundPool.play(sounds2[5], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_Dsh: {
                    soundPool.play(sounds2[6], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_e: {
                    soundPool.play(sounds2[7], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_F: {
                    soundPool.play(sounds2[8], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_Fsh: {
                    soundPool.play(sounds2[9], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_g: {
                    soundPool.play(sounds2[10], 1, 1, 1, 0, 1f);
                    break;
                }
                case R.id.button_main_Gsh: {
                    soundPool.play(sounds2[11], 1, 1, 1, 0, 1f);
                    break;
                }
            }
        }
    }
}
