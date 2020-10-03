package com.prakpapb1.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG=MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE="MESSAGE";
    private EditText mMessageEditText;
    private TextView mReplyTextView;
    public static final int TEXT_REQUEST=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText=findViewById(R.id.editText_main);
        mReplyTextView=findViewById(R.id.text_message_reply);
    }

    public void launchSecondActivity(View view) {
        //Log.d(LOG_TAG, "Button clicked!");
        String message=mMessageEditText.getText().toString();

        Intent intent=new Intent (packageContext: this,SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==TEXT_REQUEST) {
            if(resultCode==RESULT_OK) {
                String reply=data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyTextView.setText(reply);
            }
        }
    }
}