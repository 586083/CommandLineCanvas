package cmd;

import app.CanvasApp;
import constant.Constant;

public class CmdFactory {
	
	
	/**
	 * Command Factory for each command implementation, Factory Design pattern implemenatiion
	 * @param inputs
	 * @param canvasApp
	 * @return
	 */
	public CanvasApp actionOnCmd(String[] inputs,CanvasApp canvasApp) {
		String cmd=inputs[0];
		if(Constant.COMMAND_CREATE.startsWith(cmd)) {
			canvasApp=new CreateCanvas(canvasApp).excuteCmd(inputs);
		}else if(Constant.COMMAND_LINE.startsWith(cmd)) {
			canvasApp=new CreateLineCanvas(canvasApp).excuteCmd(inputs);
		}else if(Constant.COMMAND_RECTANGE.startsWith(cmd)) {
			canvasApp=new CreateRectangleCanvas(canvasApp).excuteCmd(inputs);
		}else if(Constant.COMMAND_BUCKET_FILL.startsWith(cmd)) {
			canvasApp=new BucketFillCanvasBFS(canvasApp).excuteCmd(inputs);
		}else if(Constant.COMMAND_QUIT.startsWith(cmd)) {
			System.out.println("Quit Canvas Application");
		}
		return canvasApp;
	}
	
	
}
