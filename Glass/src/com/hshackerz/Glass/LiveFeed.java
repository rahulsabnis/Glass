//package com.hshackerz.Glass;
//
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.core.MatOfRect;
//import org.opencv.core.Point;
//import org.opencv.core.Rect;
//import org.opencv.core.Scalar;
//import org.opencv.core.Size;
//import org.opencv.highgui.VideoCapture;
//import org.opencv.imgproc.Imgproc;
//import org.opencv.objdetect.CascadeClassifier;
//import org.opencv.utils.Converters;
//import android.graphics.Bitmap;
//import android.graphics.Bitmap.Config;
////change
//
////OpenCV
//import org.opencv.utils.*;
//import org.opencv.core.CvType;
//import org.opencv.core.Mat;
//import org.opencv.core.Scalar;
//import org.opencv.imgproc.Imgproc;
//
//public class LiveFeed
//{
//    static Mat frame;
//    public static void main(String[] args) {
//
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//        System.out.println("\nRunning FaceDetector");
////        window = new JFrame();
////        window.setDefaultCloseOperation( EXIT_ON_CLOSE );
//        VideoCapture camera = new VideoCapture(0);
//        try
//        {
//            Thread.sleep( 1000 );
//        }
//        catch ( InterruptedException e )
//        {
//            e.printStackTrace();
//        }
//        camera.open(0); //Useless
//        if(!camera.isOpened()){
//            System.out.println("Camera Error");
//        }
//        else{
//            System.out.println("Camera OK?");
//        }
//
//        frame = new Mat();
//        camera.read( frame );
////        Utils.bitmapToMat(bmp, tmp);
////        window.setSize( Mat2BufferedImage(frame).getWidth(), Mat2BufferedImage(frame).getHeight() );
////        window.add( label );
////        window.setVisible( true );
//
//        while(true)
//        {
//            camera.read( frame );
//
//            String filename = "ouput.jpg";
//            //System.out.println( String.format( "Writing %s", filename ) );
//            // Highgui.imwrite(filename, frame);
////            display = new ImageIcon(Mat2BufferedImage( frame ));
////            label.setIcon( display );
////            window.revalidate();
////            window.repaint();
//        }
//    }
//
////    public static BufferedImage Mat2BufferedImage(Mat m){
////        // source: http://answers.opencv.org/question/10344/opencv-java-load-image-to-gui/
////        int type = BufferedImage.TYPE_BYTE_GRAY;
////        if ( m.channels() > 1 ) {
////            type = BufferedImage.TYPE_3BYTE_BGR;
////        }
////        int bufferSize = m.channels()*m.cols()*m.rows();
////        byte [] b = new byte[bufferSize];
////        m.get(0,0,b); // get all the pixels
////        BufferedImage image = new BufferedImage(m.cols(),m.rows(), type);
////        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
////        System.arraycopy(b, 0, targetPixels, 0, b.length);
////        return image;
////    }
//}