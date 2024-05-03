
package plat.gamestates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public interface Statemethods {
	public void update();

	public void draw(Graphics graphics);

	public void mouseClicked(MouseEvent event);

	public void mousePressed(MouseEvent event);

	public void mouseReleased(MouseEvent event);

	public void mouseMoved(MouseEvent event);

	public void keyPressed(KeyEvent event);

	public void keyReleased(KeyEvent event);

}