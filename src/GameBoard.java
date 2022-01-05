import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameBoard extends JPanel implements MouseMotionListener, MouseListener
{	
	private int mouseX;
	private int mouseY;
	private boolean activeGay;
	private boolean activeBi;
	private boolean start;
	private TowerDefenseObject heart;
	private Enemy[] enemies = new Enemy[1000];
	private int totalE = 0;
	private Tower[] towers = new Tower[1000];
	private int totalT = 0;
	private Projectile[] shots = new Projectile[10000];
	private int totalP = 0;
	private TowerDefenseObject center = new TowerDefenseObject(null, 300, 300, 100);
	private JLabel healthPanel;
	private JLabel moneyPanel;
	
	Enemy testE;
	
	private int playerHealth = 100;
	private int playerCash = 100;
	
	public GameBoard()
	{
		super();
		try {
			setHealth(100);
			setMoney(100);
			mouseX = 0;
			mouseY = 0;
			activeGay = false;
			activeBi = false;
			start = false;
			
			for (int i = 0; i < 5; i++)
			{
				Enemy t1 = new Enemy(ImageIO.read(new File("Enemy1.png")), i*-100, 300, 10, 10, 5);
				enemies[totalE] = t1;
				totalE++;
			}
			
			for (int i = 0; i < 5; i++)
			{
				Enemy t1 = new Enemy(ImageIO.read(new File("Enemy1.png")), i*100 + 600, 300, 10, 10, 5);
				enemies[totalE] = t1;
				totalE++;
			}

			heart = new TowerDefenseObject(null, 300, 300, 1);

			this.addMouseListener(this);
			this.addMouseMotionListener(this);
			
		} catch (IOException e) {
			System.err.println("Game Board Error");
			e.printStackTrace();
		}
	}
	
	public void paint(Graphics g)
	{
		try {
			g.drawImage(ImageIO.read(new File("Map1-01.png")), 0, 0, 600, 600, null);
			
//			if(start)
//			{
//				for (int i = 0; i < 5; i++)
//				{
//					Enemy t1 = new Enemy(ImageIO.read(new File("Enemy1.png")), i*-100, 300, 10, 10, 5);
//					enemies[i] = t1;
//					totalE++;
//				}
//			}
//			
			
			for(Tower tower : towers)
			{
				if(tower != null)
				{
					tower.draw(g);
					if(tower.getReloadTime() == 0 && start)
					{
						shots[totalP] = tower.fire(g);
						totalP++;
						tower.setReloadTime(10);
					}
					else
					{
						tower.setReloadTime(tower.getReloadTime() - 1);
					}
				}
			}
			
			if(start)
			{
				for(int i = 0; i < enemies.length; i++)
				{
					if(enemies[i] != null)
					{
						enemies[i].move(g, heart);
						enemies[i].setSkin(ImageIO.read(new File("Enemy1.png")));
						
						if(Enemy.collision(enemies[i], heart))
						{
							playerHealth-= enemies[i].getDamage();
							setPlayerHealth(playerHealth);
							enemies[i] = null;
						}
					}
				}

				for(int i = 0; i < shots.length; i++)
				{
					if(shots[i] != null)
					{
						shots[i].move(g, shots[i].isClosest(enemies, towers[shots[i].getHome()]));
						int counter = 0;
						for(int j = 0; j < enemies.length; j++)
						{

							if(enemies[j] != null)
							{
								counter++;
								if(Projectile.collision(shots[i], enemies[j]))
								{
									enemies[j].setHealth(enemies[j].getHealth() - shots[i].getDamage());
									enemies[j].setSkin(ImageIO.read(new File("Enemy1_Hit.png")));
									shots[i] = null;
								}
							}


						}
						if(counter == 0)
						{
							for(int j1 = 0; j1 < shots.length; j1++)
							{shots[j1] = null;totalP = 0;}
							start = false;
						}
						if(shots[i] != null)
							shots[i].draw(g);
					}
				}
			}
			
			if(!start)
			{
				if(activeGay)
				{
					g.drawImage(ImageIO.read(new File("Gay Tower.png")), getMouseX()-50, getMouseY()-50, 75, 75, null);
				}
				if(activeBi)
				{
					g.drawImage(ImageIO.read(new File("Bi Tower.png")), getMouseX()-50, getMouseY()-50, 75, 75, null);
				}
			}
			
			repaint();
			
		} catch (Exception e) {
			System.err.println("Paint Error");
			e.printStackTrace();
		}
	}
	
	public void addTower(BufferedImage towerSkin, BufferedImage projSkin, int cost, int dam)
	{
		if (playerCash-cost >= 0)
		{
			Tower t1 = new Tower(towerSkin, projSkin, getMouseX(), getMouseY(), 10, dam, totalT);
			playerCash -= cost;
			setPlayerCash(playerCash);
			towers[totalT] = t1;
			totalT++;
		}
	}
	
	public int getHealth() 
	{return playerHealth;}

	public void setHealth(int health) 
	{this.playerHealth = health;}

	public int getMoney() 
	{return playerCash;}

	public void setMoney(int money) 
	{this.playerCash = money;}
	
	public int getMouseX() 
	{return mouseX;}

	public int getMouseY() 
	{return mouseY;}
	
	public boolean getActiveGay()
	{return activeGay;}
	
	public boolean getActiveBi()
	{return activeBi;}
	
	public void setMouseX(int mouseX) 
	{this.mouseX = mouseX;}

	public void setMouseY(int mouseY) 
	{this.mouseY = mouseY;}
	
	public void setActiveGay(boolean ac)
	{this.activeGay = ac;}
	
	public void setActiveBi(boolean ac)
	{this.activeBi = ac;}
	
	public boolean getStart() 
	{return start;}

	public void setStart(boolean start) 
	{this.start = start;}

	@Override
	public void mouseClicked(MouseEvent arg0) 
	{
		try {
			if(activeGay)
			{
				activeGay = false;
				addTower(ImageIO.read(new File("Gay Tower.png")), ImageIO.read(new File("Gay Shot.png")), 5, 5);
			}

			if(activeBi)
			{
				activeBi = false;
				addTower(ImageIO.read(new File("Bi Tower.png")), ImageIO.read(new File("Bi Shot.png")), 50, 10);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mouseMoved(MouseEvent arg0) 
	{
		setMouseX(arg0.getX());
		setMouseY(arg0.getY());
		
		repaint();
	}

	public void giveText(JLabel healthPanel) 
	{
		this.healthPanel = healthPanel;
	}
	public void giveMText(JLabel money)
	{
		this.moneyPanel = money;
	}
	
	public void setPlayerHealth(int i) 
	{
		healthPanel.setText(Integer.toString(i));
	}
	
	public void setPlayerCash(int i)
	{
		moneyPanel.setText(Integer.toString(i));
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
