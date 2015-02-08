package com.hshackerz.Glass;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;
import java.util.ArrayList;

/**
 * Created by sandeepr on 2/7/15.
 */
public class TextReceiver extends BroadcastReceiver {

    static ArrayList<Toast> toastArrayList =  new ArrayList<Toast>();
    public void onReceive(Context context, Intent intent) {
        //---get the SMS message passed in---
        Bundle bundle = intent.getExtras();

        SmsMessage[] msgs = null;
        String str = "";
        if (bundle != null) {
            //---retrieve the SMS message received---
            Object[] pdus = (Object[]) bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];
            for (int i = 0; i < msgs.length; i++) {
                msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                str += msgs[i].getMessageBody().toString();
                str += "\n";
            }
            for (SmsMessage msg : msgs) {

                String s = "\nFrom: " + msg.getOriginatingAddress() + "\n" +
                        "Message: " + msg.getMessageBody() + "\n";


            }
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
            Intent broadcastIntent = new Intent();
            broadcastIntent.setAction("SMS_RECEIVED_ACTION");
            broadcastIntent.putExtra("sms", str);
            context.sendBroadcast(broadcastIntent);
        }
    }
}
