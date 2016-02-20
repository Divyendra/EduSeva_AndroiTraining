package eduseva.hit.android.rockpaperscissors;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Player_1 extends AppCompatActivity {

    private CheckBox rock, paper, scissors;
    private int memory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_1);

        rock = (CheckBox) findViewById(R.id.rock);
        paper = (CheckBox) findViewById(R.id.paper);
        scissors = (CheckBox) findViewById(R.id.scissors);
    }

    public void buttonClicked(View v) {
        int count = 0;
        if (rock.isChecked() == true) {
            memory = 1;
            count++;
        }
        if (paper.isChecked() == true) {
            memory = 2;
            count++;
        }
        if (scissors.isChecked() == true) {
            memory = 3;
            count++;
        }

        if (count > 1) {
            Log.i("Demo", "Count > 1");
            Toast.makeText(this, "More than One selection not allowed", Toast.LENGTH_LONG).show();
        } else {
            Log.i("Demo", "Count < 1");
            Intent intent = new Intent(this, Player_2.class);
            intent.putExtra("PLAYER1CHOICE", memory);
            startActivity(intent);
        }
    }
}
