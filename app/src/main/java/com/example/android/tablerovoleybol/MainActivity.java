package com.example.android.tablerovoleybol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreLocalTeam = 0;
    int scoreVisitTeam = 0;
    int actualSet = 1;
    int localSets = 0;
    int visitSets = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pointForLocalTeam(View v) {
        scoreLocalTeam = scoreLocalTeam + 1;
        displayForLocalTeam(scoreLocalTeam);
        if ((scoreLocalTeam > 24) && (scoreLocalTeam > scoreVisitTeam + 2)) {
            localSets = localSets + 1;
            displayLocalSets(localSets);
            if (localSets == 3) {
                displayWinner("Local gana");
                Toast.makeText(getApplicationContext(), "Local gana", Toast.LENGTH_SHORT).show();
            } else {
                actualSet = actualSet + 1;
                displayActualSet(actualSet);
                newSet();
            }
        }
    }

    public void pointForVisitTeam(View v) {
        scoreVisitTeam = scoreVisitTeam + 1;
        displayForVisitTeam(scoreVisitTeam);
        if ((scoreVisitTeam > 24) && (scoreVisitTeam > scoreLocalTeam + 2)) {
            visitSets = visitSets + 1;
            displayVisitSets(visitSets);
            if (visitSets == 3) {
                displayWinner("Visitante gana");
                Toast.makeText(getApplicationContext(), "Visitante gana", Toast.LENGTH_SHORT).show();
            } else {
                actualSet = actualSet + 1;
                displayActualSet(actualSet);
                newSet();
            }
        }

    }

    public void displayForLocalTeam(int score) {
        TextView scoreView = (TextView) findViewById(R.id.local_team_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForVisitTeam(int score) {
        TextView scoreView = (TextView) findViewById(R.id.visit_team_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayLocalSets(int sets) {
        TextView localSetsView = (TextView) findViewById(R.id.localSets);
        localSetsView.setText(String.valueOf(sets));
    }

    public void displayVisitSets(int sets) {
        TextView visitSetsView = (TextView) findViewById(R.id.visitSets);
        visitSetsView.setText(String.valueOf(sets));
    }

    public void displayActualSet(int set) {
        TextView setView = (TextView) findViewById(R.id.actualSetBox);
        setView.setText(String.valueOf(set));
    }

    public void displayWinner(String win) {
        TextView winnerView = (TextView) findViewById(R.id.winnerBox);
        winnerView.setText(String.valueOf(win));
    }

    public void newSet() {
        scoreLocalTeam = 0;
        scoreVisitTeam = 0;
        displayForLocalTeam(scoreLocalTeam);
        displayForVisitTeam(scoreVisitTeam);
    }

    public void resetScore(View v) {
        actualSet = 1;
        localSets = 0;
        visitSets = 0;
        newSet();
        displayActualSet(actualSet);
        displayLocalSets(localSets);
        displayVisitSets(visitSets);
    }
}
