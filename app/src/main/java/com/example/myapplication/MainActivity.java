package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button newBtn;
    ImageButton toPiano, toDrumPad;

    Map< LinearLayout ,Map<String, Sound> > beatLines = new HashMap();

    Sound selectedSound = new Sound();
    //lista de suntele luate din R.raw
    List<Sound> sounds = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getMediaPlayers();

        generateButtons();
        generateSounds();

        handlePlays();

        toPiano = findViewById(R.id.toPiano);
        toPiano.setOnClickListener(view -> {
            Intent intent = new Intent(this, Piano.class);
            startActivity(intent);
        });

        toDrumPad = findViewById(R.id.toDrumPad);
        toDrumPad.setOnClickListener(view -> {
            Intent intent = new Intent(this, DrumPad.class);
            startActivity(intent);
        });

    }


    public void handlePlays(){

        ImageButton play1 = (ImageButton) findViewById(R.id.play1);
        ImageButton play2 = (ImageButton) findViewById(R.id.play2);
        ImageButton play3 = (ImageButton) findViewById(R.id.play3);



        play1.setOnClickListener(view -> playBeat( (LinearLayout) findViewById(R.id.beatLine1) ));
        play2.setOnClickListener(view -> playBeat( (LinearLayout) findViewById(R.id.beatLine2) ));
        play3.setOnClickListener(view -> playBeat( (LinearLayout) findViewById(R.id.beatLine3) ));


    }
    private void playBeat(LinearLayout layout) {

        // incercare de luat nume/path file pt cele selectate
        /*
        List<String> files = new ArrayList<>();


        if( !beatLines.get(layout).values().isEmpty()){

            for (Sound s : beatLines.get(layout).values()) {
                files.add(s.path);
            }

        }
         */

        List<MediaPlayer> players = new ArrayList<>();

        //System.out.println( beatLines.get(layout).toString() );


        if( !beatLines.get(layout).values().isEmpty()){

            Integer mxx = Integer.parseInt( Collections.max(beatLines.get(layout).keySet()) );

            for (Integer i = 0; i <= mxx; i++) {

                if ( beatLines.get(layout).containsKey( i.toString() ) )
                    players.add( beatLines.get(layout).get( i.toString() ).player);
                else
                    players.add( MediaPlayer.create(this, getResources().getIdentifier("silence", "raw", getPackageName())) );


            }

        }

        if ( players.size() > 0 )
            playMediaPlayers(players, 0 );

    }

    private void playMediaPlayers(List<MediaPlayer> mediaPlayers, int index) {
        MediaPlayer mediaPlayer = mediaPlayers.get(index);
        mediaPlayer.setOnCompletionListener(mp -> {
            int nextIndex = index + 1;
            if (nextIndex < mediaPlayers.size()) {
                playMediaPlayers(mediaPlayers, nextIndex);
            }
        });
        mediaPlayer.start();
    }

    public void getMediaPlayers(){

        String[] indexcolors = new String[]{
                "#FFFF00", "#1CE6FF", "#FF34FF", "#FF4A46", "#008941", "#006FA6", "#A30059",
                "#FFDBE5", "#7A4900", "#0000A6", "#63FFAC", "#B79762", "#004D43", "#8FB0FF", "#997D87",
                "#5A0007", "#809693", "#FEFFE6", "#1B4400", "#4FC601", "#3B5DFF", "#4A3B53", "#FF2F80",
                "#61615A", "#BA0900", "#6B7900", "#00C2A0", "#FFAA92", "#FF90C9", "#B903AA", "#D16100",
                "#DDEFFF", "#000035", "#7B4F4B", "#A1C299", "#300018", "#0AA6D8", "#013349", "#00846F",
                "#372101", "#FFB500", "#C2FFED", "#A079BF", "#CC0744", "#C0B9B2", "#C2FF99", "#001E09",
                "#00489C", "#6F0062", "#0CBD66", "#EEC3FF", "#456D75", "#B77B68", "#7A87A1", "#788D66",
                "#885578", "#FAD09F", "#FF8A9A", "#D157A0", "#BEC459", "#456648", "#0086ED", "#886F4C",
                "#34362D", "#B4A8BD", "#00A6AA", "#452C2C", "#636375", "#A3C8C9", "#FF913F", "#938A81",
                "#575329", "#00FECF", "#B05B6F", "#8CD0FF", "#3B9700", "#04F757", "#C8A1A1", "#1E6E00",
                "#7900D7", "#A77500", "#6367A9", "#A05837", "#6B002C", "#772600", "#D790FF", "#9B9700",
                "#549E79", "#FFF69F", "#201625", "#72418F", "#BC23FF", "#99ADC0", "#3A2465", "#922329",
                "#5B4534", "#FDE8DC", "#404E55", "#0089A3", "#CB7E98", "#A4E804", "#324E72", "#6A3A4C"
        };


        Field[] fields=R.raw.class.getFields();
        for(int i=0; i < fields.length; i++){

            if ( !fields[i].getName().equals("silence") )
                sounds.add( new Sound( fields[i].getName() + ".wav", Color.parseColor(indexcolors[i]) ,MediaPlayer.create(this, getResources().getIdentifier(fields[i].getName(), "raw", getPackageName())) ));

        }

        /*  Incercare folosire SoundPool ( err = track of type 'audio/raw' does not publish bitrate)
        SoundPool soundPool;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(10)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        }

        int s1 = soundPool.load(this, R.raw.snare, 1);
        soundPool.play(s1, 1,1,0,0,1);

        */


    }
    public void addSoundButton(LinearLayout layout,int index){


        newBtn = new Button(this);
        newBtn.setText("s" + index);
        newBtn.setTag("s" + index);

        sounds.get(index).setName("s" + index);


        //setare inaltime si latime
        DisplayMetrics dm = getResources().getDisplayMetrics();
        float dpInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, dm);
        newBtn.setHeight((int) dpInPx);

        dpInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 170, dm);
        newBtn.setWidth((int) dpInPx);


        newBtn.setLayoutParams(Utils.soundParams());
        newBtn.setBackgroundDrawable(Utils.selectedNoteShape(sounds.get(index).color));

        newBtn.setTextColor(Color.DKGRAY);
        newBtn.setSoundEffectsEnabled(false);


        newBtn.setOnClickListener(view -> {

            sounds.get(index).play();
            selectedSound = sounds.get(index);


        });


        layout.addView(newBtn);

    }
    public void generateSounds(){

        LinearLayout layout = (LinearLayout) findViewById(R.id.soundsBar);
        for (int i = 0; i < sounds.size(); i++) {
            addSoundButton(layout, i);
        }

    }
    public void addBtn(LinearLayout layout, Integer counter){

        newBtn = new Button(this);
        newBtn.setText(counter.toString());
        newBtn.setTag(counter);

        //setare margini
        newBtn.setLayoutParams(Utils.noteParams());

        //setare inaltime si latime
        DisplayMetrics dm = getResources().getDisplayMetrics();
        float dpInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, dm);
        newBtn.setHeight((int) dpInPx);

        dpInPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 150, dm);
        newBtn.setWidth((int) dpInPx);


        newBtn.setBackgroundDrawable(Utils.defaultNoteShape());

        newBtn.setTextColor(Color.parseColor("#D8D8D8"));
        newBtn.setSoundEffectsEnabled(false);



        newBtn.setOnClickListener(view -> {

            Map<String, Sound> currentBeat = beatLines.get(layout);

            if (selectedSound.player != null){

                Button current = layout.findViewWithTag(view.getTag());

                if (currentBeat.containsKey( view.getTag().toString() )){

                    if ( currentBeat.get(view.getTag().toString()) == selectedSound ) {

                        currentBeat.remove(view.getTag().toString());

                        current.setTextColor(Color.parseColor("#D8D8D8"));
                        current.setText(view.getTag().toString());
                        current.setBackgroundDrawable(Utils.defaultNoteShape());

                    }else {

                        currentBeat.put(view.getTag().toString(), selectedSound);
                        selectedSound.play();

                        current.setTextColor(Color.DKGRAY);
                        current.setText(selectedSound.name);
                        current.setBackgroundDrawable(Utils.selectedNoteShape(selectedSound.color));

                    }

                }else {

                    currentBeat.put(view.getTag().toString(), selectedSound);
                    selectedSound.play();

                    current.setTextColor(Color.DKGRAY);
                    current.setText(selectedSound.name);
                    current.setBackgroundDrawable(Utils.selectedNoteShape(selectedSound.color));
                }

            }

            beatLines.put( layout, currentBeat );

            //System.out.println(currentBeat);

        });


        layout.addView(newBtn);

    }
    public void generateButtons(){

        LinearLayout layout = (LinearLayout) findViewById(R.id.beatLine1);
        beatLines.put( layout, new HashMap<>() );
        for (int i = 0; i < 50; i++) {
            addBtn(layout, i);
        }

        layout = (LinearLayout) findViewById(R.id.beatLine2);
        beatLines.put( layout, new HashMap<>() );
        for (int i = 0; i < 50; i++) {
            addBtn(layout, i);
        }

        layout = (LinearLayout) findViewById(R.id.beatLine3);
        beatLines.put( layout, new HashMap<>() );
        for (int i = 0; i < 50; i++) {
            addBtn(layout, i);
        }


    }

    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }


}