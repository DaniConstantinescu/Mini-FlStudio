package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.SoundPool;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class Piano extends AppCompatActivity {

    SoundPool soundPool;
    List<Integer> soundPoolIDs;
    float floatSpeed = 1.0f;
    ImageButton back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano);

        generateSoundPool();
        handleButtons();

        back = findViewById(R.id.backPiano);
        back.setOnClickListener(view -> finish());

    }

    private void handleButtons() {

        Button key1, key2, key3, key4, key5, key6, key7, key8, key9, key10, key11, key12, key13, key14, key15, key16, key17, key18, key19, key20, key21, key22, key23, key24;

        key1 = findViewById(R.id.key1);
        key2 = findViewById(R.id.key2);
        key3 = findViewById(R.id.key3);
        key4 = findViewById(R.id.key4);
        key5 = findViewById(R.id.key5);
        key6 = findViewById(R.id.key6);
        key7 = findViewById(R.id.key7);
        key8 = findViewById(R.id.key8);
        key9 = findViewById(R.id.key9);
        key10 = findViewById(R.id.key10);
        key11 = findViewById(R.id.key11);
        key12 = findViewById(R.id.key12);
        key13 = findViewById(R.id.key13);
        key14 = findViewById(R.id.key14);
        key15 = findViewById(R.id.key15);
        key16 = findViewById(R.id.key16);
        key17 = findViewById(R.id.key17);
        key18 = findViewById(R.id.key18);
        key19 = findViewById(R.id.key19);
        key20 = findViewById(R.id.key20);
        key21 = findViewById(R.id.key21);
        key22 = findViewById(R.id.key22);
        key23 = findViewById(R.id.key23);
        key24 = findViewById(R.id.key24);

        key1.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(1), 1, 1, 1, 0, floatSpeed));
        key2.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(2), 1, 1, 1, 0, floatSpeed));
        key3.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(3), 1, 1, 1, 0, floatSpeed));
        key4.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(4), 1, 1, 1, 0, floatSpeed));
        key5.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(5), 1, 1, 1, 0, floatSpeed));
        key6.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(6), 1, 1, 1, 0, floatSpeed));
        key7.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(7), 1, 1, 1, 0, floatSpeed));
        key8.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(8), 1, 1, 1, 0, floatSpeed));
        key9.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(9), 1, 1, 1, 0, floatSpeed));
        key10.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(10), 1, 1, 1, 0, floatSpeed));
        key11.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(11), 1, 1, 1, 0, floatSpeed));
        key12.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(12), 1, 1, 1, 0, floatSpeed));
        key13.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(13), 1, 1, 1, 0, floatSpeed));
        key14.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(14), 1, 1, 1, 0, floatSpeed));
        key15.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(15), 1, 1, 1, 0, floatSpeed));
        key16.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(16), 1, 1, 1, 0, floatSpeed));
        key17.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(17), 1, 1, 1, 0, floatSpeed));
        key18.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(18), 1, 1, 1, 0, floatSpeed));
        key19.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(19), 1, 1, 1, 0, floatSpeed));
        key20.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(20), 1, 1, 1, 0, floatSpeed));
        key21.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(21), 1, 1, 1, 0, floatSpeed));
        key22.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(22), 1, 1, 1, 0, floatSpeed));
        key23.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(23), 1, 1, 1, 0, floatSpeed));
        key24.setOnClickListener(view -> soundPool.play(soundPoolIDs.get(24), 1, 1, 1, 0, floatSpeed));


    }


    private void generateSoundPool() {

        soundPoolIDs = new ArrayList<>();
        soundPoolIDs.add(0);

        SoundPool.Builder builder = new SoundPool.Builder();
        soundPool = builder.build();

        Integer auxID = 0;

        auxID = soundPool.load(this, R.raw.xkey01, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey02, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey03, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey04, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey05, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey06, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey07, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey08, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey09, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey10, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey11, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey12, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey13, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey14, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey15, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey16, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey17, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey18, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey19, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey20, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey21, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey22, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey23, 1);
        soundPoolIDs.add(auxID);

        auxID = soundPool.load(this, R.raw.xkey24, 1);
        soundPoolIDs.add(auxID);

    }
}