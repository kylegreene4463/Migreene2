package com.example.kyle1minam2assign2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.nio.charset.Charset;
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

        radioGroup = (RadioGroup) view.findViewById(R.id.rg);
        Random random = new Random();

        textView = view.findViewById(R.id.outTv);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int radioID = radioGroup.getCheckedRadioButtonId();
                int lastNum;
                String lastTxt;

                switch (radioID){

                    case R.id.randomB:
                        int number = -50 + random.nextInt(101);
                        lastNum = number;
                        textView.setText(Integer.toString(number));
                        break;

                    case R.id.randomtxtB:
                        //From the link that you provided
                        int a = 97; // for letter a
                        int z = 122; // for letter z
                        int targetStringLength = 10;
                        StringBuilder buffer = new StringBuilder(targetStringLength);
                        for (int var = 0; var < targetStringLength; var++) {
                            int randomLimitedInt = a + (int)
                                    (random.nextFloat() * (z - a + 1));
                            buffer.append((char) randomLimitedInt);
                        }
                        String generatedString = buffer.toString();
                        lastTxt = generatedString;
                        textView.setText(generatedString);
                        break;

                    case R.id.firebaseB:

                }
            }
        });

        return view;
    }
}