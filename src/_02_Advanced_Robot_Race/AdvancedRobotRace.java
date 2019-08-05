package _02_Advanced_Robot_Race;

import java.util.ArrayList;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	// Re-do the robot race recipe from level 3 module 0. 
	// This time, use threads to make all of the robots go at the same time.
	public static void main(String[] args) {
		AdvancedRobotRace arr = new AdvancedRobotRace();
	}
	AdvancedRobotRace()
	{
		ArrayList<Robot> robots = new ArrayList<Robot>();
		for (int i = 0; i < 3; i++)
		{
			Robot r = new Robot();
			r.setY(500);
			r.setX(i * 50);
			robots.add(r);
		}
		Thread a = new Thread(()->robots.get(0).move(600));
		Thread b = new Thread(()->robots.get(1).move(600));
		Thread c = new Thread(()->robots.get(2).move(600));
		a.start();
		b.start();
		c.start();
		while(robots.get(0).getY() > 0 && robots.get(1).getY() > 0 && robots.get(2).getY() > 0)
		{
			System.out.println("0:" + robots.get(0).getY());
			System.out.println("1:" + robots.get(1).getY());
			System.out.println("2:" + robots.get(2).getY());
		}
		System.out.println("done");
		if (robots.get(0).getY() <= 0) System.out.println("robot a won");
		if (robots.get(1).getY() <= 0) System.out.println("robot b won");
		if (robots.get(2).getY() <= 0) System.out.println("robot c won");
	}
}
