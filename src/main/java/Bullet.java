public class Bullet {
	
	public double x,y;
	public double dx = 480,dy=350;
	public double speed = 300;
	public double alfa = 0;

	public Bullet(double x2, double y2) {
		x=x2;  y=y2;
	}

	public void move(double diffSeconds)
	{ 	
		alfa = Math.atan2(dy-y, dx-x);
		x += Math.cos(alfa)*speed*diffSeconds;
		y += Math.sin(alfa)*speed*diffSeconds; 
		 
		// delete if destination is reached
		double diffX = Math.abs(x-dx);
		double diffY = Math.abs(y-dy);
		if(diffX<2 && diffY<2)
		{ 
			CircleWorld.bullets.remove(this);
		}
	}
	
}
