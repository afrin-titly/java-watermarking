package java_watermarking;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Main {

   public static void main( String[] args ){
   
      try{
    	 
         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
         Mat inputImage = Imgcodecs.imread("bliss.jpg",  Imgcodecs.CV_LOAD_IMAGE_COLOR);
         Imgproc.putText(inputImage, "titlyexplained.com", new Point(inputImage.rows()/2,inputImage.cols()/2), Core.FONT_ITALIC,new Double(1),new  Scalar(0,255,255));
         Imgcodecs.imwrite("watermarked.jpg", inputImage);
         Mat destination = Imgcodecs.imread("watermarked.jpg",  Imgcodecs.CV_LOAD_IMAGE_COLOR);
      } catch (Exception e) {
         System.out.println("Error: "+e.getMessage()); 
      }
   }
}