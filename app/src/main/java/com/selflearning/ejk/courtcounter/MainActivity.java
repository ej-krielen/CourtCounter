package com.selflearning.ejk.courtcounter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA();
        displayForTeamB();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA() {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreTeamA));
    }

    /**
     * Adds 3 points to the score of Team A
     */
    public void addThreePointsToA(View view) {
        scoreTeamA += 3;
        displayForTeamA();
    }

    /**
     * Adds 2 points to the score of Team A
     */
    public void addTwoPointsToA(View view) {
        scoreTeamA += 2;
        displayForTeamA();
    }

    /**
     * Adds 1 points to the score of Team A
     */
    public void addOnePointToA(View view) {
        scoreTeamA += 1;
        displayForTeamA();
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB() {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreTeamB));
    }

    /**
     * Adds 3 points to the score of Team B
     */
    public void addThreePointsToB(View view) {
        scoreTeamB += 3;
        displayForTeamB();
    }

    /**
     * Adds 2 points to the score of Team B
     */
    public void addTwoPointsToB(View view) {
        scoreTeamB += 2;
        displayForTeamB();
    }

    /**
     * Adds 1 points to the score of Team B
     */
    public void addOnePointToB(View view) {
        scoreTeamB += 1;
        displayForTeamB();
    }

    /**
     * Resets the score and notifies user of ending of game
     */
    public void endGame(View view) {
        //Standard part always added.
        String toastString = getString(R.string.main_toast_game_ended);
        if (scoreTeamA == scoreTeamB) {
            //If game is a draw add text to notification to signify
            toastString = toastString + getString(R.string.main_toast_score_tied);
        } else if (scoreTeamA > scoreTeamB) {
            //If team a's score is higher add team name to notification to signify
            toastString = toastString + getString(R.string.main_team_A);
            //Add extra text to complete the sentence
            toastString = toastString + getString(R.string.main_toast_declare_winner);
        } else if (scoreTeamA < scoreTeamB) {
            //If team b's score is higher add team name to notification to signify
            toastString = toastString + getString(R.string.main_team_B);
            //Add extra text to complete the sentence
            toastString = toastString + getString(R.string.main_toast_declare_winner);
        }
        //Set both scores to 0
        scoreTeamA = 0;
        scoreTeamB = 0;

        //Set both text views to proper score
        displayForTeamA();
        displayForTeamB();

        //Show toast with the string created based on final score
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout,
                (ViewGroup) findViewById(R.id.toast_layout_root));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText(toastString);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}