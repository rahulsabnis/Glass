//package com.hshackerz.Glass;
//
//import android.content.Context;
//import android.graphics.Camera;
//import android.view.SurfaceHolder;
//import android.view.SurfaceView;
//import android.view.ViewGroup;
//
//import java.util.List;
//
///**
// * Created by Family on 2/7/2015.
// */
//public class PicturePreview extends ViewGroup implements SurfaceHolder.Callback {
//    SurfaceView mSurfaceView;
//    SurfaceHolder mHolder;
//
//    PicturePreview(Context context) {
//        super(context);
//
//        mSurfaceView = new SurfaceView(context);
//        addView(mSurfaceView);
//
//        // Install a SurfaceHolder.Callback so we get notified when the
//        // underlying surface is created and destroyed.
//        mHolder = mSurfaceView.getHolder();
//        mHolder.addCallback(this);
//        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
//    }
//
//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//
//    }
//
//    public void setCamera(Camera camera) {
//            if (mCamera == camera) { return; }
//
//            stopPreviewAndFreeCamera();
//
//            mCamera = camera;
//
//            if (mCamera != null) {
//                List<android.hardware.Camera.Size> localSizes = mCamera.getParameters().getSupportedPreviewSizes();
//                mSupportedPreviewSizes = localSizes;
//                requestLayout();
//
//                try {
//                    mCamera.setPreviewDisplay(mHolder);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                // Important: Call startPreview() to start updating the preview
//                // surface. Preview must be started before you can take a picture.
//                mCamera.startPreview();
//                Camera.takePicture();
//            }
//    private void stopPreviewAndFreeCamera() {
//
//        if (mCamera != null) {
//            // Call stopPreview() to stop updating the preview surface.
//            mCamera.stopPreview();
//
//            // Important: Call release() to release the camera for use by other
//            // applications. Applications should release the camera immediately
//            // during onPause() and re-open() it during onResume()).
//            mCamera.release();
//
//            mCamera = null;
//        }
//        }
//
//    @Override
//    public void surfaceCreated(SurfaceHolder holder) {
//
//    }
//
//    @Override
//    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//
//    }
//
//    @Override
//    public void surfaceDestroyed(SurfaceHolder holder) {
//
//    }
//}
//}
