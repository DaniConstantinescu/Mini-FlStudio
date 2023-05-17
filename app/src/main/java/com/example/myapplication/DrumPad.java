package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.SoundPool;
import android.os.Bundle;
import android.widget.ImageButton;

import com.sanojpunchihewa.glowbutton.GlowButton;

import java.util.ArrayList;
import java.util.List;

public class DrumPad extends AppCompatActivity {

    ImageButton back;
    GlowButton gb1, gb2, gb3, gb4, gb5, gb6;

    SoundPool soundPool;
    List<Integer> soundPoolIDs;
    float floatSpeed = 1.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drum_pad);

        back = findViewById(R.id.backDrumPad);
        back.setOnClickListener(view -> finish());

        handleButtons();

    }

    private void handleButtons() {

        gb1 = findViewById(R.id.gb1);
        gb2 = findViewById(R.id.gb2);
        gb3 = findViewById(R.id.gb3);
        gb4 = findViewById(R.id.gb4);
        gb5 = findViewById(R.id.gb5);
        gb6 = findViewById(R.id.gb6);

        generateSoundPool();

        gb1.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(1),1, 1, 1, 0, floatSpeed));
        gb2.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(2),1, 1, 1, 0, floatSpeed));
        gb3.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(3),1, 1, 1, 0, floatSpeed));
        gb4.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(4),1, 1, 1, 0, floatSpeed));
        gb5.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(5),1, 1, 1, 0, floatSpeed));
        gb6.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(6),1, 1, 1, 0, floatSpeed));

    }

    private void generateSoundPool() {

        soundPoolIDs = new ArrayList<>();
        soundPoolIDs.add(0);

        SoundPool.Builder builder = new SoundPool.Builder();
        soundPool = builder.build();

        Integer auxID = 0;

        auxID = soundPool.load(this, R.raw.hh_closed, 1);
        soundPoolIDs.add(auxID);
        auxID = soundPool.load(this, R.raw.hh_open, 1);
        soundPoolIDs.add(auxID);
        auxID = soundPool.load(this, R.raw.hh_slush, 1);
        soundPoolIDs.add(auxID);
        auxID = soundPool.load(this, R.raw.kick, 1);
        soundPoolIDs.add(auxID);
        auxID = soundPool.load(this, R.raw.snare, 1);
        soundPoolIDs.add(auxID);
        auxID = soundPool.load(this, R.raw.snare_art, 1);
        soundPoolIDs.add(auxID);

    }
}