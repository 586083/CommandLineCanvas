package canvas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import app.CommandLineCanvas;

public class CanvasTest {
	
	/**
	@Test
	public void invalidCommand() {
		CommandLineCanvas clc=new CommandLineCanvas();
		assertEquals(true,clc.execteCommand("F E").contains("Entered Invalid command"));
	}*/
	
	@Test
	public void testCreate() {
		CommandLineCanvas clc=new CommandLineCanvas();
		assertEquals("----------------------\n" + 
				"|                    |\n" + 
				"|                    |\n" + 
				"|                    |\n" + 
				"|                    |\n" + 
				"----------------------", clc.execteCommand("C 20 4"));
	}
	
	@Test
	public void testCreateFailure() {
		CommandLineCanvas clc=new CommandLineCanvas();
		assertEquals(true,clc.execteCommand("C 20 *").contains("EXE"));
	}
	
	@Test
	public void testCreateLine() {
		CommandLineCanvas clc=new CommandLineCanvas();
		clc.execteCommand("C 20 4");
		clc.execteCommand("L 1 2 6 2");
		assertEquals("----------------------\n" + 
				"|                    |\n" + 
				"|xxxxxx              |\n" + 
				"|                    |\n" + 
				"|                    |\n" + 
				"----------------------", clc.getCanvasApp().printCanvas());
	}
	
	@Test
	public void testCreateLineFailure() {
		CommandLineCanvas clc=new CommandLineCanvas();
		clc.execteCommand("C 20 4");
		assertEquals(true,clc.execteCommand("L * 2 6 2").contains("EXE"));
	}
	
	@Test
	public void testCreateLineVertical() {
		CommandLineCanvas clc=new CommandLineCanvas();
		clc.execteCommand("C 20 4");
		clc.execteCommand("L 1 2 6 2");
		clc.execteCommand("L 6 3 6 4");
		assertEquals("----------------------\n" + 
				"|                    |\n" + 
				"|xxxxxx              |\n" + 
				"|     x              |\n" + 
				"|     x              |\n" + 
				"----------------------", clc.getCanvasApp().printCanvas());
	}
	
	@Test
	public void testCreateRectangle() {
		CommandLineCanvas clc=new CommandLineCanvas();
		clc.execteCommand("C 20 4");
		clc.execteCommand("L 1 2 6 2");
		clc.execteCommand("L 6 3 6 4");
		clc.execteCommand("R 14 1 18 3");
		assertEquals("----------------------\n" + 
				"|             xxxxx  |\n" + 
				"|xxxxxx       x   x  |\n" + 
				"|     x       xxxxx  |\n" + 
				"|     x              |\n" + 
				"----------------------", clc.getCanvasApp().printCanvas());
	}
	
	@Test
	public void testCreateRectangleFailue() {
		CommandLineCanvas clc=new CommandLineCanvas();
		clc.execteCommand("C 20 4");
		clc.execteCommand("L 1 2 6 2");
		clc.execteCommand("L 6 3 6 4");
		assertEquals(true,clc.execteCommand("R * 1 18 3").contains("EXE"));
	}
	
	@Test
	public void testBucketFillSuccess1() {
		CommandLineCanvas clc=new CommandLineCanvas();
		clc.execteCommand("C 20 4");
		clc.execteCommand("L 1 2 6 2");
		clc.execteCommand("L 6 3 6 4");
		clc.execteCommand("R 14 1 18 3");
		clc.execteCommand("B 10 3 o");
		assertEquals("----------------------\n" + 
				"|oooooooooooooxxxxxoo|\n" + 
				"|xxxxxxooooooox   xoo|\n" + 
				"|     xoooooooxxxxxoo|\n" + 
				"|     xoooooooooooooo|\n" + 
				"----------------------", clc.getCanvasApp().printCanvas());
	}
	
	@Test
	public void testBucketFillSuccess2() {
		CommandLineCanvas clc=new CommandLineCanvas();
		clc.execteCommand("C 20 4");
		clc.execteCommand("L 1 2 6 2");
		clc.execteCommand("L 6 3 6 4");
		clc.execteCommand("R 14 1 18 3");
		clc.execteCommand("B 10 3 p");
		assertEquals("----------------------\n" + 
				"|pppppppppppppxxxxxpp|\n" + 
				"|xxxxxxpppppppx   xpp|\n" + 
				"|     xpppppppxxxxxpp|\n" + 
				"|     xpppppppppppppp|\n" + 
				"----------------------", clc.getCanvasApp().printCanvas());
	}
	
	@Test
	public void testBucketFillSuccess3() {
		CommandLineCanvas clc=new CommandLineCanvas();
		clc.execteCommand("C 20 4");
		clc.execteCommand("L 1 2 6 2");
		clc.execteCommand("L 6 3 6 4");
		clc.execteCommand("R 14 1 18 3");
		clc.execteCommand("B 10 3 o");
		clc.execteCommand("B 1 3 p");
		assertEquals("----------------------\n" + 
				"|oooooooooooooxxxxxoo|\n" + 
				"|xxxxxxooooooox   xoo|\n" + 
				"|pppppxoooooooxxxxxoo|\n" + 
				"|pppppxoooooooooooooo|\n" + 
				"----------------------", clc.getCanvasApp().printCanvas());
	}
	
	@Test
	public void testBucketFillFailure() {
		CommandLineCanvas clc=new CommandLineCanvas();
		clc.execteCommand("C 20 4");
		clc.execteCommand("L 1 2 6 2");
		clc.execteCommand("L 6 3 6 4");
		clc.execteCommand("R 14 1 18 3");
		assertEquals(true,clc.execteCommand("B 10 3 3").contains("EXE"));
	}
}
