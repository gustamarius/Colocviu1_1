package ro.pub.cs.systems.eim.colocviu1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Colocviu1_1MainActivity extends AppCompatActivity {

    private TextView display;
    private int counter;
    protected KeypadButtonClickListener buttonClickListener = new KeypadButtonClickListener();
    protected class KeypadButtonClickListener implements View.OnClickListener {

        @Override
        @SuppressWarnings("all")
        public void onClick(View view) {
            display = (TextView)findViewById(R.id.display);
            switch (view.getId()) {
                case R.id.nord:
                    String aux_n = display.getText().toString();
                    display.setText(aux_n.concat(",North"));
                    counter += 1;
                    break;
                case R.id.sud:
                    String aux_s = display.getText().toString();
                    display.setText(aux_s.concat(",South"));
                    counter += 1;
                    break;
                case R.id.est:
                    String aux_e = display.getText().toString();
                    display.setText(aux_e.concat(",East"));
                    counter += 1;
                    break;
                case R.id.vest:
                    String aux_w = display.getText().toString();
                    display.setText(aux_w.concat(",West"));
                    counter += 1;
                    break;
                case R.id.secondactivitybutton:
                    counter += 1;
                    Intent intent = new Intent(getApplicationContext(), Colocviu1_1SecondaryActivity.class);
                    String message = display.getText().toString();
                    intent.putExtra(Constants.COUNTER, counter);
                    intent.putExtra(Constants.MESSAGE, message);
                    startActivityForResult(intent, 1);
                    break;
//                    String aux = display.getText().toString();
//                    display.setText(aux.concat(",Nord"));
//                    break;
            }
            Log.d("Msg", new String(String.valueOf(counter)));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_1_main);

        Button nord_button = (Button)findViewById(R.id.nord);
        nord_button.setOnClickListener(buttonClickListener);

        Button south_button = (Button)findViewById(R.id.sud);
        south_button.setOnClickListener(buttonClickListener);

        Button east_button = (Button)findViewById(R.id.est);
        east_button.setOnClickListener(buttonClickListener);

        Button west_button = (Button)findViewById(R.id.vest);
        west_button.setOnClickListener(buttonClickListener);

        Button secondActivityButton = (Button)findViewById(R.id.secondactivitybutton);
        secondActivityButton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(Constants.COUNTER)) {
                counter = savedInstanceState.getInt(Constants.COUNTER);
            }
        }
        else {
            counter = 0;
        }
        Log.d("Msg", new String(String.valueOf(counter)));
    }

    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(Constants.COUNTER,counter);

    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(Constants.COUNTER)) {
            counter = savedInstanceState.getInt(Constants.COUNTER);
        } else {
            counter = 0;
        }
    }
}