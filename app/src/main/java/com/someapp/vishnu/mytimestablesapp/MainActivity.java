package com.someapp.vishnu.mytimestablesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    ListView timesView;

    ArrayList<String> timesList;

    ArrayAdapter<String> timesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timesView = findViewById(R.id.timeListView);

        timesList = new ArrayList<String>();

        SeekBar numberControl = findViewById(R.id.seekBar);

        numberControl.setMax(19);
        numberControl.setProgress(5);

        int size = 50;

        for (int i = 1; i <= size; i++) {

            timesList.add((i-1),
                    numberControl.getProgress()
                            + " x " + i + " = " + numberControl.getProgress()*i);

        }

        timesAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, timesList);

        timesView.setAdapter(timesAdapter);

        numberControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int size = 50;

                for (int i = 1; i <= size; i++) {

                    timesList.set((i-1), progress+1 + " x " + i + " = " + (progress+1)*(i));

                }

                timesView.setAdapter(timesAdapter);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
