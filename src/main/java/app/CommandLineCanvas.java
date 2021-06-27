package app;
import java.util.Scanner;
import cmd.CmdFactory;
import constant.Constant;
import exception.CanvasException;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommandLineCanvas {
	
	private CanvasApp canvasApp;
	
	public CommandLineCanvas() {
		canvasApp=new CanvasApp();
	}
	
	public static void main(String args[]) {
		CommandLineCanvas cmc=new CommandLineCanvas();
		Scanner scan = new Scanner(System.in);
		String command=Constant.EMPTY_STRING;
		while(!command.equals(Constant.COMMAND_QUIT)) {
			System.out.println("Enter command:");
			command=scan.nextLine();
			System.out.println(cmc.execteCommand(command));
		}
		scan.close();
	}
	
	/**
	 * This method execute each command actions
	 * @param command
	 * @return Output of execution
	 */
	public String execteCommand(String command) {
		String[] arrayOfCommand=command.split(" ");
		String result=new String();
		CmdFactory cmdFactory=new CmdFactory(); // Factory Design pattern to make command operation extensible
		result = checkValidCommand(command);
		if(result.isEmpty()) {
			try {
				setCanvasApp(cmdFactory.actionOnCmd(arrayOfCommand,getCanvasApp()));
				return getCanvasApp().printCanvas();
			}catch(CanvasException exe) {
				result=exe.getCode().concat("-").concat(exe.getMessage());
			}
		}
		return result;
	}
	
	/**
	 * This method check command entered is valid
	 * @param command
	 * @return
	 */
	public String checkValidCommand(String command) {
		if(command.startsWith(Constant.COMMAND_CREATE) || command.startsWith(Constant.COMMAND_LINE) || command.startsWith(Constant.COMMAND_RECTANGE) || command.startsWith(Constant.COMMAND_BUCKET_FILL) || command.startsWith(Constant.COMMAND_QUIT) ) {
			return "";
		}
		return "Entered Invalid command. Below command are accepted \n" + 
				"C w h           Should create a new canvas of width w and height h.\n" + 
				"L x1 y1 x2 y2   Should create a new line from (x1,y1) to (x2,y2). Currently only\n" + 
				"                horizontal or vertical lines are supported. Horizontal and vertical lines\n" + 
				"                will be drawn using the 'x' character.\n" + 
				"R x1 y1 x2 y2   Should create a new rectangle, whose upper left corner is (x1,y1) and\n" + 
				"                lower right corner is (x2,y2). Horizontal and vertical lines will be drawn\n" + 
				"                using the 'x' character.\n" + 
				"B x y c         Should fill the entire area connected to (x,y) with \"colour\" c. The\n" + 
				"                behavior of this is the same as that of the \"bucket fill\" tool in paint\n" + 
				"                programs.\n" + 
				"Q               Should quit the program.";
	}
	
}
