package edu.temple.browseractivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

public class PageControlFragment extends Fragment {
    private PageControlFragmentListener listener;
    private EditText editText;
    private ImageButton forward, back, go;
    CharSequence forwards, backward, start;

    public interface PageControlFragmentListener {
        void onInputSent(CharSequence input);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_page_control, container, false);
        editText = v.findViewById(R.id.txtEdit);
        forward = v.findViewById(R.id.btnForward);
        back = v.findViewById(R.id.btnBack);
        go = v.findViewById(R.id.btnGo);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                CharSequence input = editText.getText();
                start = input;
                backward = start;
                listener.onInputSent(input);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                forwards = start;
                start = backward;
                listener.onInputSent(backward);
            }
        });

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                backward = start;
                start = forwards;
                listener.onInputSent(forwards);
            }
        });

        return v;
        }

        public void updateEditText(CharSequence txt){
        editText.setText(txt);
        }

    }




