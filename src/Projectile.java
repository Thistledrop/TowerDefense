import java.awt.Graphics;
import java.awt.image.BufferedImage;
public class Projectile extends MovingTowerDefenseObject
{
	int damage;
	int home;
	
	public Projectile(BufferedImage skin, int X, int Y, int V, int dam, int t)
	{
		super(skin, X, Y, 10, V);
		damage = dam;
		
	}	
	
	public Projectile(Projectile p)
	{
		super(p.getSkin(), p.getX(), p.getY(), p.getDiameter(), p.getVelocity());
		
		damage = p.getDamage();
		this.X = p.getX();
		this.Y = p.getY();
	}
	
	public Projectile(BufferedImage skin, Tower t)
	{
		super(skin, t.getX(),  10, 10, 10);
		damage = 5;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHome() {
		return home;
	}

	public void setHome(int home) {
		this.home = home;
	}
	
	public void setNull()
	{
		setSkin(null);
		setX(0);
		setY(0);
		setDiameter(0);
		setDamage(0);
		setHome(0);
	}

}
