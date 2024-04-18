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


public class GamePanel extends JPanel
{
	private Game app;
	
	public GamePanel(Game app)
	{
		super();
		
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
	}
	private void setupLayout()
	{
		
	}
}
