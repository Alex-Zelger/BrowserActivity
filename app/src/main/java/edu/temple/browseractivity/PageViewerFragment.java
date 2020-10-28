package edu.temple.browseractivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class PageViewerFragment extends Fragment {

    public interface PageViewerFragmentListener {
        void useURL(String input);
    }
    private WebView wv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_page_viewer, container, false);
        wv = v.findViewById(R.id.wvFragment);


        return v;
    }
        public void useURL(String url){
        wv.loadUrl(url.toString());
    }
}