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
		DatagramSocket ds = new DatagramSocket(8000);
		
		/**
		 * calling for the hero to be built
		
		*/
		Being hero = new Being(10,5,rand.nextInt(20));
                
		while(dng[count] <= 7){
                    
                    byte[] b = new byte[2048];	//Receives the input from the client
                        DatagramPacket dp = new DatagramPacket(b,b.length);
                         ds.receive(dp);
                        byte[] packetData = dp.getData();
                        String input = new String(packetData);
                        
                        if(input.trim().equalsIgnoreCase("L") && count == 0){ //Uses the input from client to measure count
            				count = 0;
            			}else if(input.trim().equalsIgnoreCase("L")) {
            				count--;
            			}else if(input.trim().equalsIgnoreCase("R")){
            				count++;
            			} 
			/**
			* Visual for rooms
			*/
                        
                        //This if statement uses the count to decide which map data packet to send to the client to be printed 
			if(count == 0){
				//Room one
                            byte[] b2 = characterRoomOne().getBytes();
                        DatagramPacket dp2 = new DatagramPacket(b2,b2.length,dp.getAddress(), dp.getPort());
                        ds.send(dp2);
                        byte[] roofb = dngTextRoomRoof().getBytes();
                        DatagramPacket roofp = new DatagramPacket(roofb,roofb.length,dp.getAddress(),dp.getPort());
                        ds.send(roofp);
                        byte[] floorb = dngTextRoomFloor().getBytes();
                        DatagramPacket floorp = new DatagramPacket(floorb,floorb.length,dp.getAddress(),dp.getPort());
                        ds.send(floorp);
                        
                        } else if(count == 1){
                        	//Room two
                            byte[] b2 = characterRoomTwo().getBytes();
                        DatagramPacket dp2 = new DatagramPacket(b2,b2.length,dp.getAddress(), dp.getPort());
                        ds.send(dp2);
                        byte[] roofb = dngTextRoomRoof().getBytes();
                        DatagramPacket roofp = new DatagramPacket(roofb,roofb.length,dp.getAddress(),dp.getPort());
                        ds.send(roofp);
                        byte[] floorb = dngTextRoomFloor().getBytes();
                        DatagramPacket floorp = new DatagramPacket(floorb,floorb.length,dp.getAddress(),dp.getPort());
                        ds.send(floorp);
                        
                        } else if(count == 2){
                        	//Room three
                            byte[] b2 = characterRoomThree().getBytes();
                        DatagramPacket dp2 = new DatagramPacket(b2,b2.length,dp.getAddress(), dp.getPort());
                        ds.send(dp2);
                        byte[] roofb = dngTextRoomRoof().getBytes();
                        DatagramPacket roofp = new DatagramPacket(roofb,roofb.length,dp.getAddress(),dp.getPort());
                        ds.send(roofp);
                        byte[] floorb = dngTextRoomFloor().getBytes();
                        DatagramPacket floorp = new DatagramPacket(floorb,floorb.length,dp.getAddress(),dp.getPort());
                        ds.send(floorp);
                        
                        } else if(count == 3){
                        //Room four	
                            byte[] b2 = characterRoomFour().getBytes();
                        DatagramPacket dp2 = new DatagramPacket(b2,b2.length,dp.getAddress(), dp.getPort());
                        ds.send(dp2);
                        byte[] roofb = dngTextRoomRoof().getBytes();
                        DatagramPacket roofp = new DatagramPacket(roofb,roofb.length,dp.getAddress(),dp.getPort());
                        ds.send(roofp);
                        byte[] floorb = dngTextRoomFloor().getBytes();
                        DatagramPacket floorp = new DatagramPacket(floorb,floorb.length,dp.getAddress(),dp.getPort());
                        ds.send(floorp);
                        
                        } else if(count == 4){
                        //Room five	
                            byte[] b2 = characterRoomFive().getBytes();
                        DatagramPacket dp2 = new DatagramPacket(b2,b2.length,dp.getAddress(), dp.getPort());
                        ds.send(dp2);
                        byte[] roofb = dngTextRoomRoof().getBytes();
                        DatagramPacket roofp = new DatagramPacket(roofb,roofb.length,dp.getAddress(),dp.getPort());
                        ds.send(roofp);
                        byte[] floorb = dngTextRoomFloor().getBytes();
                        DatagramPacket floorp = new DatagramPacket(floorb,floorb.length,dp.getAddress(),dp.getPort());
                        ds.send(floorp);
                        
                        } else if(count == 5){
                        //Room six	
                            byte[] b2 = characterRoomSix().getBytes();
                        DatagramPacket dp2 = new DatagramPacket(b2,b2.length,dp.getAddress(), dp.getPort());
                        ds.send(dp2);
                        byte[] roofb = dngTextRoomRoof().getBytes();
                        DatagramPacket roofp = new DatagramPacket(roofb,roofb.length,dp.getAddress(),dp.getPort());
                        ds.send(roofp);
                        byte[] floorb = dngTextRoomFloor().getBytes();
                        DatagramPacket floorp = new DatagramPacket(floorb,floorb.length,dp.getAddress(),dp.getPort());
                        ds.send(floorp);
                        
                        } else if(count == 6){
                        	//Room seven
                            byte[] b2 = characterRoomSeven().getBytes();
                        DatagramPacket dp2 = new DatagramPacket(b2,b2.length,dp.getAddress(), dp.getPort());
                        ds.send(dp2);
                        byte[] roofb = dngTextRoomRoof().getBytes();
                        DatagramPacket roofp = new DatagramPacket(roofb,roofb.length,dp.getAddress(),dp.getPort());
                        ds.send(roofp);
                        byte[] floorb = dngTextRoomFloor().getBytes();
                        DatagramPacket floorp = new DatagramPacket(floorb,floorb.length,dp.getAddress(),dp.getPort());
                        ds.send(floorp);
                        
                        } else if(count == 7){
                        //Room eight(final room)	
                            byte[] b2 = characterRoomEight().getBytes();
                        DatagramPacket dp2 = new DatagramPacket(b2,b2.length,dp.getAddress(), dp.getPort());
                        ds.send(dp2);;
                        byte[] roofb = dngTextRoomRoof().getBytes();
                        DatagramPacket roofp = new DatagramPacket(roofb,roofb.length,dp.getAddress(),dp.getPort());
                        ds.send(roofp);
                        byte[] floorb = dngTextRoomFloor().getBytes();
                        DatagramPacket floorp = new DatagramPacket(floorb,floorb.length,dp.getAddress(),dp.getPort());
                        ds.send(floorp);
                        }
						
			/**
			 * win condition
			 */
			if(count == 7) { //These packets contain the victory message if you reach the last room of the dungeon
				byte[] win = "You have made it to the end of the dungeon! Game Over! You Win!".getBytes();
            DatagramPacket winp = new DatagramPacket(win,win.length,dp.getAddress(), dp.getPort());
            ds.send(winp);
				return;
			}           
                            
			/**
			* Finding a monster
			*/
			if(count == mcount || count == mcount2){ //This packet is sent when you get to a room with a monster in it
				byte[] b3 = "You have found a monster!".getBytes();
				DatagramPacket dp3 = new DatagramPacket(b3,b3.length,dp.getAddress(),dp.getPort());
				ds.send(dp3);
				
				Being monster = new Being(3,3,rand.nextInt(20));
				
				while(monster.getHP() > 0 && hero.getHP() > 0) {
					if(monster.getInitiative() > hero.getInitiative()) { //These methods decide whether the player or monster wins the fight
						
						hero.setHP(monster.getAtk());
						
					}else {
				
						monster.setHP(hero.getAtk());
					
					}
				}
				
				if(monster.getHP() <= 0) { //These packets are sent when you either die or slay the monster
					byte[] b4 = "You have slain the monster!".getBytes();
					DatagramPacket dp4 = new DatagramPacket(b4,b4.length,dp.getAddress(),dp.getPort());
					ds.send(dp4);
				} else {
					byte[] b4 = "You've died!".getBytes();
					DatagramPacket dp4 = new DatagramPacket(b4,b4.length,dp.getAddress(),dp.getPort());
					ds.send(dp4);
					return;
				}
			}
		}
	}

	/**
	* Base Room roof
	 * @return 
	*/ 
	//These methods are for building the different room strings as well as the floor and ceiling
	public String dngTextRoomRoof(){

		return " ___  ___  ___  ___  ___  ___  ___  ___ ";
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
	public String dngTextRoomFloor(){
		return " ~~~  ~~~  ~~~  ~~~  ~~~  ~~~  ~~~  ~~~ ";
	}
}
