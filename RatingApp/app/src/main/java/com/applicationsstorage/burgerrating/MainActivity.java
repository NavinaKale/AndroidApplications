package com.applicationsstorage.burgerrating;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private RatingBar ratingBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        textView = findViewById(R.id.textView);
    }

    public void submit(View view)
    {
        float ratingValue = ratingBar.getRating();

        if(ratingValue<2) {
            textView.setText("Rating" + ratingValue + "\nWe will try better next time");
        }
        else if(ratingValue<=3 && ratingValue>=2)
        {
            textView.setText("Rating"+ratingValue+"\n We are constantly improving");
        }
        else if(ratingValue<=4 && ratingValue>=3)
        {
            textView.setText("Rating"+ratingValue+"\nOppps!!");
        }
        else if(ratingValue>4 && ratingValue<5)
        {
            textView.setText("Rating"+ratingValue+"\nThanks for your feedback");
        }
        else if(ratingValue==5)
        {
            textView.setText("Rating"+ratingValue+"\nWow!!!Thank You So Much");
        }
    }
}
