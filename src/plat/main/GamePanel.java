package plat.main;

import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import plat.inputs.KeyboardInputs;
import plat.inputs.MouseInputs;


public class GamePanel extends JPanel
{
	private Game app;
	private MouseInputs mouse;
	
	public GamePanel(Game app)
	{
		super();
		
		this.mouse = new MouseInputs();
		
		setupPanel();
		setupListeners();
		setupLayout();
	}
	
	@Override
	protected void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		graphics.fillRect(100, 100, 200, 50);
	}
	
	
	private void setupPanel()
	{
		
	}
	private void setupListeners()
	{
		addKeyListener(new KeyboardInputs());
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	private void setupLayout()
	{
		
	}
}
