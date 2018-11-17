//Name: Cynthia Mo
//UFL ID: 04938124
//Section: 2296
//Project Number: 1
//Brief description of file contents: Capture Calculator

import java.lang.Math;    //import math library to use its functions
import java.util.Scanner; //import Scanner library to use its functions

public class CaptureCalculator 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in); 
		System.out.println("Hello and welcome to the Monster Capture Possibility Calculator.");
		System.out.println("Please enter the latitude of the monster (1-10) : ");
		/*We are entering the distance in km because the map is in km. We will convert to m later 
		to do other calculations with distance (d)*/
		int monsterLatitude = input.nextInt();
		
		System.out.println("Please enter the longitude of the monster (1-10) : ");
		//We will convert the longitude to meters (m) also
		int monsterLongitude = input.nextInt();
		
		System.out.println("Please enter the time of the monster appear (1-1440) : ");
		int monsterAppear = input.nextInt();
		
		System.out.println("Please enter the possible time of the monster will exist (10-59) : ");
		int monsterExist = input.nextInt();
		
		System.out.println("Please enter the player's ID (8 digits) : ");
		int playerId = input.nextInt();
		
		System.out.println("Please enter the time of the player noticing monster (1-1440 and greater than the time the monster appears) : ");
		int noticeTime = input.nextInt();
		
		System.out.println("Please enter the latitude of the player (1-10) : ");
		int playerLatitude = input.nextInt();
		//We will convert the latitude to meters (m) also
		
		System.out.println("Please enter the longitude of the player (1-10) : ");
		int playerLongitude = input.nextInt();
		//We will convert the longitude to meters (m) also
		
		System.out.println("Please enter the player's walking speed (10-200) :");
		int playerSpeed = input.nextInt(); 
		
		//Calculate if the player is on the lucky or unlucky list based on their player ID
		boolean lucky = false;  //defining boolean variable called lucky that will be used later in my if and else if statements
		boolean normal = false; //defining boolean variable called normal that will be used later in my if and else if statements
		if ((playerId % 100 >= 00) && (playerId % 100 <= 49))  //we modulus the player ID by 100 because the remainder will be the last 2 digits of the ID
		{
			System.out.println("Player " + playerId + " who is on the lucky list,");
			lucky = true; //the lucky boolean variable is true if the player is on the lucky list 
		}
		else 
		{
			System.out.println("Player " + playerId + " who is on the normal list,");
			normal = true; //the normal boolean variable is true if the player is on the normal list
		}
		
		System.out.println("noticed the monster at time " + noticeTime + ",");
		
		//Calculate the distance between monster and person
		//distance formula is the square root of (x2+x1)^2 + (y2-y1)^2
		//x2 and x1 are the latitudes of the monster and person, respectively
		//y2 and y1 are the longitudes of the monster and person, respectively
		//use Math.pow(a, b) to do exponent operations. a is the term and b is the power 
		//made distance double, not int, because distance or speed has to be a double to get the most accurate result
		double distance = (Math.pow(Math.pow(monsterLatitude - playerLatitude, 2) + Math.pow(monsterLongitude - playerLongitude, 2), .5) * 1000); 
		double roundeddistance = Math.round(distance * 10)/10.0; //we round to include one digit after the decimal point

		System.out.println("is " + roundeddistance + " m away from the monster,");
		
		double playerArrival = noticeTime + (distance/playerSpeed); //calculate the player arrival
		double roundedplayerArrival = Math.round(playerArrival * 10)/10.0; //we round to include one digit after the decimal point
		System.out.println("and will arrive at time " + roundedplayerArrival + ".");
		
		int monsterDisappear = monsterAppear + monsterExist; //calculate the monster disappearance time
		System.out.println("The monster's disappear time is about " + monsterDisappear + ".");
	
		double percent = ((playerArrival - monsterDisappear)/monsterExist); //percent is the monster's disappear probability 
			//this will return a percent in the form of a decimal
		
		//
		if (playerArrival <= monsterDisappear)
		{
			System.out.println("So the player will capture this monster with definitely possibility.");
		}
		
		else if (playerArrival > monsterDisappear) 
		{
			if (lucky && (percent >= 0) && (percent <= .1))
			{
				System.out.println("So the player will capture this monster with highly likely possibility.");
			}
			
			else if (normal && (percent >= 0) && (percent <= .05))
			{
				System.out.println("So the player will capture this monster with highly likely possibility.");
			}
	
			else if (lucky && (percent >= .1) && (percent <= .3))
			{
				System.out.println("So the player will capture this monster with likely possibility.");
			}
			
			else if (normal && (percent >= 0.05) && (percent <= 0.2))
			{
				System.out.println("So the player will capture this monster with likely possibility.");
			}

			else if (lucky && (percent >= .3) && (percent <= .4))
			{
				System.out.println("So the player will capture this monster with unsure possibility.");
			}
			
			else if (normal && (percent >= .2) && (percent <= .35))
			{
				System.out.println("So the player will capture this monster with unsure possibility.");
			}

			else if (lucky  && (percent >= .4) && (percent <= .5))
			{
				System.out.println("So the player will capture this monster with unlikely possibility.");
			}
			
			else if (normal && (percent >= .35) && (percent <= .4))
			{
				System.out.println("So the player will capture this monster with unlikely possibility.");
			}
			else if (lucky && (percent > .5))
			{
				System.out.println("So the player will capture this monster with highly unlikely possibility.");
			}
			
			else if (normal && (percent > .4))
			{
				System.out.println("So the player will capture this monster with highly unlikely possibility.");
			}
		input.close();
		}
	}
}
