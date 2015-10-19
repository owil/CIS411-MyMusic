package com.wesleyreisz.mymusic;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.wesleyreisz.mymusic.model.Song;
import com.wesleyreisz.mymusic.service.MockMusicService;

import java.util.List;

public class MusicListView extends Fragment {
    private Context mContext = getActivity();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music_list_view, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        ListView listView = (ListView) getView().findViewById(R.id.listview_songs);
        List<Song> songs = new MockMusicService().findAll();
        SongAdapter songAdapter = new SongAdapter(mContext,R.layout.list_view_contents, songs);
        listView.setAdapter(songAdapter);
    }
}
