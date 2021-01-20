package es.iesnervion.ejemplofragments2021;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationFragment extends Fragment {





    public NavigationFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TextView txtv_initial_data;
        String initialData = requireArguments().getString(getResources().getString(R.string.initial_data));
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_navigation, container, false);
        txtv_initial_data = v.findViewById(R.id.initialData);
        txtv_initial_data.setText(initialData);

        return v;
    }
}