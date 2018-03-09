/**
 * Main dungeon class
 */
import java.util.*;
import java.net.*;

public class Dungeon
{
	int[] dng = new int[8];
	int count = 0;
	int mcount = 3;
	int mcount2 = 5;
	int buildCnt = 0;
	
	Scanner scan = new Scanner(System.in);
	String input;
	Random rand = new Random();

	public void buildDungeon() throws Exception{
		
		System.out.println(", You've raided the dungeon but now it is time to leave!");
		System.out.println("Question is can you make it?");
		
		/**
		 * calling for the hero to be built
		 */
		Being hero = new Being(10,5,rand.nextInt(20));
		System.out.println("You are a human. Here are your stats:");
		System.out.println(hero.toString());
		System.out.println("");
		
		/**
		* The way the user moves through the dungeon
		*/
                
                DatagramSocket ds = new DatagramSocket(8000); //Creates the DatagramSocket
                
		while(dng[count] <= 7){
                    
                    byte[] b = new byte[2048];
                        DatagramPacket dp = new DatagramPacket(b,b.length);
                         ds.receive(dp);
                        byte[] packetData = dp.getData();
                        String input = new String(packetData);
			/**
			* Visual for rooms
			*/
			
			
			dngTextRoomRoof();
			
			
			System.out.println("");
			
			if(count == 0){
                            byte[] b2 = characterRoomOne().getBytes();
                        DatagramPacket dp2 = new DatagramPacket(b2,b2.length,dp.getAddress(), dp.getPort());
                        ds.send(dp2);
                        } else if(count == 1){
                            byte[] b2 = characterRoomTwo().getBytes();
                        DatagramPacket dp2 = new DatagramPacket(b2,b2.length,dp.getAddress(), dp.getPort());
                        ds.send(dp2);
                        } else if(count == 2){
                            byte[] b2 = characterRoomThree().getBytes();
                        DatagramPacket dp2 = new DatagramPacket(b2,b2.length,dp.getAddress(), dp.getPort());
                        ds.send(dp2);
                        } else if(count == 3){
                            byte[] b2 = characterRoomFour().getBytes();
                        DatagramPacket dp2 = new DatagramPacket(b2,b2.length,dp.getAddress(), dp.getPort());
                        ds.send(dp2);
                        } else if(count == 4){
                            byte[] b2 = characterRoomFive().getBytes();
                        DatagramPacket dp2 = new DatagramPacket(b2,b2.length,dp.getAddress(), dp.getPort());
                        ds.send(dp2);
                        } else if(count == 5){
                            byte[] b2 = characterRoomSix().getBytes();
                        DatagramPacket dp2 = new DatagramPacket(b2,b2.length,dp.getAddress(), dp.getPort());
                        ds.send(dp2);
                        } else if(count == 6){
                            byte[] b2 = characterRoomSeven().getBytes();
                        DatagramPacket dp2 = new DatagramPacket(b2,b2.length,dp.getAddress(), dp.getPort());
                        ds.send(dp2);
                        } else if(count == 7){
                            byte[] b2 = characterRoomEight().getBytes();
                        DatagramPacket dp2 = new DatagramPacket(b2,b2.length,dp.getAddress(), dp.getPort());
                        ds.send(dp2);;
                        }
			System.out.println("");
			
			dngTextRoomFloor();
			
			System.out.println("");
			
			/**
			 * win condition
			 */
			if(count == 7) {
				System.out.println("You have made it to the end of the dungeon!");
				System.out.println("Game Over! You Win!");
				return;
			}
			
			/**
			* Directions for the player
			*/
			if(count == 0)
			{
				System.out.println("You can only go right from this point");
				System.out.println("Press R to go right.");
			}else{
				System.out.println("Type L to go left or R to go right");
			}
                        
                       /* byte[] b = new byte[2048];
                        DatagramPacket dp = new DatagramPacket(b,b.length);
                        */
                    //    ds.receive(dp);
                        /*
                        byte[] packetData = dp.getData();
                        String input = new String(packetData);
                            
			//input = scan.nextLine();*/
			if(input.trim().equalsIgnoreCase("L") && count == 0){
				count = 0;
			}else if(input.trim().equalsIgnoreCase("L")) {
				count--;
			}else if(input.trim().equalsIgnoreCase("R")){
				count++;
			} 
                        
                            
			/**
			* Finding a monster
			*/
			if(count == mcount || count == mcount2){
				System.out.println("You have found a monster!");
				Being monster = new Being(3,3,rand.nextInt(20));
				
				while(monster.getHP() > 0 && hero.getHP() > 0) {
					if(monster.getInitiative() > hero.getInitiative()) {
						System.out.println("The monster has gone first!");
						hero.setHP(monster.getAtk());
						System.out.println("The monster has done " + monster.getAtk() + " dmg to you!");
					}else {
						System.out.println("You have gone first!");
						monster.setHP(hero.getAtk());
						System.out.println("You have done " + hero.getAtk() + " dmg to the monster!");
					}
				}
				
				if(monster.getHP() <= 0) {
					System.out.println("You have slain the monster!");
				} else {
					System.out.println("You've Died!");
					return;
				}
			}
		}
	}

	/**
	* Base Room roof
	*/
	public static void dngTextRoomRoof(){
		System.out.print(" ___  ___  ___  ___  ___  ___  ___  ___ ");
	}
	/**
	* Room that tells where the player is
	*/
	public String characterRoomOne(){
		return "| C ||   ||   ||   ||   ||   ||   ||   |";
	}
	public String characterRoomTwo(){
		return "|   || C ||   ||   ||   ||   ||   ||   |";
	}
        public String characterRoomThree(){
		return "|   ||   || C ||   ||   ||   ||   ||   |";
	}
        public String characterRoomFour(){
		return "|   ||   ||   || C ||   ||   ||   ||   |";
	}
        public String characterRoomFive(){
		return "|   ||   ||   ||   || C ||   ||   ||   |";
	}
        public String characterRoomSix(){
		return "|   ||   ||   ||   ||   || C ||   ||   |";
	}
        public String characterRoomSeven(){
		return "|   ||   ||   ||   ||   ||   || C ||   |";
	}
        public String characterRoomEight(){
		return "|   ||   ||   ||   ||   ||   ||   || C |";
	}
	/**
	 * floor
	 */
	public static void dngTextRoomFloor(){
		System.out.print(" ~~~  ~~~  ~~~  ~~~  ~~~  ~~~  ~~~  ~~~ ");
	}
}
