package com.practice.android.problemset2;


 import android.os.Bundle;
 import android.support.v7.app.AppCompatActivity;
 import android.view.View;
 import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /**
     * Displays the given score for Team A.
     */
    int scoreA = 0;
    int scoreB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void ThreePointsA(View view){
        scoreA += 3;
        displayForTeamA(scoreA);
    }

    public void TwoPointsA(View view){
        scoreA += 2;
        displayForTeamA(scoreA);
    }

    public void FreeThrowsA(View view){
        scoreA += 1;
        displayForTeamA(scoreA);
    }

    public void ThreePointsB(View view){
        scoreB += 3;
        displayForTeamB(scoreB);
    }

    public void TwoPointsB(View view){
        scoreB += 2;
        displayForTeamB(scoreB);
    }

    public void FreeThrowsB(View view){
        scoreB += 1;
        displayForTeamB(scoreB);
    }

    public void clearScore(View view){
        scoreA = 0;
        scoreB = 0;
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }

    private void displayForTeamA(int scoreA) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(scoreA));
    }

    private void displayForTeamB(int scoreB) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(scoreB));
    }
}
