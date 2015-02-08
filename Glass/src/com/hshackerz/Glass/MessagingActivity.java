package com.hshackerz.Glass;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Camera;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Display;
import android.widget.*;
import org.w3c.dom.Text;

public class MessagingActivity extends Activity {
    static final int REQUEST_VIDEO_CAPTURE = 1;
    Camera camera;
    private String phoneNumber;
    private String name;
    private EditText phoneText;
    Button sendMessageButton;
    SendMessageButtonListener listener;
    EditText editText;
    TextView convo;

    IntentFilter intentFilter;
    private BroadcastReceiver intentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            TextView conversation = (TextView)findViewById(R.id.textView2);
            if (name != null) {
                conversation.setText(conversation.getText() + name + ": " + intent.getExtras().getString("sms"));
            }
            else if (phoneNumber != null)
            {
                conversation.setText(conversation.getText() + phoneNumber + ": " + intent.getExtras().getString("sms"));
            }
        }
    };
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            phoneNumber = extras.getString("phone number");
            name = extras.getString("name");

            //Initialize Variables
            sendMessageButton = (Button) findViewById(R.id.button);
            editText = (EditText) findViewById(R.id.editText);
            convo = (TextView)findViewById(R.id.textView2);
            listener = new SendMessageButtonListener(this, editText, phoneNumber, convo);
            setTitle(name);
        }
        else {
            setContentView(R.layout.newcontactmain);
            phoneText = (EditText) findViewById(R.id.editText2);
            sendMessageButton = (Button) findViewById(R.id.button);
            editText = (EditText) findViewById(R.id.editText);
            convo = (TextView)findViewById(R.id.textView);
            listener = new SendMessageButtonListener(this, editText, phoneText, convo);
            setTitle("Glass App");
        }
        intentFilter = new IntentFilter();
        intentFilter.addAction("SMS_RECEIVED_ACTION");

        camera = new Camera();

        //Sets button listener
        sendMessageButton.setOnClickListener(listener);
//        sendTakeVideoIntent();
    }
    protected void onResume()
    {
        registerReceiver(intentReceiver, intentFilter);
        super.onResume();
    }
    protected void onPause()
    {
        unregisterReceiver(intentReceiver);
        super.onPause();
    }

    public String getName()
    {
        return name;
    }
//        public void onBackPressed()
//    {
//        backButtonHelper();
//        return;
//    }
//
//    public void backButtonHelper()
//    {
//        Intent intent = new Intent(this, HomeActivity.class);
//        startActivity(intent);
//    }
//
//    protected void onActivityResult(int requestCode, int result, Intent data)
//    {
//        if(requestCode == REQUEST_VIDEO_CAPTURE && result == RESULT_OK)
//        {
//            Uri videoUri = data.getData();
//            VideoView videoView = (VideoView)findViewById(R.id.videoView);
//            videoView.setVideoURI(videoUri);
//        }
//    }
//    private void sendTakeVideoIntent()
//    {
//        Intent takeVideo = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
//        if(takeVideo.resolveActivity(getPackageManager()) != null)
//        {
//            startActivityForResult(takeVideo, REQUEST_VIDEO_CAPTURE);
//        }
//    }
}
