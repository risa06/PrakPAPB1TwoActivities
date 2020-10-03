package com.prakpapb1.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_RERPLY="REPLY";
    private EditText mReply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReply=findViewById(R.id.editText_second);

        Intent intent=getIntent();
        if(intent.hasExtra(MainActivity.EXTRA_MESSAGE)) {
            String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            TextView textView=findViewById(R.id.text_message);
            textView.setText(message);
        }
    }

    public void returnReply(View view) {
        String reply=mReply.getText().toString();
        Intent replyIntent=new  Intent();
        replyIntent.putExtra(EXTRA_RERPLY, reply);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}