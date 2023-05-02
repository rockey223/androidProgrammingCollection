package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Sub extends Fragment {
    EditText firstnumber,secondnumber;
    Button addBtn;
    TextView result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sub, container, false);
        firstnumber= view.findViewById(R.id.firstnumber);
        secondnumber= view.findViewById(R.id.secondnumber);
        addBtn= view.findViewById(R.id.addBtn);
        result= view.findViewById(R.id.result);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int FirstNumber = Integer.parseInt(firstnumber.getText().toString());
                int SecondNumber = Integer.parseInt(secondnumber.getText().toString());
                int sum = FirstNumber - SecondNumber;
                closeKeyboard();
                result.setText("The Difference is " + sum+".");
            }
        });
        return view;
    }
    private void closeKeyboard() {
        if (getActivity() != null) {
            View view = getActivity().getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        }
    }
}