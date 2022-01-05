import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tower extends TowerDefenseObject
{
	final static int diameter = 50;
	
	int reloadTime;
	int spot;
	BufferedImage shotskin;
	Projectile ammo;
	
	public Tower(BufferedImage towerskin,BufferedImage shotskin, int CX, int CY, int r, int dam, int spot)
	{
		super(towerskin, CX, CY, diameter);
		setReloadTime(r);
		this.shotskin = shotskin;
		this.spot = spot;
		ammo = new Projectile(getShotSkin(), getX(), getY(), 5, dam, spot);
	}

	public Projectile fire(Graphics g)
	{
		Projectile shot = new Projectile(ammo);

		return shot;
	}
	
	public BufferedImage getShotSkin() {return shotskin;}

	public void setShotSkin(BufferedImage shot) {this.shotskin = shot;}

	public int getReloadTime() {return reloadTime;}
	
	public void setReloadTime(int reloadTime) 
	{
		if(reloadTime >= 0)
		{this.reloadTime = reloadTime;}
	}	
}
