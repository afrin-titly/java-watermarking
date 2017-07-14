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
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageWatermark {
	
	public static void main( String[] args ){
		   
	      try{
	         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	         Mat inputImage = Imgcodecs.imread("bliss.jpg",  Imgcodecs.CV_LOAD_IMAGE_COLOR);
	         Mat waterMark = Imgcodecs.imread("LogoWaterMark.jpg",  Imgcodecs.CV_LOAD_IMAGE_COLOR);
	         Rect rectangle = new Rect(waterMark.rows() * 4,waterMark.cols(),  waterMark.cols(),waterMark.rows());
	         Core.addWeighted(inputImage.submat(rectangle), 0.8, waterMark, 0.2, 1,  inputImage.submat(rectangle));
	         Imgcodecs.imwrite("watermarkedImage.jpg", inputImage);
	         Mat destination = Imgcodecs.imread("watermarkedImage.jpg",  Imgcodecs.CV_LOAD_IMAGE_COLOR);
	         
	      } catch (Exception e) {
	         System.out.println("Error: " + e.getMessage());
	      }
	}
}
