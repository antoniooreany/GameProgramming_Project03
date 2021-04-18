import java.util.Vector;

public class CircleWorld 
{
	private GraphicSystem graphicSystem;
	protected static  Vector<Bullet> bullets = new Vector<Bullet>();

	private Dot dot;

	public void init()
	{
		dot = new Dot();
	}

	public void run()
	{
		long lastTick = System.currentTimeMillis();
		while(true)
		{
			// calculate elapsed time
			//
			long currentTick    = System.currentTimeMillis();
			double diffSeconds  = (currentTick-lastTick)/1000.0;
			lastTick            = currentTick;

			//move the avatar 
			dot.move(diffSeconds);

			// move all bullets
			for(int i=0; i<bullets.size(); i++)
			{ 
				bullets.get(i).move(diffSeconds);
			}

			graphicSystem.clear();

			//draw the avatar 
			graphicSystem.draw(dot);

			//draw all bullets 
			for(int i=0; i<bullets.size(); i++)
			{ 
				graphicSystem.draw(bullets.get(i));
			}

			graphicSystem.redraw();

			// redraw everything
			graphicSystem.redraw();

		}

	}


	public void setGraphicSystem(GraphicSystem p) { graphicSystem = p; }
}
