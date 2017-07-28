package com.vukoye.annotationstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @CourtParams(width = 6000, length = 10000)
    Court footballCourt;

    @CourtParams(width = 94, length = 50, dimension = CourtParams.Dimension.FEETS)
    private Court nbaCourt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnnotationProcessor annotation = AnnotationProcessor.getInstance();
        annotation.process(this);
        Log.d(TAG, "football: " + footballCourt.print());
        Log.d(TAG, "nbaCourt: " + nbaCourt.print());
    }
}
