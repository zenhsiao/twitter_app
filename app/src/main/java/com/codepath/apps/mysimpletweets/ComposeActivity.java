package com.codepath.apps.mysimpletweets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.codepath.apps.mysimpletweets.R.id.ivMyPhoto;
import static com.raizlabs.android.dbflow.config.FlowManager.getContext;

public class ComposeActivity extends AppCompatActivity {

    private EditText etTwitterContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);

        etTwitterContent = (EditText) findViewById(R.id.etTweetContent);
        ImageView myPhoto = (ImageView) findViewById(ivMyPhoto);
        TextView myName = (TextView) findViewById(R.id.tvMyName);
        TextView myScreenName = (TextView) findViewById(R.id.tvMyScreenName);

        myName.setText( getIntent().getStringExtra("myName"));
        myScreenName.setText( "@"+ getIntent().getStringExtra("myScreenName"));
        String url = getIntent().getStringExtra("myPhotoUrl");
        Picasso.with(getContext()).load(url).into(myPhoto);

    }




    public void onPostTwitterAction(View v) {
        EditText etTweetContent = (EditText) findViewById(R.id.etTweetContent);
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("text", etTweetContent.getText().toString());
        data.putExtra("code", 200); // ints work too
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }

    public void onCancelAction(View v) {
        this.finish();
    }


}
