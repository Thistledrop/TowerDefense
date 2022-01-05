import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MovingTowerDefenseObject extends TowerDefenseObject
{
	int velocity;
	
	public MovingTowerDefenseObject(BufferedImage skin, int X, int w, int h, int d) 
	{
		super(skin, X, w, h);
		velocity = d;
	}

	public int getVelocity() 
	{return velocity;}

	public void setVelocity(int V) 
	{this.velocity = V;}
	
	public void move(Graphics g, TowerDefenseObject center)
	{	
		if (center != null)
		{
			if (center.getX() > this.getX())
			{
				this.setX((int)(X + velocity));
			}
			else if (center.getX() < this.getX())
			{
				this.setX((int)(X - velocity));
			}

			if (center.getY() < this.getY())
			{
				this.setY((int)(Y - velocity));
			}
			else if (center.getY() > this.getY())
			{
				this.setY((int)(Y + velocity));
			}
		}
		
		this.draw(g);
	}
	
}
