//package com.hshackerz.Glass;
//
//import android.content.Intent;
//import android.hardware.Camera;
//import android.media.Image;
//import android.provider.MediaStore;
//import android.util.Log;
//import android.view.View;
//import android.widget.EditText;
//
///**
// * Created by Family on 2/7/2015.
// */
//public class TakePictureButtonListener implements View.OnClickListener
//{
//    private MessagingActivity mainActivity;
//    private EditText textField;
//    private EditText phoneNumber;
//    private Image pic;
//    public TakePictureButtonListener(MessagingActivity main, EditText phoneNum)
//    {
//        mainActivity = main;
//        phoneNumber = phoneNum;
//    }
//
//    private boolean safeCameraOpen(int id) {
//        boolean qOpened = false;
//
//        try {
//
//            Camera mCamera = Camera.open(id);
//            qOpened = (mCamera != null);
//        } catch (Exception e) {
//            Log.e(getString(R.string.app_name), "failed to open Camera");
//            e.printStackTrace();
//        }
//        return qOpened;
//    }
//
//    private void releaseCameraAndPreview() {
//        mPreview.setCamera(null);
//        if (mCamera != null) {
//            mCamera.release();
//            mCamera = null;
//        }
//    }
//
//    @Override
//    public void onClick(View v) {
//        if(phoneNumber.toString().length() > 0)
//        {
//            sendPic(phoneNumber.getText().toString(), pic);
//        }
//    }
//
//    static final int REQUEST_IMAGE_CAPTURE = 1;
//
//    private void dispatchTakePictureIntent() {
//        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        if (takePictureIntent.resolveActivity(mainActivity.getPackageManager()) != null) {
//            mainActivity.startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//        }
//    }
//}
