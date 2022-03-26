package com.uppa.rickmorty.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uppa.rickmorty.databinding.CharacterItemBinding;
import com.uppa.rickmorty.databinding.EpisodeItemBinding;
import com.uppa.rickmorty.network.model.Character;
import com.uppa.rickmorty.network.model.Episode;
import com.uppa.rickmorty.viewholder.CharaceterViewHolder;
import com.uppa.rickmorty.viewholder.EpisodeViewHolder;

import java.util.ArrayList;

public class EpisodesAdapter extends RecyclerView.Adapter<EpisodeViewHolder> {
    ArrayList<Episode> episodes;

    public EpisodesAdapter(ArrayList<Episode> list){
        episodes= list;
    }

    @Override
    public int getItemCount() {
        return  episodes.size();
    }

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        EpisodeItemBinding ui = EpisodeItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return  new EpisodeViewHolder(ui);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        Episode episode = episodes.get(position);
        holder.setEpisode(episode);
    }
}
