package com.example.al_ameenfashola.homework2app;

import android.media.Rating;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.OnClickListener;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, PlaceholderFragment.newInstance(R.id.action_setting2))
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container,  PlaceholderFragment.newInstance(id))
                    .commit();


        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public static final String ARG_OPTION = "argument option" ;

        public static PlaceholderFragment newInstance (int option) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_OPTION, option);
            fragment.setArguments(args);

            return fragment;
        }


        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            int option = getArguments().getInt(ARG_OPTION) ;

            switch(option) {


                case R.id.action_setting2:
                    rootView = inflater.inflate(R.layout.fragment_main, container, false);

                    break;

                case R.id.action_setting3:
                    rootView = inflater.inflate(R.layout.linearlayout, container, false);
                    break;
                case R.id.action_setting4:
                    rootView = inflater.inflate(R.layout.relativelayout, container, false);
                    break;
                case R.id.action_setting5:
                    rootView = inflater.inflate(R.layout.gridlayout, container, false);
                    break;
                case R.id.action_setting6:
                    rootView = inflater.inflate(R.layout.seekbar, container, false);
                    break;
                case R.id.action_setting7:
                    rootView = inflater.inflate(R.layout.moviedata, container, false);
                    final MovieData moviedata=new MovieData();
                    Integer image=(Integer)moviedata.getItem(0).get("image");
                    final ImageView picview = (ImageView) rootView.findViewById(R.id.imageView3);
                    picview.setImageResource(image); ;

                    String name=(String)moviedata.getItem(0).get("name");
                    final TextView nameview= (TextView) rootView.findViewById(R.id.textView7);
                    nameview.setText(name) ;

                    String description=(String)moviedata.getItem(0).get("description");
                    final TextView descriptionview = (TextView) rootView.findViewById(R.id.textView8);
                    descriptionview.setText(description) ;

                    String year=(String)moviedata.getItem(0).get("year");
                    final TextView yearview = (TextView) rootView.findViewById(R.id.textView9);
                    yearview.setText(year) ;

                    String length=(String)moviedata.getItem(0).get("length");
                    final TextView lengthview = (TextView) rootView.findViewById(R.id.textView10);
                    lengthview.setText(length) ;

                    Double rating=(Double)moviedata.getItem(0).get("rating");

                    final RatingBar ratingview = (RatingBar)rootView.findViewById(R.id.ratingBar) ;
                    ratingview.setRating((float) rating.floatValue()/2); ;

                    String director=(String)moviedata.getItem(0).get("director");
                    final TextView directorview = (TextView) rootView.findViewById(R.id.textView11);
                    directorview.setText(director) ;

                    String stars=(String)moviedata.getItem(0).get("stars");
                    final TextView starsview = (TextView) rootView.findViewById(R.id.textView12);
                    starsview.setText(stars) ;

                    String url=(String)moviedata.getItem(0).get("url");
                    final TextView urlview = (TextView) rootView.findViewById(R.id.textView14);
                    urlview.setText(url) ;


                    Button button= (Button) rootView.findViewById(R.id.button13);
                    button.setOnClickListener(new View.OnClickListener() {

                        int position = 0 ;

                        final MovieData moviedata=new MovieData();
                        @Override
                    public void onClick (View view)
                      {
                          if(position<=moviedata.getSize())
                       position++ ;

                          else if (position>moviedata.getSize())
                          position=0 ;

                          Integer image=(Integer)moviedata.getItem(position).get("image");
                          picview.setImageResource(image); ;

                          String name=(String)moviedata.getItem(position).get("name");

                          nameview.setText(name) ;

                          String description=(String)moviedata.getItem(position).get("description");

                          descriptionview.setText(description) ;

                          String year=(String)moviedata.getItem(position).get("year");

                          yearview.setText(year) ;

                          String length=(String)moviedata.getItem(position).get("length");
                          lengthview.setText(length) ;

                          Double rating=(Double)moviedata.getItem(position).get("rating");

                          ratingview.setRating((float) rating.floatValue()/2); ;

                          String director=(String)moviedata.getItem(position).get("director");
                          directorview.setText(director) ;

                          String stars=(String)moviedata.getItem(position).get("stars");
                          starsview.setText(stars) ;

                          String url=(String)moviedata.getItem(position).get("url");
                          urlview.setText(url) ;
                      }


                    });


                    break;

            }



            Toast.makeText(getActivity().getApplicationContext(),Integer.toString(option),
                    Toast.LENGTH_LONG).show();

            return rootView;
        }
    }
}
