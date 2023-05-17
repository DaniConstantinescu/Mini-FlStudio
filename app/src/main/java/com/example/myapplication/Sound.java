package com.example.myapplication;

import android.media.MediaPlayer;

public class Sound {

    String path;
    String name;
    int color;
    MediaPlayer player;

    public Sound(){}
    /*
    public Sound(int color, MediaPlayer player) {
        this.color = color;
        this.player = player;
    }
     */

    public Sound(String path, int color, MediaPlayer player) {
        this.path = path;
        this.color = color;
        this.player = player;
    }

    public void play(){

        player.start();

    }

    public void setName(String name) {
        this.name = name;
    }
}
