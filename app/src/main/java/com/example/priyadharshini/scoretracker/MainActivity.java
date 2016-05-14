package com.example.priyadharshini.scoretracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int teamAScore = 0;
    int teamBScore = 0;

    public void increment(View v) {
        switch (v.getId()) {
            case (R.id.a_2_points):
                teamAScore = teamAScore + 2;
                displayScore(teamAScore, "teamA");
                break;
            case (R.id.a_3_points):
                teamAScore = teamAScore + 3;
                displayScore(teamAScore, "teamA");
                break;
            case (R.id.a_free_points):
                teamAScore = teamAScore + 1;
                displayScore(teamAScore, "teamA");
                break;
            case (R.id.b_2_points):
                teamBScore = teamBScore + 2;
                displayScore(teamBScore, "teamB");
                break;
            case (R.id.b_3_points):
                teamBScore = teamBScore + 3;
                displayScore(teamBScore, "teamB");
                break;
            case (R.id.b_free_points):
                teamBScore = teamBScore + 1;
                displayScore(teamBScore, "teamB");
                break;
        }
        checkIfGameCompletes(teamAScore, teamBScore);
    }

    private void checkIfGameCompletes(int teamAScore, int teamBScore) {
        String winner = null;
        if (teamAScore >= 20 && teamBScore >= 20) {
            winner = "Draw match";
        } else if (teamAScore >= 20) {
            winner = "Team A";
        } else if (teamBScore >= 20) {
            winner = "Team B";
        }
        if (winner != null) {
            displayWinner(winner);
        }
    }

    private void displayWinner(String winner) {
        final TextView textA = (TextView) findViewById(R.id.winner);
        textA.setText("Congratulations " + winner +" !!!");
        resetScore();
    }

    private void resetScore() {
        final TextView textA = (TextView) findViewById(R.id.team_a_score);
        textA.setText("0");
        teamAScore = teamBScore = 0;
        final TextView textB = (TextView) findViewById(R.id.team_b_score);
        textB.setText("0");
    }

    private void displayScore(int score, String team) {
        final TextView textViewToChange;
        if (team.equals("teamA")) {
            textViewToChange = (TextView) findViewById(R.id.team_a_score);
            textViewToChange.setText(score + "");
        } else if (team.equals("teamB")) {
            textViewToChange = (TextView) findViewById(R.id.team_b_score);
            textViewToChange.setText(score + "");
        }
    }

    public void reset(View v) {
        resetScore();

        final TextView winner = (TextView) findViewById(R.id.winner);
        winner.setText("");
    }
}
