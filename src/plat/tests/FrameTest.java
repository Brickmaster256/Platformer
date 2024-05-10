package plat.tests; //Change!

/**
 * Project imports
 */
import plat.main.Game; //Change!
import plat.main.GameFrame; //Change!
import plat.main.GamePanel; //Change!
import javax.swing.*;

import java.awt.Component;
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

public class FrameTest
{
	private Game testedController; //Change!
	private GameFrame testedFrame; //Change!
	private GamePanel panel;

	@BeforeEach
	void setUp() throws Exception 
	{
		this.testedController = new Game();
		this.testedFrame = new GameFrame(panel);
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController = null;
		this.testedFrame = null;
	}

	@Test
	void testChatFrame()
	{
		
		
	}

}
