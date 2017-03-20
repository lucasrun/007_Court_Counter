package com.example.android.a007_court_counter;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Variables
    public int[][] teamArray = new int[2][8];
    TextView aTeamScore, aTouchDown, aFieldGoal, aExtraPoint, aTwoPointConversion, aSafety, aConversionSafety, aDefensiveSafety;
    TextView bTeamScore, bTouchDown, bFieldGoal, bExtraPoint, bTwoPointConversion, bSafety, bConversionSafety, bDefensiveSafety;
    Button aTouchDownButton, aFieldGoalButton, aExtraPointButton, aTwoPointConversionButton, aSafetyButton, aConversionSafetyButton, aDefensiveSafetyButton;
    Button bTouchDownButton, bFieldGoalButton, bExtraPointButton, bTwoPointConversionButton, bSafetyButton, bConversionSafetyButton, bDefensiveSafetyButton;
    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        //textviews
        aTeamScore = (TextView) findViewById(R.id.team_a_score);
        aTouchDown = (TextView) findViewById(R.id.touchDown_scoreA);
        aFieldGoal = (TextView) findViewById(R.id.fieldGoal_scoreA);
        aExtraPoint = (TextView) findViewById(R.id.extraPoint_scoreA);
        aTwoPointConversion = (TextView) findViewById(R.id.twoPointConversion_scoreA);
        aSafety = (TextView) findViewById(R.id.safety_scoreA);
        aConversionSafety = (TextView) findViewById(R.id.conversionSafety_scoreA);
        aDefensiveSafety = (TextView) findViewById(R.id.defensiveConversion_scoreA);
        bTeamScore = (TextView) findViewById(R.id.team_b_score);
        bTouchDown = (TextView) findViewById(R.id.touchDown_scoreB);
        bFieldGoal = (TextView) findViewById(R.id.fieldGoal_scoreB);
        bExtraPoint = (TextView) findViewById(R.id.extraPoint_scoreB);
        bTwoPointConversion = (TextView) findViewById(R.id.twoPointConversion_scoreB);
        bSafety = (TextView) findViewById(R.id.safety_scoreB);
        bConversionSafety = (TextView) findViewById(R.id.conversionSafety_scoreB);
        bDefensiveSafety = (TextView) findViewById(R.id.defensiveConversion_scoreB);

        //buttons
        aTouchDownButton = (Button) findViewById(R.id.touchDown_scoreA_button);
        aFieldGoalButton = (Button) findViewById(R.id.fieldGoal_scoreA_button);
        aExtraPointButton = (Button) findViewById(R.id.extraPoint_scoreA_button);
        aTwoPointConversionButton = (Button) findViewById(R.id.twoPointConversion_scoreA_button);
        aSafetyButton = (Button) findViewById(R.id.safety_scoreA_button);
        aConversionSafetyButton = (Button) findViewById(R.id.conversionSafety_scoreA_button);
        aDefensiveSafetyButton = (Button) findViewById(R.id.defensiveConversion_scoreA_button);
        bTouchDownButton = (Button) findViewById(R.id.touchDown_scoreB_button);
        bFieldGoalButton = (Button) findViewById(R.id.fieldGoal_scoreB_button);
        bExtraPointButton = (Button) findViewById(R.id.extraPoint_scoreB_button);
        bTwoPointConversionButton = (Button) findViewById(R.id.twoPointConversion_scoreB_button);
        bSafetyButton = (Button) findViewById(R.id.safety_scoreB_button);
        bConversionSafetyButton = (Button) findViewById(R.id.conversionSafety_scoreB_button);
        bDefensiveSafetyButton = (Button) findViewById(R.id.defensiveConversion_scoreB_button);
        resetButton = (Button) findViewById(R.id.reset_button);

        setScoreTo0(teamArray);
    }

    /*
    Team types:
    0 - team A
    1 - team B

    Score types:
    0 - team score
    1 - touchdown (6 points)
    2 - field goal (3 points)
    3 - extra point (1 point)
    4 - two point conversion (2 points)
    5 - safety (2 points)
    6 - conversion safety (1 point)
    7 - defensive conversion (2 points)
    */

    public void setScoreTo0(int[][] team) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 8; j++) {
                team[i][j] = 0;
            }
        }
        aTeamScore.setText("0");
        aTouchDown.setText("0");
        aFieldGoal.setText("0");
        aExtraPoint.setText("0");
        aTwoPointConversion.setText("0");
        aSafety.setText("0");
        aConversionSafety.setText("0");
        aDefensiveSafety.setText("0");
        bTeamScore.setText("0");
        bTouchDown.setText("0");
        bFieldGoal.setText("0");
        bExtraPoint.setText("0");
        bTwoPointConversion.setText("0");
        bSafety.setText("0");
        bConversionSafety.setText("0");
        bDefensiveSafety.setText("0");
    }

    public void increaseScore(TextView tv, int team, int scoreType, int points) {
        //calculate main score
        teamArray[team][0] += points;

        //calculate score for specific type
        teamArray[team][scoreType]++;

        //show main score
        if (team == 0) aTeamScore.setText(String.valueOf(teamArray[team][0]));
        if (team == 1) bTeamScore.setText(String.valueOf(teamArray[team][0]));

        //show score for specific type
        tv.setText(String.valueOf(teamArray[team][scoreType]));
    }

    public void multiClicker (View v) {
        Button buttonSwitch = (Button) v;
        switch (buttonSwitch.getId()) {
            case R.id.touchDown_scoreA_button:
                increaseScore(aTouchDown, 0, 1, 6);
                break;
            case R.id.fieldGoal_scoreA_button:
                increaseScore(aFieldGoal, 0, 2, 3);
                break;
            case R.id.extraPoint_scoreA_button:
                increaseScore(aExtraPoint, 0, 3, 1);
                break;
            case R.id.twoPointConversion_scoreA_button:
                increaseScore(aTwoPointConversion, 0, 4, 2);
                break;
            case R.id.safety_scoreA_button:
                increaseScore(aSafety, 0, 5, 2);
                break;
            case R.id.conversionSafety_scoreA_button:
                increaseScore(aConversionSafety, 0, 6, 1);
                break;
            case R.id.defensiveConversion_scoreA_button:
                increaseScore(aDefensiveSafety, 0, 7, 2);
                break;
            case R.id.touchDown_scoreB_button:
                increaseScore(bTouchDown, 1, 1, 6);
                break;
            case R.id.fieldGoal_scoreB_button:
                increaseScore(bFieldGoal, 1, 2, 3);
                break;
            case R.id.extraPoint_scoreB_button:
                increaseScore(bExtraPoint, 1, 3, 1);
                break;
            case R.id.twoPointConversion_scoreB_button:
                increaseScore(bTwoPointConversion, 1, 4, 2);
                break;
            case R.id.safety_scoreB_button:
                increaseScore(bSafety, 1, 5, 2);
                break;
            case R.id.conversionSafety_scoreB_button:
                increaseScore(bConversionSafety, 1, 6, 1);
                break;
            case R.id.defensiveConversion_scoreB_button:
                increaseScore(bDefensiveSafety, 1, 7, 2);
                break;
            case R.id.reset_button:
                setScoreTo0(teamArray);
                break;
        }
    }
}
