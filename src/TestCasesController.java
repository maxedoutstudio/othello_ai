/**
 * 
 * @author Moh 
 * INTERNAL TEST CASES
 */
public class TestCasesController {
	
	  public static void main(String [] args) throws Exception{
	  
	  //GREEDY 1 VS GREEDY 1	  
	  Game GREEDY_A = new Game("GREEDY 1", "GREEDY 1", "BOARD");
	  GREEDY_A.loop();	  
	  //GREEDY 2 VS GREEDY VS WITH DEPTH 3	  
	  Game GREEDY_B = new Game("GREEDY 2", "GREEDY 3", "BOARD");
	  GREEDY_B.loop();	  
	  //GREEDY 7 VS GREEDY VS WITH DEPTH 4	  
	  Game GREEDY_C = new Game("GREEDY 7", "GREEDY 4", "BOARD");
	  GREEDY_C.loop();
	  
	  /////////////////////////////////////////////////////////////////
	  
	  //GREEDY 4 VS MAKYSM1 2	  
	  Game GREEDYMAKYSM1_A = new Game("GREEDY 4", "MAKYSM1 2", "BOARD");
	  GREEDYMAKYSM1_A.loop();	  	  
	  //GREEDY 4 VS MAKYSM1 6	  
	  Game GREEDYMAKYSM1_B = new Game("GREEDY 4", "MAKYSM1 6", "BOARD");
	  GREEDYMAKYSM1_B.loop();	  
	  //GREEDY 3 VS MAKYSM1 3	  
	  Game GREEDYMAKYSM1_C = new Game("GREEDY 3", "MAKYSM1 3", "BOARD");
	  GREEDYMAKYSM1_C.loop();
	  
	  ////////////////////////////////////////////////////////////////
	  //GREEDY 3 VS MAKYSM2 2	  
	  Game GREEDYMAKYSM2_A = new Game("GREEDY 3", "MAKYSM2 2", "BOARD");
	  GREEDYMAKYSM2_A.loop();	  	  
	  //GREEDY 3 VS MAKYSM1 7	  
	  Game GREEDYMAKYSM2_B = new Game("GREEDY 3", "MAKYSM2 7", "BOARD");
	  GREEDYMAKYSM2_B.loop();	  
	  //GREEDY 2 VS MAKYSM1 2	  
	  Game GREEDYMAKYSM2_C = new Game("GREEDY 2", "MAKYSM2 2", "BOARD");
	  GREEDYMAKYSM2_C.loop();
	  
	  /////////////////////////////////////////////////////////////////
	  	  
	  //MAKYSM1 4 VS MAKYSM2 2	  
	  Game MAKYSM1MAKYSM2_A = new Game("MAKYSM1 4", "MAKYSM2 2", "BOARD");
	  MAKYSM1MAKYSM2_A.loop();	  	  
	  //GREEDY 3 VS MAKYSM1 4	  
	  Game MAKYSM1YMAKYSM2_B = new Game("MAKYSM1 3", "MAKYSM2 4", "BOARD");
	  MAKYSM1YMAKYSM2_B.loop();	  
	  //GREEDY 6 VS MAKYSM1 6	  
	  Game MAKYSM1MAKYSM2_C = new Game("MAKYSM1 6", "MAKYSM2 6", "BOARD");
	  MAKYSM1MAKYSM2_C.loop();

    	/////////////////////////////////////////////////////////////////
		  	  
		//MOH1 2 VS MAKYSM1 4  
		Game MAKYSM1MOH1_A = new Game("MOH1 2", "MAKYSM1 4", "BOARD");
		MAKYSM1MOH1_A.loop();	  	  
		//MOH1 5 VS MAKYSM1 2  
		Game MAKYSM1MOH1_B = new Game("MOH1 5", "MAKYSM1 2", "BOARD");
		MAKYSM1MOH1_B.loop();	  
		//MOH1 6 VS MAKYSM1 6  
		Game MAKYSM1MOH1_C = new Game("MOH1 6", "MAKYSM1 6", "BOARD");
		MAKYSM1MOH1_C.loop();
		
    	/////////////////////////////////////////////////////////////////
	  	  
		//MOH1 1 VS MAKYSM2 2  
		Game MAKYSM2MOH1_A = new Game("MOH1 1", "MAKYSM2 2", "BOARD");
		MAKYSM2MOH1_A.loop();	  	  
		//MOH1 10 VS MAKYSM2 5  
		Game MAKYSM2MOH1_B = new Game("MOH1 10", "MAKYSM2 5", "BOARD");
		MAKYSM2MOH1_B.loop();	  
		//MOH1 7 VS MAKYSM2 7  
		Game MAKYSM2MOH1_C = new Game("MOH1 7", "MAKYSM2 7", "BOARD");
		MAKYSM2MOH1_C.loop();
		
		//////////////////////////////////////////////////////////////////
		
		//MOH1 1 VS MOH2 2  
		Game MOH2MOH1_A = new Game("MOH1 1", "MOH2 2", "BOARD");
		MOH2MOH1_A.loop();	  	  
		//MOH1 10 VS MAKYSM2 5  
		Game MOH2MOH1_B = new Game("MOH1 10", "MOH2 5", "BOARD");
		MOH2MOH1_B.loop();	  
		//MOH1 7 VS MAKYSM2 7  
		Game MOH2MOH1_C = new Game("MOH1 7", "MOH2 7", "BOARD");
		MOH2MOH1_C.loop();
  }

}
