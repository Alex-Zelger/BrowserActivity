package edu.temple.browseractivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

public class BrowserActivity extends AppCompatActivity implements PageControlFragment.PageControlFragmentListener, PageViewerFragment.PageViewerFragmentListener {
    String url;
    String back;
    String forward;
    private Fragment fragControl;
    private Fragment fragViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragControl = new PageControlFragment();
        fragViewer = new PageViewerFragment();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.pageFragement, fragViewer);
        ft.replace(R.id.controlFragement, fragControl);
        ft.commit();

        }


    @Override
    public void onInputSent(CharSequence input) {
        url = input.toString();
        if(!url.startsWith("https://")){
            url = "https://" + url;
            useURL(url);
        } else {
            useURL(url);
        }
    }

    @Override
    public void useURL(String input) {
       // fragViewer.useURL(input);
    }
}
