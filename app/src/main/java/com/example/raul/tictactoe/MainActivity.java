package com.example.raul.tictactoe;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    ImageButton img00;
    ImageButton img01;
    ImageButton img02;
    ImageButton img10;
    ImageButton img11;
    ImageButton img12;
    ImageButton img20;
    ImageButton img21;
    ImageButton img22;
    TextView status;

    boolean turn = true;
    int curDraw = R.drawable.circle;
    int[] values = new int[9];

    public void turnSwitch(View img) {
        GridLayout ticTac = (GridLayout) findViewById(R.id.ticTacBoard);
        if (turn == false) {
            curDraw = R.drawable.circle;
            //need to use below because other getColor() method was deprecated
            ticTac.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.pinkish));
        } else {
            curDraw = R.drawable.cross;
            ticTac.setBackgroundColor(getResources().getColor(R.color.bluish));
        }
    }


    public void imgPress(View img) {
/*

        String Id = img.getResources().getResourceName(img.getId());//get the Id of Image Resource
        int position = Character.getNumericValue(Id.charAt(Id.length() - 1 ));//convert it to integer


        Log.i("testing functions lol", Integer.toString(position));
*/

//        ImageButton img00 = (ImageButton)img;

        if(endGame()){
            return;
        }



        String current = img.getTag().toString();
        int curIndex = Integer.parseInt(current);



        if (values[curIndex] == 0) {
            Log.i("Entered", "entered the switch statement");
            switch (current) {// used to be current
                case "0":
                    img00.setImageResource(curDraw);
                    break;
                case "1":
                    img01.setImageResource(curDraw);
                    break;
                case "2":
                    img02.setImageResource(curDraw);
                    break;
                case "3":
                    img10.setImageResource(curDraw);
                    break;
                case "4":
                    img11.setImageResource(curDraw);
                    break;
                case "5":
                    img12.setImageResource(curDraw);
                    break;
                case "6":
                    img20.setImageResource(curDraw);
                    break;
                case "7":
                    img21.setImageResource(curDraw);
                    break;
                case "8":
                    img22.setImageResource(curDraw);
                    break;
            }
            turnSwitch(img);
            turn = !turn;
            values[curIndex] = curDraw;
        }

        Log.i("turn?",  (turn) ? "yes tuen" : "no turn");
        Log.i("lastTag", current);
        Log.i("curDraw", Integer.toString(curDraw));


        if (endGame() == true) {
            Log.i("end?", "end condition is true");
            status.setVisibility(View.VISIBLE);
            Log.i("end?", "end condition is true");
        }
    }// end of function

    public void resetGame(View view) {
        Arrays.fill(values, 0);
        status.setVisibility(View.INVISIBLE);

        img00.setImageResource(android.R.color.transparent);
        img01.setImageResource(android.R.color.transparent);
        img02.setImageResource(android.R.color.transparent);
        img10.setImageResource(android.R.color.transparent);
        img11.setImageResource(android.R.color.transparent);
        img12.setImageResource(android.R.color.transparent);
        img20.setImageResource(android.R.color.transparent);
        img21.setImageResource(android.R.color.transparent);
        img22.setImageResource(android.R.color.transparent);
    }

    public boolean endGame() {
        if (checkThree(values[0], values[1], values[2]) ||
                checkThree(values[3], values[4], values[5]) ||
                checkThree(values[6], values[7], values[8])) {
            Log.i("horizontal", "horizontal");
            return true;

        }

        if (checkThree(values[0], values[3], values[6]) ||
                checkThree(values[1], values[4], values[7]) ||
                checkThree(values[2], values[5], values[8])) {
            Log.i("vertical", "vertical");
            return true;
        }
        if (
                checkThree(values[0], values[4], values[8]) ||
                        checkThree(values[2], values[4], values[6])) {
            Log.i("diag", "diag");
            return true;
        }
        return false;
    }

    public boolean checkThree(int one, int two, int three) {
        if (one == 0) return false;
        return ((one == two) && (one == three));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img00 = (ImageButton) findViewById(R.id.imageButton00);
        img01 = (ImageButton) findViewById(R.id.imageButton01);
        img02 = (ImageButton) findViewById(R.id.imageButton02);
        img10 = (ImageButton) findViewById(R.id.imageButton10);
        img11 = (ImageButton) findViewById(R.id.imageButton11);
        img12 = (ImageButton) findViewById(R.id.imageButton12);
        img20 = (ImageButton) findViewById(R.id.imageButton20);
        img21 = (ImageButton) findViewById(R.id.imageButton21);
        img22 = (ImageButton) findViewById(R.id.imageButton22);
        status = (TextView) findViewById(R.id.Title);
    }
}
