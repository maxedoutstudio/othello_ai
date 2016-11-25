/**
 * Created by Maksym on 11/25/2016.
 */
public class TestController {

    public static void main(String [] args){
        Board b = new Board();

        try{
            b.place(3, 2, false);
        } catch (Exception e){
            System.out.println(e);
        }

        System.out.println(b);

    }
}
