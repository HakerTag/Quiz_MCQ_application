package com.example.sharmas.managementmcq;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

/**
 * Created by Sharma's on 29-Dec-17.
 */

public class startingPoint extends AppCompatActivity {

    GridLayout mainGrid;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                            //Change background color
                            cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                            Toast.makeText(startingPoint.this, "State : True", Toast.LENGTH_SHORT).show();

                        } else {
                            //Change background color
                            cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                            Toast.makeText(startingPoint.this, "State : False", Toast.LENGTH_SHORT).show();
                        }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(finalI==0) {
                        Intent intent = new Intent(startingPoint.this, ChapterList.class);
                        startActivity(intent);
                    }else if (finalI==1){
                        Intent intent = new Intent(startingPoint.this, ChapterPList.class);
                        startActivity(intent);
                    } else if (finalI==2){
                        Intent intent = new Intent(startingPoint.this, About.class);
                        startActivity(intent);
                    }

                }
            });
        }
    }
}

