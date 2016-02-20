package eduseva.hit.android.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Player_2 extends AppCompatActivity {

    private CheckBox rock, paper, scissors;
    private int player2memory, player1memory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_2);

        rock = (CheckBox) findViewById(R.id.rock);
        paper = (CheckBox) findViewById(R.id.paper);
        scissors = (CheckBox) findViewById(R.id.scissors);

        player1memory = getIntent().getIntExtra("PLAYER1CHOICE", player2memory);
    }

    public void buttonClicked(View v) {
        int count = 0;

        if (rock.isChecked() == true) {
            player2memory = 1;
            count++;
        }
        if (paper.isChecked() == true) {
            player2memory = 2;
            count++;
        }
        if (scissors.isChecked() == true) {
            player2memory = 3;
            count++;
        }

        if (count > 1) {
            Toast.makeText(this, "More than One selection not allowed", Toast.LENGTH_LONG).show();
        } else {
            decideWinner();
        }
    }

    public void decideWinner() {
        Log.i("DEMO", "decideWinner: " + player1memory + "-" + player2memory);
        if (player1memory == player2memory) {
            showOutput("IT IS A DRAW MATCH");
        }

        //If player-1 is ROCK
        if (player1memory == 1) {
            if (player2memory == 2) {
                showOutput("Player-2 has won");
            } else if (player2memory == 3) {
                showOutput("Player-1 has won");
            }
        }

        //If player-1 is PAPER
        if (player1memory == 2) {
            if (player2memory == 3) {
                showOutput("Player-2 has won");
            } else if (player2memory == 1) {
                showOutput("Player-1 has won");
            }
        }

        //If player-1 is SCISSORS
        if (player1memory == 3) {
            if (player2memory == 1) {
                showOutput("Player-2 has won");
            } else if (player2memory == 2) {
                showOutput("Player-1 has won");
            }
        }

    }

    public void showOutput(String msg) {
        Log.i("Demooutput", msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}
