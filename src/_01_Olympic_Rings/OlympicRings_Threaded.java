package _01_Olympic_Rings;

import java.awt.Color;
import java.util.ArrayList;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	Robot blue,yellow,black,green,red;
	OlympicRings_Threaded()
	{
		blue = new Robot();
		yellow = new Robot();
		black = new Robot();
		green = new Robot();
		red = new Robot();
		
		blue.setPenColor(Color.blue);blue.penDown();
		yellow.setPenColor(Color.yellow);yellow.penDown();
		black.setPenColor(Color.black);black.penDown();
		green.setPenColor(Color.green);green.penDown();
		red.setPenColor(Color.red);red.penDown();
		
		int s = 75;
		int offSet = 40;
		blue.setX(s + offSet);blue.setY(s + offSet);
		yellow.setX(s + offSet*2);yellow.setY(s + offSet*2);
		black.setX(s + offSet*3);black.setY(s + offSet);
		green.setX(s + offSet*4);green.setY(s + offSet*2);
		red.setX(s + offSet*5);red.setY(s + offSet);
		
		ArrayList<Robot> robots = new ArrayList<Robot>();
		robots.add(blue);
		robots.add(yellow);
		robots.add(black);
		robots.add(green);
		robots.add(red);
		
		
		for (int i = 0; i < 6; i++)
		{
			for (Robot r : robots)
			{
				Thread t = new Thread(()->r.move(60));
				t.start();
			}
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (Robot r : robots)
			{
				Thread t = new Thread(()->r.turn(60));
				t.start();
			}
			try {
				Thread.sleep(750);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (Robot r : robots)
		{
			r.setX(-100);
			r.setY(-100);
		}
	}
	public static void main(String[] args) {
		OlympicRings_Threaded ort = new OlympicRings_Threaded();
	}
}

