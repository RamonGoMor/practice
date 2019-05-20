import java.awt.*;
import java.util.*;
public class mouse{

    public static void main(String[] args) throws Exception{
        Robot hal = new Robot();
        Random random = new Random();
        while(true){
            hal.delay(1000 * 60);
			Point p = MouseInfo.getPointerInfo().getLocation();
            int x = (int) p.getX();//random.nextInt() % 640;
            int y = (int) p.getY();//random.nextInt() % 480;
            hal.mouseMove(x+1,y);
			hal.delay(1 * 1);
			hal.mouseMove(x,y);
        }
    }
}