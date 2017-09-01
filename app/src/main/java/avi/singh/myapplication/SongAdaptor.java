package avi.singh.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
public class SongAdaptor extends RecyclerView.Adapter<SongAdaptor.SongHolder> {

    private ArrayList<SongInfo> _songs = new ArrayList<SongInfo>();
    private Context context;
    private OnItemClickListener mOnItemClickListener;

    public SongAdaptor(Context context, ArrayList<SongInfo> songs) {
        this.context = context;
        this._songs = songs;
    }

    public interface OnItemClickListener {
        void onItemClick(Button b ,View view, SongInfo obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }


    @Override
    public SongHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View myView = LayoutInflater.from(context).inflate(R.layout.activity_device,viewGroup,false);
        return new SongHolder(myView);
    }

    @Override
    public void onBindViewHolder(final SongHolder songHolder, final int i) {
        final SongInfo s = _songs.get(i);
        songHolder.tvSongName.setText(_songs.get(i).getSongname());
        songHolder.tvSongArtist.setText(_songs.get(i).getArtistname());
        songHolder.tvAlbum.setImageDrawable(Drawable.createFromPath(_songs.get(i).getAlbum()));

    }

    @Override
    public int getItemCount() {
        return _songs.size();
    }

    public class SongHolder extends RecyclerView.ViewHolder {
        TextView tvSongName;
        TextView tvSongArtist;
        ImageView tvAlbum;

        public SongHolder(View itemView) {
            super(itemView);
            tvSongName = (TextView) itemView.findViewById(R.id.tvSongName);
            tvSongArtist = (TextView) itemView.findViewById(R.id.tvArtistName);
            tvAlbum = (ImageView) itemView.findViewById(R.id.album);

        }
    }
}

