package com.flp.ems.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validate
{
	//dd/mm/yyyy date format
    private static Pattern dateFrmtPtrn=Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)");
	public static boolean validateDateFormat(String userName)
	{
	    Matcher mtch = dateFrmtPtrn.matcher(userName);
	     if(mtch.matches())
	     {
	            return true;
	      }
	     else
	     {
	    System.out.println("INVALID DATE");	 
	      return false;
	     }
	 }
	//to validate email_id
   private static Pattern emailNamePtrn = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
   public static boolean validateEmailAddress(String userName)
   {
      Matcher mtch = emailNamePtrn.matcher(userName);
      if(mtch.matches())
       {
	       return true;
	   }
      else
      {
      System.out.println("INVALID EMAILID"); 
	 return false;}
	}
   // to validate phone_no
	public static boolean validatePhoneNo(long phno)
	{
		String myString = Long.toString(phno);
		if(myString.length()==10)
			return true;
		else 
		{
			System.out.println("Invalid phoneno");
			return false;
		}	
	}
	// t
	public static boolean validateName(String Name)
	{
     if (Name.length()>0)
    	 return true;
     else 
     {
    	System.out.println("invalid names");
    	 return false;
     }	 
    }
	}
