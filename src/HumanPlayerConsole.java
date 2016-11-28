import java.util.Scanner;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * Created by Maksym on 11/15/2016.
 */
public class HumanPlayerConsole extends Player{

    private int maxTime = 30000;

    public class Input implements Callable<String> {
        public String call() throws IOException {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            String input;
            do {
                try {
                    // wait until we have data to complete a readLine()
                    while (!br.ready()) {
                        Thread.sleep(100);
                    }
                    input = br.readLine();
                } catch (InterruptedException e) {
                    return null;
                }
            } while ("".equals(input));
            return input;
        }
    }


	//default constructor
	HumanPlayerConsole(){
		super();
	}

	HumanPlayerConsole(Board board, String color, int maxTime){
		super(board,color);
        this.maxTime = maxTime;
	}

	public int[] move(){  // Timer stuff for turns

            ExecutorService serv = Executors.newSingleThreadExecutor();

            String string_x = null, string_y = null;

			int x=-1,y=-1;

			skipping = false;

			System.out.println("Player: " + color);
            // Tells user how much time he has
            System.out.println("Turn time-limit: " + (float ) (maxTime) / 1000.0 + " seconds.");

			System.out.print("Enter a  x-coordinate: ");
            try {
                Future<String> in = serv.submit(new Input());
                try {
                    long startTime = System.nanoTime();
                    string_x = in.get(maxTime, TimeUnit.MILLISECONDS);
                    long endTime = System.nanoTime();
                    long dur = (endTime - startTime) / 1000000;
                    int newMaxTime = maxTime - (int) dur;
                    in = serv.submit(new Input());
                    System.out.print("Enter a  y-coordinate: ");
                    string_y = in.get(newMaxTime, TimeUnit.MILLISECONDS);
                } catch (TimeoutException exception) {
                    // Some exception handling stuff
                    in.cancel(true);
                } catch (Exception e) {}

                try {
                    x = Integer.parseInt(string_x);
                } catch (Exception e) {
                    if (string_x == null){
                        skipping = true;
                        return null;
                    }
                    if (!string_x.equals("")) {
                        return null;
                    }
                }
                try{
                    y = Integer.parseInt(string_y);
                }
                catch(Exception e){

                    if (string_y == null || string_x.equals("") && string_y.equals("")){
                        skipping = true;
                    }
                    return null;
                }
            } finally {
                serv.shutdownNow();
            }

			lastMove = new int[]{x,y};
			return new int[]{x,y};
		}

}
