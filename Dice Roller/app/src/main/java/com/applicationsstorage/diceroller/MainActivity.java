package com.applicationsstorage.diceroller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private Random RandomNo1 = new Random();
    private Random RandomNo2 = new Random();
   // public Button button;


    public ImageView dicebtn1;
    public ImageView dicebtn2;

    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dicebtn1 = findViewById(R.id.imageview);
        dicebtn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                rolldice1();
            }
        });

        dicebtn2 = findViewById(R.id.imageview2);
        dicebtn2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                rolldice2();
            }
        });

    /*dicebtn1=findViewById(R.id.imageview);
    dicebtn2=findViewById(R.id.imageview2);
    button = findViewById(R.id.button);
      button.setOnClickListener(new View.OnClickListener()
      {
          @Override
          public void onClick(View v)
          {
              rolldice1();
          }
      });*/

    }
//      public void dicePressed(ImageView v)
//      {
//          rolldice1();
//      }


    public void rolldice1()
    {
        int count = RandomNo1.nextInt(6)+1;
       // int count2 = RandomNo2.nextInt(6) + 1;

        switch(count)
        {
            case 1:
                 // skip the this type of line :button.setImageResource(R.mipmap.dice1);
                dicebtn1.setImageResource(R.mipmap.dice1);
                break;

            case 2:
                // button.setImageResource(R.mipmap.dice2);
                dicebtn1.setImageResource(R.mipmap.dice2);
                break;

            case 3:
                //button.setImageResource(R.mipmap.dice3);
                dicebtn1.setImageResource(R.mipmap.dice3);
                break;

            case 4:
                //button.setImageResource(R.mipmap.dice4);
                dicebtn1.setImageResource(R.mipmap.dice4);
                break;

            case 5:
                //button.setImageResource(R.mipmap.dice5);
                dicebtn1.setImageResource(R.mipmap.dice5);
                break;

            case 6:
                //button.setImageResource(R.mipmap.dice6);
                dicebtn1.setImageResource(R.mipmap.dice6);
                break;

        }
    }

      /*  switch (count2)
        {
            case 1:
                //button.setImageResource(R.mipmap.dice1);
                dicebtn2.setImageResource(R.mipmap.dice1);
                break;

            case 2:
                //button.setImageResource(R.mipmap.dice2);
                dicebtn2.setImageResource(R.mipmap.dice2);
                break;

            case 3:
                //button.setImageResource(R.mipmap.dice3);
                dicebtn2.setImageResource(R.mipmap.dice3);
                break;

            case 4:
                //button.setImageResource(R.mipmap.dice4);
                dicebtn2.setImageResource(R.mipmap.dice4);
                break;

            case 5:
                //button.setImageResource(R.mipmap.dice5);
                dicebtn2.setImageResource(R.mipmap.dice5);
                break;

            case 6:
                //button.setImageResource(R.mipmap.dice6);
                dicebtn2.setImageResource(R.mipmap.dice6);
                break;

        }*/


       public void rolldice2()
        {
            int count2 = RandomNo2.nextInt(6) + 1;

            switch (count2)
            {
                case 1:
                    //button.setImageResource(R.mipmap.dice1);
                   dicebtn2.setImageResource(R.mipmap.dice1);
                    break;

                case 2:
                    //button.setImageResource(R.mipmap.dice2);
                    dicebtn2.setImageResource(R.mipmap.dice2);
                    break;

                case 3:
                    //button.setImageResource(R.mipmap.dice3);
                    dicebtn2.setImageResource(R.mipmap.dice3);
                    break;

                case 4:
                    //button.setImageResource(R.mipmap.dice4);
                    dicebtn2.setImageResource(R.mipmap.dice4);
                    break;

                case 5:
                    //button.setImageResource(R.mipmap.dice5);
                    dicebtn2.setImageResource(R.mipmap.dice5);
                    break;

                case 6:
                    //button.setImageResource(R.mipmap.dice6);
                    dicebtn2.setImageResource(R.mipmap.dice6);
                    break;

            }

        }

}
