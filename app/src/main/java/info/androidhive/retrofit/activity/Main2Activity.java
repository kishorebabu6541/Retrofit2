package info.androidhive.retrofit.activity;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import info.androidhive.retrofit.R;
import info.androidhive.retrofit.model.Movie;

public class Main2Activity extends AppCompatActivity {
    Movie _ad;
//7e8f60e325cd06e164799af1e317d7a7
    //http://image.tmdb.org/t/p/w185//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg
    @Bind(R.id.img)
    ImageView poster;
    @Bind(R.id.moviename)
    TextView name;
    @Bind(R.id.descrip)
    TextView descrip;
    @Bind(R.id.ratingText)
    TextView ratingText;
    @Bind(R.id.movierating)
    RatingBar ratingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        String baseImgUrl="http://image.tmdb.org/t/p/w185//";
        ButterKnife.bind(this);

        _ad=getIntent().getParcelableExtra("Movie");

        Glide.with(Main2Activity.this)
                .load(baseImgUrl+_ad.getPosterPath())
                .into(poster);
        name.setText(_ad.getTitle());
        descrip.setText(_ad.getOverview());

    }
}
