package com.example.fragmentsimple;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BlueFragment extends Fragment {

    private TextView messageTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blue, container, false);
        messageTextView = view.findViewById(R.id.message_text_view);
        return view;
    }

    public void displayMessage(String message) {
        messageTextView.setText(message);
    }
}
