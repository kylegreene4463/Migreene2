package com.example.kyle1minam2assign2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KyleMinamHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KyleMinamHome extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RadioGroup radioGroup;
    TextView textView;

    public KyleMinamHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KyleMinamHome.
     */
    // TODO: Rename and change types and number of parameters
    public static KyleMinamHome newInstance(String param1, String param2) {
        KyleMinamHome fragment = new KyleMinamHome();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.kyleminam_home, container, false);

        radioGroup = (RadioGroup) view;
        Random random = new Random();
        int number = random.nextInt(50 + 50) - 50;
        textView = (TextView) getView().findViewById(R.id.outTv);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int radioID = radioGroup.getCheckedRadioButtonId();

                switch (radioID){

                    case R.id.randomB:
                        break;

                    case R.id.randomtxtB:
                        break;

                    case R.id.firebaseB:
                        break;
                }
            }
        });

        return view;
    }
}