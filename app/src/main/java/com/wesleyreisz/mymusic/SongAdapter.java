package com.wesleyreisz.mymusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.wesleyreisz.mymusic.model.Song;
import java.text.SimpleDateFormat;
import java.util.List;

public class SongAdapter extends ArrayAdapter<Song>{
    private SimpleDateFormat df = new SimpleDateFormat("EEE, MMM d, yyyy");
    private Context mContext;
    private List<Song> mEntries;

    public SongAdapter(Context context, int resource, List<Song> entries) {
        super(context, resource, entries);
        mContext = context;
        mEntries = entries;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view==null){
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.fragment_music_list_view,parent,false);
        }
        final Song song = mEntries.get(position);

        TextView textViewTitle = (TextView)view.findViewById(R.id.song_title);
        textViewTitle.setText(song.getSongTitle());

        TextView textViewArtist = (TextView)view.findViewById(R.id.song_artist);
        textViewArtist.setText(song.getArtistName());

        TextView textViewAlbum = (TextView)view.findViewById(R.id.song_album);
        textViewAlbum.setText(song.getAlbumTitle());

        TextView textViewDate = (TextView)view.findViewById(R.id.song_date);
        textViewDate.setText(df.format(song.getSongPublishedDate()));
        return view;
    }
}
