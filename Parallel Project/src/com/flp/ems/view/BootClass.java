package com.flp.ems.view;
import java.util.Scanner;
import com.flp.ems.view.UserInteraction;

public class BootClass {
     public static void main(String[] args) {
    	 int ch;
    	  Scanner s=new Scanner(System.in);
		// TODO Auto-generated method stub
	    System.out.println("Enter 1 to AddEmployee");
		System.out.println("Enter 2 to ModifyEmployee");
		System.out.println("Enter 3 to RemoveEmployee");
		System.out.println("Enter 4 to SearchEmployee");
		System.out.println("Enter  5 to getAllEmployee");
		System.out.println("Enter 6 to Exit");
		System.out.println("Enter your choice");
		ch=s.nextInt();
		menuSelection(ch);
  
     }	
		 static public void menuSelection(int ch)
		{	 
		do
		{	
		Scanner s=new Scanner(System.in);	
		switch(ch)
		{
		case 1: UserInteraction.AddEmployee();
		break;
		case 2: UserInteraction.ModifyEmployee();
		break;
		case 3:UserInteraction.RemoveEmployee();
		break;
		case 4:UserInteraction.SearchEmployee();
		break;
		case 5:UserInteraction.getAllEmployee();
		break;	
		default:System.out.println("Invalid Entery Plz Try Again ");
		break;
		}
		System.out.println("Enter a choice again  if you want to continue ");
		ch=s.nextInt();
		}while(ch!=6);
	}

}
