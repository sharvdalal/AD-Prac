package com.example.fragmentsimple;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class PinkFragment extends Fragment {

    public interface OnMessageSentListener {
        void onMessageSent(String message);
    }

    private EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pink, container, false);

        editText = view.findViewById(R.id.edit_text);
        Button sendButton = view.findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        return view;
    }

    private void sendMessage() {
        String message = editText.getText().toString();
        if (!message.isEmpty() && getActivity() instanceof OnMessageSentListener) {
            ((OnMessageSentListener) getActivity()).onMessageSent(message);
            editText.setText(""); // Clear the EditText after sending the message
        }
    }
}
