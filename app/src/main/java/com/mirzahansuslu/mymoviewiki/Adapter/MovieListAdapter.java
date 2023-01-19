package com.mirzahansuslu.mymoviewiki.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mirzahansuslu.mymoviewiki.Model.MovieModel;
import com.mirzahansuslu.mymoviewiki.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {
    Context context;
    List<MovieModel> movieModelList;

    public MovieListAdapter(Context context, List<MovieModel> movieModelList) {
        this.context = context;
        this.movieModelList = movieModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_movie_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(movieModelList.get(position).getImageUrl()).into(holder.imageView);

        holder.txtMovieName.setText(movieModelList.get(position).getName());
        holder.txtTeam.setText(movieModelList.get(position).getTeam());
        holder.txtCreatedby.setText(movieModelList.get(position).getPublisher());
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txtMovieName,txtCreatedby, txtTeam;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageMovie);
            txtMovieName = itemView.findViewById(R.id.txtMovieName);
            txtCreatedby = itemView.findViewById(R.id.txtCreatedby);
            txtTeam = itemView.findViewById(R.id.txtTeam);
        }
    }
}
