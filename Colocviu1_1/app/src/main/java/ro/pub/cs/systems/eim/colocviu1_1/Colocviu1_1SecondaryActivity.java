package ro.pub.cs.systems.eim.colocviu1_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Colocviu1_1SecondaryActivity extends AppCompatActivity {

    private TextView textView;
    private Button cancel, register;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        Toast toast;
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.register:
                    setResult(RESULT_OK, null);
                    toast = Toast.makeText(getApplicationContext(),"Register",Toast.LENGTH_SHORT);
                    toast.show();
                    break;
                case R.id.cancel:
                    setResult(RESULT_CANCELED, null);
                    toast = Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_SHORT);
                    toast.show();
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_1_secondary);

        textView = (TextView)findViewById(R.id.textView);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.MESSAGE)) {
            int counter = intent.getIntExtra(Constants.COUNTER, 0);
            String message = intent.getStringExtra(Constants.MESSAGE);
//            numberOfClicksTextView.setText(String.valueOf(numberOfClicks));
            textView.setText(new String(String.valueOf(counter).concat(message)));
            Button register = (Button)findViewById(R.id.register);
            register.setOnClickListener(buttonClickListener);

            Button cancel = (Button)findViewById(R.id.cancel);
            cancel.setOnClickListener(buttonClickListener);
        }


    }
}