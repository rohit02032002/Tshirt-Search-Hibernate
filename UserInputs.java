package com.rohit.tshirt_search;

import java.util.Scanner;

public class UserInputs {

	
	public void takeInputs()
	{
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Color of T-shirt : ");
        String color = sc.nextLine().toUpperCase();

        System.out.print("Enter Your Gender : ");
        String gender = sc.next().toUpperCase();

        System.out.print("Enter the Size : ");
        String size = sc.next().toUpperCase();

        System.out.print("Press 1 To Sort By Price\n"+"Press 2 To Sort By Rating\n"+"Enter Your Choice : ");
        int preference = sc.nextInt();
        System.out.println();
        
        sc.close();
        
        FetchData data=new FetchData();
        data.createQueryAndFetch(color, gender, size, preference);
	}
}
