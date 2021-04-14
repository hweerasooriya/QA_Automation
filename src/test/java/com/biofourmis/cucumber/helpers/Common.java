package com.biofourmis.cucumber.helpers;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
//import atu.testrecorder.ATUTestRecorder;
//import atu.testrecorder.exceptions.ATUTestRecorderException;
import cucumber.api.java.it.Date;


/*import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.monte.media.Format;
import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;*/

public class Common {
	
	
	private WebDriverInitializer webDriverInitializer=null;
    WebDriver webDriver;
//    DataPasser dp=new DataPasser();
    //ATUTestRecorder recorder;
    //public static ScreenRecorder screenRecorder;
    
    public Common (WebDriverInitializer webDriverInitializer) {	     
    	this.webDriverInitializer = webDriverInitializer; 
	   	webDriver=webDriverInitializer.getDriver();	 
    }
	
	
	public void navigate_To_Application_Menu()
	{
		
		//Navigate to the Application Menu
   		try {
			
   			JavascriptExecutor jse = (JavascriptExecutor)webDriver;
	   		jse.executeScript("scrollTo(0,-450)", "");
	   		System.out.println("AAAAAAAAAA  Scrolled up......");
	   		
	   	 WebElement element = webDriver.findElement(By.id("showLeftPush"));
	      Actions action = new Actions(webDriver);
	      action.moveToElement(element).build().perform();
	      element.click();
	      Thread.sleep(3000);
	      WebElement element2 = webDriver.findElement(By.xpath("//a[contains(text(),'Applications Menu')]"));
	      action.moveToElement(element2).build().perform();
	      element2.click();
   			
		} catch (Exception e) {
			 System.out.println(e.getMessage());
		      
		      
			
		}
   		
	}
   		
   		public void screen_record_start() throws Exception {
   	      
   	      
   		  
           // DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
           // Date date = new Date();
            //Created object of ATUTestRecorder
            //Provide path to store videos and file name format.
         //recorder = new ATUTestRecorder("D:\\ScriptVideos\\","TestVideo-",false);
            //To start video recording.
      //recorder.start();  
        

        
        
        
    }
    
    
   
 
    
    
    
   // public void stop_Screen_recorder() throws ATUTestRecorderException
    {

        //To Stop Video Recording
      //  recorder.stop();
    }
  


    
    public static void setUp() throws IOException, AWTException {

        
    }
    
   		
    public void StopScreen() throws IOException {
        
    }
    
   		
		
    
    
    
    
    
    
    
    @Given("^I Start the screen recording$")
    public void i_Start_the_screen_recording(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
    	
    	List Userdata = (List) arg1.raw();
    		//List<List<String>> Userdata = table.raw();
    	
    	String fileName=Userdata.getItem(1);
    	
    	
/*
        //Create a instance of GraphicsConfiguration to get the Graphics configuration
        //of the Screen. This is needed for ScreenRecorder class.
        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        //Create a instance of ScreenRecorder with the required configurations
        screenRecorder = new ScreenRecorder(gc,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, (int)24, FrameRateKey, Rational.valueOf(15),
                        QualityKey, 1.0f,
                        KeyFrameIntervalKey, (int) (15 * 60)),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,"black",
                        FrameRateKey, Rational.valueOf(30)),
                null);
        
        
        screenRecorder.start();*/
    	
    	
    	
    	// DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
        // Date date = new Date();
         //Created object of ATUTestRecorder
         //Provide path to store videos and file name format.
     // recorder = new ATUTestRecorder("D:\\ScriptVideos\\",fileName,false);
         //To start video recording.
      //recorder.start();  
     
    	
    	
    }

    @Then("^I Stop Screen Recording$")
    public void i_Stop_Screen_Recording() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	
    	/*
    	screenRecorder.stop();
        ArrayList<File> createdMovieFiles = (ArrayList<File>) screenRecorder.getCreatedMovieFiles();
        for(File movie : createdMovieFiles){
            System.out.println("New movie created: " + movie.getAbsolutePath());*/
    	
    	
    	//recorder.stop();
        }


	public boolean is_file_downloaded(String fileName) {
		
		
		String downloadPath=System.getProperty("user.dir")+ File.separator + "externalFiles" + File.separator + "downloadFiles";
		
		
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
		System.out.println(fileName);
	    boolean file_found=false;
	    
	    for (int i = 0; i < dir_contents.length; i++) {
	    	
	    	System.out.println(dir_contents[i].getName());
	       
	    	
	    	
	    	if(dir_contents[i].getName().equals(fileName)) {
	    		file_found=true;
	    		break;
	    		
	    	}
	    	
	            
	    		
	            }

	    
		return file_found;
		
		
		
	}
        
    }

    
    
    
    
    
		
	
	
	
	
	
	


