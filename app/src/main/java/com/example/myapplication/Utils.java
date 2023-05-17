package com.example.myapplication;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;

public class Utils {

    static GradientDrawable defaultNoteShape(){

        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(Color.parseColor("#526b7a"));
        shape.setAlpha(200);
        shape.setCornerRadius(15);

        shape.setStroke( 5, Color.parseColor("#32424e") );

        return shape;

    }

    static GradientDrawable selectedNoteShape(int culoare){

        GradientDrawable shape = new GradientDrawable();
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setColor(culoare);
        shape.setAlpha(200);
        shape.setCornerRadius(15);

        shape.setStroke( 5, Color.parseColor("#FF34444E") );

        return shape;

    }

    static LinearLayout.LayoutParams noteParams(){

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(4, 0, 4, 20);

        return params;

    }

    static LinearLayout.LayoutParams soundParams(){

        //setare margine
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        params.setMargins(10, 0, 10, 0);

        return params;

    }

}
