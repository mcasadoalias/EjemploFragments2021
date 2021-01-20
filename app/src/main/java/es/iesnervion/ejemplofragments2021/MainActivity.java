package es.iesnervion.ejemplofragments2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        View mainContainer;
        Bundle initialData;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainContainer = findViewById(R.id.mainContainer);

        //If the layout that has been loaded is the one for small screens
        //and the activity has been created for the first time (no configuration changes)
        if (mainContainer!=null && savedInstanceState==null) {

            initialData = new Bundle();
            initialData.putString(getResources().getString(R.string.initial_data),"Cadena de prueba pasada como parámetro");
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.mainContainer, NavigationFragment.class, initialData)
                    //.add (R.id.mainContainer, new NavigationFragment())
                    .addToBackStack(null)
                    .commit();
        }
    }
}