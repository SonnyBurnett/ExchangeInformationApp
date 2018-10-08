package nl.tsbakker.exchangeinformationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mButton;
    private TextView mName;
    private TextView mTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = findViewById(R.id.name_textview);
        mTeam = findViewById(R.id.team_textview);
        mButton = findViewById(R.id.goto_input_button);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DataInput.class);
                startActivityForResult(intent,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            mName.setText(data.getStringExtra(DataInput.EXTRA_NAME));
            mTeam.setText(data.getStringExtra(DataInput.EXTRA_TEAM));
        }
    }
}
