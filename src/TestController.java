/**
 * Created by Maksym on 11/25/2016.
 */
public class TestController {

    public static void main(String [] args) throws Exception{
        Board b = new Board();

        System.out.println(b);
        try{
            b.place(3, 2, false);
            System.out.println(b);
            b.place(2, 4, true);
            System.out.println(b);
            b.place(1, 5, false);
            System.out.println(b);
            b.place(1, 4, true);
            System.out.println(b);
            b.place(1, 3, false);
            System.out.println(b);
            b.place(0, 2, true);
            System.out.println(b);
        } catch (Exception e){
            throw e;
        }


    }
}
