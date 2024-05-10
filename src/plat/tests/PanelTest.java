package plat.tests; //Change me

/**
 * Project imports
 */
import plat.main.Game; //Change me
import plat.main.GamePanel; //Change me
import javax.swing.*;

import java.awt.*;
/**
 * Reflection imports
 */
import java.lang.reflect.*;
/**
 * Testing imports
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PanelTest
{
	private Game testedController; //Change me
	private GamePanel testedPanel; //Change me

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedController = new Game(); //Change me
		this.testedPanel = new GamePanel(testedController); //Change me
	} 

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController = null;
		this.testedPanel = null;
	}

	
	
	@Test
	void testPanelComponents()
	{
		Field [] fields = testedPanel.getClass().getDeclaredFields();
		assertTrue(fields.length > 1, "You need at least 3 data members in your XYZPanel");
		
		
	}

}
