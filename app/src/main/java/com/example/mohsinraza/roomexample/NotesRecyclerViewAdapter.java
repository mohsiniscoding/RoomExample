package com.example.mohsinraza.roomexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohsinraza.roomexample.model.Note;

import java.util.List;

public class NotesRecyclerViewAdapter extends RecyclerView.Adapter<NotesRecyclerViewAdapter.NotesViewHolder> {


    private List<Note> notes;

    public NotesRecyclerViewAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list_item, parent, false);

        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesViewHolder holder, int position) {
        holder.title.setText(notes.get(position).getTitle());
        holder.content.setText(notes.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder{

        TextView content, title;

        public NotesViewHolder(View itemView) {
            super(itemView);
            content = (TextView) itemView.findViewById(R.id.rv_content);
            title = (TextView) itemView.findViewById(R.id.rv_title);
        }
    }
}
