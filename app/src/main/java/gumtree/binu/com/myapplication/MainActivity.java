package gumtree.binu.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gumtree.binu.com.myapplication.Advert.AdvertActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent in = new Intent(getApplicationContext(), AdvertActivity.class);
        startActivity(in);
    }
}
