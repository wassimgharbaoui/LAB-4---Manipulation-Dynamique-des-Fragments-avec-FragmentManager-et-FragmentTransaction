package com.example.fragmenttest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    private SeekBar seekBar;
    private TextView textViewValue;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        seekBar = view.findViewById(R.id.seekBar);
        textViewValue = view.findViewById(R.id.textView_value);

        // Gestion de la SeekBar
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewValue.setText("Valeur : " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Optionnel
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Optionnel
            }
        });

        // Bouton retour
        Button buttonBack = view.findViewById(R.id.button_back);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Revenir au Fragment1
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new Fragment1())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}