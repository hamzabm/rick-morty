package com.uppa.rickmorty.viewholder;

import androidx.recyclerview.widget.RecyclerView;
import com.uppa.rickmorty.databinding.EpisodeItemBinding;
import com.uppa.rickmorty.network.model.Episode;

public class EpisodeViewHolder extends RecyclerView.ViewHolder{
    private  final EpisodeItemBinding ui;

    public EpisodeViewHolder(EpisodeItemBinding ui){
        super(ui.getRoot());
        this.ui = ui;
    }

    public void setEpisode(Episode episode){
        ui.name.setText(episode.getName());
        ui.date.setText(episode.getAirDate());
    }

}