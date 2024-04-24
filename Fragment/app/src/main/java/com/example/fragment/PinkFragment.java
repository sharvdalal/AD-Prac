package com.example.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class PinkFragment extends Fragment {
    EditText editText;
    private OnPinkFragmentListener mCallback;
    public PinkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_pink, container, false);
        editText=v.findViewById(R.id.enter);
        Button button = v.findViewById(R.id.buttonsend);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                mCallback.messageFromPinkFragment(message);
            }
        });

        return v;
    }
    public interface OnPinkFragmentListener {
        void messageFromPinkFragment(String text);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnPinkFragmentListener) {
            mCallback = (OnPinkFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnPinkFragmentListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mCallback = null;
    }

}