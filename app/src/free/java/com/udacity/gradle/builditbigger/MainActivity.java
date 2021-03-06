package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.jokeactivity.JokeActivity;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        Log.d("ARK","Called");
        new RetriveJokeAsyncTask().execute(new RetriveJokeAsyncTask.GotJokeCallback() {
            @Override
            public void done(String result, boolean error) {
                if (error) {
                    Log.e("error text", result);
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();
                }else {
                    Log.d("No Error","");
                    Intent intent = new Intent(getApplicationContext(), JokeActivity.class);
                    intent.putExtra(JokeActivity.JOKE_INTENT, result);
                    startActivity(intent);
                }
            }
        });
    }


}
