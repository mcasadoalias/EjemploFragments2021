package es.iesnervion.ejemplofragments2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        View mainContainer;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainContainer = findViewById(R.id.mainContainer);

        //If the layout that has been loaded is the one for small screens
        if (mainContainer!=null){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.mainContainer, NavigationFragment.class, null)
                    .commit();
        }
    }
}