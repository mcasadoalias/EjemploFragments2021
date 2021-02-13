package es.iesnervion.ejemplofragments2021;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationFragment extends Fragment implements View.OnClickListener {

    private Button btn1, btn2;

    private MainViewModel vmodel;

    public NavigationFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vmodel = new ViewModelProvider(getActivity()).get(MainViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TextView txtv_initial_data;

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_navigation, container, false);
        txtv_initial_data = v.findViewById(R.id.initialData);

        try {
            // TODO We should persist this in the ViewModel in order to
            //  survive after a config. change
            vmodel.setInitialData (requireArguments().getString(getResources()
                    .getString(R.string.initial_data_key)));

        } catch (IllegalStateException e){
                // If there are no arguments, we don't do anything
        }
        txtv_initial_data.setText(vmodel.getInitialData());

        btn1 = v.findViewById(R.id.btn1);
        btn2 = v.findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {

        vmodel.setClickedBtn(view.getId());
        vmodel.setDetailText(getResources().getString(R.string.detail_text)+((Button)view).getText().toString());

    }
}