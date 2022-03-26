package com.uppa.rickmorty.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.uppa.rickmorty.databinding.CharacterItemBinding;
import com.uppa.rickmorty.network.model.Character;
import com.uppa.rickmorty.viewholder.CharaceterViewHolder;

import java.util.ArrayList;

public class CharactersAdapter  extends RecyclerView.Adapter<CharaceterViewHolder> {
    ArrayList<Character> characters;
    OnItemClickListener listener ;
    public CharactersAdapter(ArrayList<Character> list){
        characters= list;
    }
    public interface OnItemClickListener{
        void onItemClick(int postition);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
        notifyDataSetChanged();

    }
    @Override
    public int getItemCount() {
        return  characters.size();
    }

    @NonNull
    @Override
    public CharaceterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CharacterItemBinding ui = CharacterItemBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return  new CharaceterViewHolder(ui);
    }

    @Override
    public void onBindViewHolder(@NonNull CharaceterViewHolder holder, int position) {
        Character character = characters.get(position);
        holder.setCharacter(character);
        holder.setOnItemClickListener(this.listener);
    }
}
