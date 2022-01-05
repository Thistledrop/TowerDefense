import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Enemy extends MovingTowerDefenseObject
{
//	static int heartX;
//	static int heartY;
	int health;
	int damage;
	
	public Enemy(BufferedImage skin, int X, int Y, int V, int hp, int dam) 
	{
		super(skin, X, Y, 30, V);
		health = hp;
		damage = dam;
	}

	public int getHealth() 
	{return health;}

	public void setHealth(int health) 
	{
		this.health = health;
	}

	public void reduceHealth(int damage)
	{setHealth(health - damage);}
	
	public int getDamage()
	{return damage;}
	
	public void setDamage(int damage)
	{damage = this.damage;}
	
	public void draw(Graphics g)
	{
		if(health > 0)
		{super.draw(g);}
	}
	
	public void setNull()
	{
		setSkin(null);
		setX(0);
		setY(0);
		setDiameter(0);
		setHealth(0);
		setDamage(0);
	}
}
