package com.hshackerz.Glass;

import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.w3c.dom.Text;

/**
 * Created on 2/7/2015.
 */
public class SendMessageButtonListener implements View.OnClickListener
{
    private MessagingActivity mainActivity;
    private EditText textField;
    private String phoneNumber;
    private EditText phoneNumberText;
    private TextView textView;

    public SendMessageButtonListener(MessagingActivity main, EditText editText, String phoneNum, TextView view)
    {
        mainActivity = main;
        textField = editText;
        phoneNumber = phoneNum;
        textView = view;
    }
    public SendMessageButtonListener(MessagingActivity main, EditText editText, EditText phoneNumText, TextView view)
    {
        mainActivity = main;
        textField = editText;
        phoneNumberText = phoneNumText;
        textView = view;
    }

    @Override
    public void onClick(View v) {
            if (textField != null && phoneNumber != null &&
                    textField.getText().toString().length() > 0 && phoneNumber.length() > 0) {
                String text = textField.getText().toString();
                sendSMS(phoneNumber, text);
                addToList(text);
            } else if (phoneNumberText != null) {
                phoneNumber = phoneNumberText.getText().toString();
                String text = textField.getText().toString();
                sendSMS(phoneNumber, text);
                addToList(text);
            }
    }

    private void addToList(String textMessage) {
        if (textMessage != null) {
            textView.append("Me" + ": " + textMessage + "\n");
            mainActivity.getHistory();
        }
    }


    private void sendSMS(String phoneNumber, String message)
    {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }
}
