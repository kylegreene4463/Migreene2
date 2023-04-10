package com.example.kyle1minam2assign2;

import static android.content.ContentValues.TAG;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DBScreen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DBScreen extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button button;
    TextView textView;

    public DBScreen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DBScreen.
     */
    // TODO: Rename and change types and number of parameters
    public static DBScreen newInstance(String param1, String param2) {
        DBScreen fragment = new DBScreen();
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
        View view = inflater.inflate(R.layout.db_screen, container, false);
        button = view.findViewById(R.id.dbButton);
        textView = view.findViewById(R.id.dbTV);

        //https://stackoverflow.com/questions/40184797/retrieve-data-from-firebase-database-on-button-click
        //and from your video
        DatabaseReference myRef;
        FirebaseDatabase firebaseDatabase;
        firebaseDatabase = FirebaseDatabase.getInstance();

        myRef = firebaseDatabase.getReference(getString(R.string.msg));
        myRef.setValue(getString(R.string.hello));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        // Read from the database
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // This method is called once with the initial value and again
                        // whenever data at this location is updated.
                        String value = dataSnapshot.getValue(String.class);
                        textView.setTextColor(Color.BLACK);
                        textView.setTypeface(null, Typeface.BOLD);
                        Log.d(TAG, getString(R.string.valueIs) + value);
                        textView.setText(value);
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value
                        textView.setTextColor(Color.RED);
                        textView.setTypeface(null, Typeface.BOLD_ITALIC);
                        Log.w(TAG, getString(R.string.failed), error.toException());
                    }
                });
            }
        });



        return view;
    }
}