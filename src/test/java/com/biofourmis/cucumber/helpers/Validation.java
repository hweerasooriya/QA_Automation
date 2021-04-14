// -------------------------------------------@copyright_Harshani------------------------------------
// PROJECT        : Test Automation-Biofourmis
// PRODUCT        : Sample
// VERSION        : 1.0
// REMARKS        :
// -------------------------------------------------------------------------------

package com.biofourmis.cucumber.helpers;



import java.io.File;




import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
public class Validation {
	
	public static String startUpValidation()
	{
		
		String sErrorMessage="";
		
		//File file_Feature_folder = new File(Constants.FEATURE_FILE_LOCATION);
		File file_Image_folder = new File(Constants.IMAGE_LOCATION);
		
		/*if(!file_Feature_folder.isDirectory())
		{			
			sErrorMessage="!!!!!!!CANNOT FIND THE FEATURE FILE FOLDER!!!!!!!\n";			
		}
		else if(!file_Image_folder.isDirectory())
		{
			sErrorMessage+="!!!!!!!!CANNOT FIND THE IMAGE LOCATION FILE FOLDER!!!!!!!!\n";			
		}*/
				
		
		return sErrorMessage;
	}
	
	
	/*
	 * Checks whether the Given String is Empty or Not.
	 * 
	 * @param s
	 * 
	 * @return
	 */

	public static boolean isEmpty(String str)
	{
		final String sMtdName = "isEmpty(str)";
		
		if ((str == null) || (str.trim().equals("")) || isblank(str) || (str.length() == 0) || (str.equals("null")))
		{
			return true;
		}
		return false;
	}

	/*
	 * This method checks for a blank string and returns true if everything is
	 * spac This method is only called from the isEmpty method and is a private
	 * method.
	 */

	private static boolean isblank(String s)
	{
		final String sMtdName = "isblank(s)";
		
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			if ((c != ' ') && (c != '\t') && (c != '\n'))
			{
				return false;
			}
		}
		return true;
	}
	
	
	@Then("^I call verify method$")
	public void i_call_verify_method(DataTable arg1) throws Throwable {
	    
	   
	}


}
