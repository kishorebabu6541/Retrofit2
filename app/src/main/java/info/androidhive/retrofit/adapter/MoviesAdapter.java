package info.androidhive.retrofit.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import info.androidhive.retrofit.R;
import info.androidhive.retrofit.activity.MainActivity;
import info.androidhive.retrofit.model.Movie;
import info.androidhive.retrofit.model.MoviesResponse;
import retrofit2.Callback;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;
    OnEachcardSelected _mlistener;
    LayoutInflater layoutInflater;
    String baseImgUrl="http://image.tmdb.org/t/p/w185//";


    public MoviesAdapter(OnEachcardSelected mlistener,List<Movie> movies,LayoutInflater inflater){
        this.movies = movies;
        layoutInflater=inflater;
        _mlistener=mlistener;
    }




    public class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView movieDescription;
        RatingBar rating;
        ImageView img;


        public MovieViewHolder(View v) {
            super(v);
            img=(ImageView) v.findViewById(R.id.moviecard);
            movieTitle = (TextView) v.findViewById(R.id.tilt);
            movieDescription = (TextView) v.findViewById(R.id.description);
            rating = (RatingBar) v.findViewById(R.id.cardmovierating);
            v.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            _mlistener.onCardClicked(getLayoutPosition(),movies.get(getAdapterPosition()));
        }
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_movie, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.movieDescription.setText(movies.get(position).getOverview());
        Double rating=movies.get(position).getVoteAverage();
        holder.rating.setRating(rating.floatValue()/2);
        Glide.with(holder.img.getContext())
                .load(baseImgUrl+movies.get(position).getPosterPath())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public interface OnEachcardSelected{
        void onCardClicked(int position,Movie movie);
    }
}