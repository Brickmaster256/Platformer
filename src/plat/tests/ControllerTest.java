package plat.tests; // Change!!!!

/**
 * Project imports
 */

import plat.main.Game; // Change!!!!

/**
 * Reflection imports
 */
import java.lang.reflect.*;

/**
 * JUnit imports
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControllerTest
{
	private Game testedController;

	@BeforeEach
	void setUp() throws Exception
	{
		this.testedController = new Game();
	}

	@AfterEach
	void tearDown() throws Exception
	{
		this.testedController  = null;
	}

	@Test
	void testDataMembers()
	{
		Field [] fields = testedController.getClass().getDeclaredFields();
		assertTrue(fields.length > 2, "You need at least 3 data members in your Controller");
		
	}

	@Test
	void testControllerMethods()
	{
		Method [] methods = testedController.getClass().getDeclaredMethods();
		assertTrue(methods.length >= 3, "You need at least 3 methods in the controller");
	}


	@Test
	void testStartGameLoopMethod()
	{
		Method [] methods = testedController.getClass().getDeclaredMethods();

		boolean hasStart = false;

		for (Method method : methods)
		{
			Type[] types = method.getGenericParameterTypes();

			if (method.getName().equals("startGameLoop"))
			{
				hasStart = true;

				assertTrue(Modifier.isPrivate(method.getModifiers()), "The " + method.getName()+ " method must be public");
				assertTrue(types.length == 0, "Start has no parameters!");
				assertTrue(method.getReturnType().equals(Void.TYPE), "The " + method.getName()+ " method needs to be a void method!");
			}
		}

		assertTrue(hasStart, "The Controller needs a start method");

	}



	@Test
	void testFrame()
	{
		assertTrue(testedController.getFrame() != null, "Can't be null");
	}

	

}
