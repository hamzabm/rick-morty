package com.uppa.rickmorty.viewholder;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.uppa.rickmorty.adapters.CharactersAdapter;
import com.uppa.rickmorty.databinding.CharacterItemBinding;
import com.uppa.rickmorty.network.model.Character;

public class CharaceterViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
    private  final CharacterItemBinding ui;
    private CharactersAdapter.OnItemClickListener listener ;
    public CharaceterViewHolder(CharacterItemBinding ui){
        super(ui.getRoot());
        this.ui = ui;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("Log","itemClicked");
        if((listener != null)){
            this.listener.onItemClick(getAdapterPosition());
        }
    }

    public  void setOnItemClickListener(CharactersAdapter.OnItemClickListener i){
        this.listener = i;
    }
    public void setCharacter(Character character){
        ui.name.setText(character.getName());
        ui.type.setText(character.getSpecies());
        ui.status.setText(character.getStatus());
        Glide.with(ui.getRoot()).load(character.getImage()).into(ui.logo);

    }

}