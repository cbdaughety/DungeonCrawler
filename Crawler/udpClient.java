import java.io.*;

import java.net.*; 

import java.util.*;

 

  class udpClient 

 { 

 	public static void main(String[] args) throws Exception 

 	{ 

 		Scanner scan = new Scanner(System.in);

 		

 		InetAddress ip = InetAddress.getByName("localhost");  //uses IPv4 Address

 		

 		DatagramSocket ds = new DatagramSocket(8001); 

 		

 		

 		Random rand = new Random();

 		String input;

 		String name;

 		int count = 0;

 		int mcount = 3;

 		int mcount2 = 5;

 		

 		//This top section before the while loop gets the users name and tells them the game intro and their starting location

 		System.out.println("What is your characters name?");

		name = scan.nextLine();

		

		System.out.println(name +", you've raided the dungeon and its time to leave! The question is, can you escape?");

		

		

		System.out.println("The exit is only 8 rooms away, but there are monsters hiding in some of them!");

		System.out.println(" ___  ___  ___  ___  ___  ___  ___  ___");

		System.out.println("| C ||   ||   ||   ||   ||   ||   ||   |");

		System.out.println(" ~~~  ~~~  ~~~  ~~~  ~~~  ~~~  ~~~  ~~~");

 		

 		while(count != 7)

 		{

 			

 			if(count == 0) //This if statement gets the users input

			{

				System.out.println("You can only go right from this point. Press R to go right.");

				input = scan.next();

			}

 			else

			{

				System.out.println("Type L to go left or R to go right");

				input = scan.next();

			}

 			

 			if(input.trim().equalsIgnoreCase("L") && count == 0){ //Increments count based on use input to find map location

				count = 0;

			}else if(input.trim().equalsIgnoreCase("L")) {

				count--;

			}else if(input.trim().equalsIgnoreCase("R")){

				count++;

			} 

 				

 				byte [] b = input.getBytes();  //Creates a byte using the users input to be sent in a packet

 				DatagramPacket dp = new DatagramPacket(b,b.length,ip,8000); // Creates the packet

 				ds.send(dp);  		//Sends the packet

 				

 				byte [] b2 = new byte[2048];

 				DatagramPacket dp2 = new DatagramPacket(b2,b2.length); //Receives string for map data

 				ds.receive(dp2);

 				

 				byte[] roofb = new byte[2048];

 				DatagramPacket roofp = new DatagramPacket(roofb,roofb.length); //Receives string for the roof

 				ds.receive(roofp);

 				

 				byte[] floorb = new byte[2048];

 				DatagramPacket floorp = new DatagramPacket(floorb,floorb.length); //Receives string for the floor

 				ds.receive(floorp);

 				

 				String map = new String(b2);

 				String roof = new String(roofb);

 				String floor = new String(floorb);

 				

 				System.out.println(roof); //Prints the dungeon roof

 				System.out.println(map); //Prints the dungeon rooms

 				System.out.println(floor); //Prints the dungeon floor

 				

 				if(count == mcount || count == mcount2) //Receives and prints the packets for finding and fighting a monster

 				{

 					byte[] b3 = new byte[2048];

 					DatagramPacket dp3 = new DatagramPacket(b3,b3.length);

 					ds.receive(dp3);

 					String monsterMessage = new String(b3);

 					System.out.println(monsterMessage); 

 					

 					byte [] b4 = new byte[2048]; //This packet tells you if you have killed the monster or died

	 					DatagramPacket dp4 = new DatagramPacket(b4,b4.length);

	 					ds.receive(dp4);

	 					String fate = new String(b4);

						System.out.println(fate);

 				}

 				

 				if (count == 7)

 	 			{

 	 				byte[] win = new byte[2048]; //This packet will print out the string explaining that you ahve won the game

 	 				DatagramPacket winp = new DatagramPacket(win,win.length);

 	 				ds.receive(winp);

 	 				String winMessage = new String(win);

 	 				System.out.println(winMessage);

 	 			}

 		}

 		}

 	    }
