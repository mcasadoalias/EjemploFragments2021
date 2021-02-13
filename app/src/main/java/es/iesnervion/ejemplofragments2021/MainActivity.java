package es.iesnervion.ejemplofragments2021;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MainViewModel vmodel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        View mainContainer = null;
        Bundle initialData;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vmodel = new ViewModelProvider(this).get(MainViewModel.class);

        vmodel.getClickedBtn().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer id) {
                switch (id){
                    case R.id.btn1:
                    case R.id.btn2:
                        if (vmodel.getScreenSize()==ScreenSize.SMALL){
                            getSupportFragmentManager().beginTransaction()
                                    .setReorderingAllowed(true)
                                    .replace(R.id.mainContainer, new DetailsFragment())
                                    .addToBackStack(null)
                                    .commit();
                        }
                        break;
                    /*case R.id.btn2:
                        if (vmodel.getScreenSize()==ScreenSize.SMALL){

                        }
                        break;*/
                }

            }
        });

        if (vmodel.getScreenSize()==ScreenSize.UNKNOWN){
            mainContainer = findViewById(R.id.mainContainer);
        }


        //If the layout that has been loaded is the one for small screens
        //and the activity has been created for the first time (no configuration changes)
        if (mainContainer!=null && savedInstanceState==null) {
            vmodel.setScreenSize(ScreenSize.SMALL);

            initialData = new Bundle();
            initialData.putString(getResources().getString(R.string.initial_data_key),
                                  getResources().getString(R.string.initial_data));
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.mainContainer, NavigationFragment.class, initialData)
                    //.add (R.id.mainContainer, new NavigationFragment())
                    .commit();

        }

        //TODO I have to keep active fragment visible (nav or details) when there is a
        //   configuration change
    }
}