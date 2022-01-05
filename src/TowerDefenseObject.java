import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class TowerDefenseObject 
{
	final int BoardWidth = 600;
	final int BoardHeight = 600;
	
	BufferedImage skin;
	int X;
	int Y;
	int diameter;
	
	public TowerDefenseObject(BufferedImage skin, int X, int Y, int w)
	{
		setSkin(skin);
		setX(X);
		setY(Y);
		setDiameter(w);
	}
	public BufferedImage getSkin() 
	{
		return skin;
	}
	public void setSkin(BufferedImage skin) 
	{
		this.skin = skin;
	}
	public int getX() 
	{return X;}
	public void setX(int X) 
	{
		if(X >= 0 || X <= BoardWidth) 
		{this.X = X;}
	}
	public int getY() 
	{return Y;}
	public void setY(int Y) 
	{
		if(Y >= 0 || Y <= BoardHeight) 
		{this.Y = Y;}
	}
	public int getDiameter() 
	{return diameter;}
	public void setDiameter(int width) 
	{if (width > 0) {this.diameter = width;}}

	
	public static boolean collision(TowerDefenseObject shot, TowerDefenseObject enemy)
	{
		if(shot != null && enemy != null)
		{
			boolean collide = false;
			int shotRad = shot.getDiameter()/2;
			int eneRad = enemy.getDiameter()/2;
			int radi = shotRad+eneRad;
		
			int yDis = enemy.getY()-shot.getY();
			int xDis = enemy.getX()-shot.getX();
			
			if(Math.sqrt((xDis*xDis)+(yDis*yDis))<(radi))
			{
				collide = true;
			}
		
			return collide;
		}
		else {return false;}
	}
	
	public TowerDefenseObject isClosest(TowerDefenseObject[] enemies, TowerDefenseObject tower)
	{
		TowerDefenseObject closest = enemies[0];
		if(tower != null)
		{
			int towerX = tower.getX();
			int towerY = tower.getY();

			int enemyX;
			int enemyY;

			int distance;
			int smallestDis = Integer.MAX_VALUE;
			

			for(int i = 0; i < enemies.length; i++)
			{
				if(enemies[i] != null)
				{
					enemyX = enemies[i].getX();
					enemyY = enemies[i].getY();

					distance = (int) Math.sqrt(Math.pow(enemyX-towerX, 2)+Math.pow(enemyY-towerY, 2));

					if(distance < smallestDis)
					{
						smallestDis = distance;
						closest = enemies[i];
					}
				}

			}	
		}
		
		return closest;
	}
	
	public void setNull()
	{
		setSkin(null);
		setX(0);
		setY(0);
		setDiameter(0);
	}
	
	public void draw(Graphics g)
	{
		//System.out.println("fail");
		if(skin != null)
		{
			//System.out.println("drawn");
			g.drawImage(skin, X-(diameter/2), Y-(diameter/2), diameter, diameter, null);
		}
	}
}
