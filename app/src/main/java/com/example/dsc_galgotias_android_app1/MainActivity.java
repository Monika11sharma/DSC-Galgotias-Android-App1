package com.example.dsc_galgotias_android_app1;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int Counter=0;

    public static FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        Button sorry=findViewById(R.id.button2);
        Button fight=findViewById(R.id.button);


        if(findViewById(R.id.frgmnt1)!=null)
        {
            if(savedInstanceState!=null)
                return;

            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.add(R.id.frgmnt1,new AngryFragment(),null);
            ft.commit();
        }

        sorry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Counter++;
                TextView tv=findViewById(R.id.toptxt);
                tv.setText(R.string.text_in_top2);
                tv.setBackgroundColor(getResources().getColor(R.color.yellow));
                fragmentManager.beginTransaction().replace(R.id.frgmnt1, new OkFragment()).commit();
                if (Counter > 10) {
                    tv.setText(R.string.txt_3);
                    tv.setBackgroundColor(getResources().getColor(R.color.dark_pink));
                    fragmentManager.beginTransaction().replace(R.id.frgmnt1, new VLoveFragment()).commit();
                }
                else if (Counter == 10) {
                    tv.setText(R.string.txt_2);
                    tv.setBackgroundColor(getResources().getColor(R.color.pink));
                    fragmentManager.beginTransaction().replace(R.id.frgmnt1, new LoveFragment()).commit();
                }
                    else if (Counter > 5)
                    fragmentManager.beginTransaction().replace(R.id.frgmnt1, new LsLoveFragment()).commit();
            }
        });

        fight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Counter<10) {
                    Counter = 0;
                    Toast.makeText(MainActivity.this,"Hey you are ruining it! Just Apologize",Toast.LENGTH_LONG).show();
                    TextView tv = findViewById(R.id.toptxt);
                    tv.setText(R.string.Top_text4);
                    tv.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                    fragmentManager.beginTransaction().replace(R.id.frgmnt1, new VangryFragment()).commit();
                }
                }
        });

    }


}