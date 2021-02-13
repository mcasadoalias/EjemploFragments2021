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
                if (vmodel.getScreenSize()==ScreenSize.SMALL) {
                    switch (id) {
                        case R.id.btn1:
                        case R.id.btn2:
                            getSupportFragmentManager().beginTransaction()
                                    .setReorderingAllowed(true)
                                    .replace(R.id.mainContainer, new DetailsFragment())
                                    .addToBackStack(null)
                                    .commit();
                            break;
                    /*case R.id.btn2:
                        if (vmodel.getScreenSize()==ScreenSize.SMALL){

                        }
                        break;*/
                        // -1 means that the navigation  fragment is set
                        case -1:
                        default:
                            getSupportFragmentManager().beginTransaction()
                                    .setReorderingAllowed(true)
                                    .replace(R.id.mainContainer, new NavigationFragment())
                                    .addToBackStack(null)
                                    .commit();
                    }
                }
            }
        });

        if (vmodel.getScreenSize()==ScreenSize.UNKNOWN){
            mainContainer = findViewById(R.id.mainContainer);
            if (mainContainer!= null) {
                vmodel.setScreenSize(ScreenSize.SMALL);
            } else {
                vmodel.setScreenSize(ScreenSize.BIG);
            }
        }


        //If the layout that has been loaded is the one for small screens
        //and the activity has been created for the first time (no configuration changes)
        if (vmodel.getScreenSize()==ScreenSize.SMALL && savedInstanceState==null) {


            initialData = new Bundle();
            initialData.putString(getResources().getString(R.string.initial_data_key),
                                  "JUST A TEST STRING PASSED AS AN ARGUMENT\n" +
                                          " ONLY IN CASE OF SMALL SCREEN");
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.mainContainer, NavigationFragment.class, initialData)
                    //.add (R.id.mainContainer, new NavigationFragment())
                    .commit();

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // -1 means that the navigation fragment is set
        vmodel.setClickedBtn(-1);
    }
}