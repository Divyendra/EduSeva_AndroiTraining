package eduseva.hit.android.activity_lifecycle;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean showToast = true;
    private TextView onCreateTV, onStartTV, onResumeTV, onPauseTV, onStopTV, onDestroyTV;
    private int onCreateCount, onStartCount, onResumeCount, onPauseCount, onStopCount, onDestroyCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onCreateTV = (TextView) findViewById(R.id.onCreateCount);
        onStartTV = (TextView) findViewById(R.id.onStartCount);
        onResumeTV = (TextView) findViewById(R.id.onResumeCount);
        onPauseTV = (TextView) findViewById(R.id.onPauseCount);
        onStopTV = (TextView) findViewById(R.id.onStopCount);
        onDestroyTV = (TextView) findViewById(R.id.onDestoyCount);

        onCreateCount++;
        onCreateTV.setText(Integer.toString(onCreateCount));
        displayToast("onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        onStartCount++;
        onStartTV.setText(Integer.toString(onStartCount));
        displayToast("onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        onResumeCount++;
        onResumeTV.setText(Integer.toString(onResumeCount));
        displayToast("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        onPauseCount++;
        onPauseTV.setText(Integer.toString(onPauseCount));
        displayToast("onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        onStopCount++;
        onStopTV.setText(Integer.toString(onStopCount));
        displayToast("onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onDestroyCount++;
        onDestroyTV.setText(Integer.toString(onDestroyCount));
        displayToast("onDestroy()");
    }

    private void displayToast(String msg) {
        if (showToast) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
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
        if (id == R.id.action_hideToast) {
            showToast = false;
            invalidateOptionsMenu(); //To Refresh MenuItems in Toolbar.
            return true;
        }else if (id == R.id.action_showToast) {
            showToast = true;
            invalidateOptionsMenu();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
    * This method is called whenever menu is refrshed. In this class we are refreshing it manually
    * by calling "invalidateOptionsMenu()"
     */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (showToast) {
            menu.findItem(R.id.action_hideToast).setVisible(true);
            menu.findItem(R.id.action_showToast).setVisible(false);
        } else {
            menu.findItem(R.id.action_hideToast).setVisible(false);
            menu.findItem(R.id.action_showToast).setVisible(true);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public void clickedButton_1(View v) {
        showDialog();
    }

    public void clickedButton_2(View v) {
        Intent intent = new Intent(this, DialogActivity.class);
        startActivity(intent);
    }

    private void showDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this, R.style.Base_Theme_AppCompat_Dialog_Alert);
        dialogBuilder.setTitle("DIALOG");
        dialogBuilder.setMessage("This is called a Dialog and it is displayed over the current activity");
        dialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).show();
    }
}
