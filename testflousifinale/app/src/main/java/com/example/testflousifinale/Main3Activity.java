package com.example.testflousifinale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.testflousifinale.MainActivity.dbadap;
import static com.example.testflousifinale.MainActivity.getAppFirstInstallTime;
import static com.example.testflousifinale.MainActivity.getDate;


public class Main3Activity extends AppCompatActivity {
    Long date ;
    TextView t,dateview ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        t =findViewById(R.id.total);
        t.setText(Float.toString(dbadap.total()));
        date= getAppFirstInstallTime(this);
        String d = getDate(date, "dd/MM/yyyy");
        dateview=findViewById(R.id.date);
        dateview.setText(d);


    }

    @Override
    public void onResume(){
        super.onResume();
        // put your code here...
        t.setText(Float.toString(dbadap.total()));
    }
}
