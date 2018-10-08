package nl.tsbakker.exchangeinformationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DataInput extends AppCompatActivity {

    private Button mBackButton;
    private EditText mInputName;
    private EditText mInputTeam;
    private String mName;
    private String mTeam;

    public static final String EXTRA_NAME = "Nick";
    public static final String EXTRA_TEAM = "Real Madrid";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_input);

        mInputName = findViewById(R.id.input_name_text);
        mInputTeam = findViewById(R.id.input_team_text);
        mBackButton = (Button)findViewById(R.id.back_button);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mName = mInputName.getText().toString();
                mTeam = mInputTeam.getText().toString();
                Intent data = new Intent();
                data.putExtra(EXTRA_NAME,mName);
                data.putExtra(EXTRA_TEAM,mTeam);
                setResult(RESULT_OK,data);
                finish();
            }
        });


    }
}
