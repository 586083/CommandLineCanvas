package cmd;

import app.CanvasApp;
import constant.ExceptionConstant;
import exception.CanvasException;

public class CreateCanvas extends Cmd {
	
	/**
	 * Create a local copy for canvasApp for command execution
	 * @param canvasApp
	 */
	public CreateCanvas(CanvasApp canvasApp) {
		this.cmdAppliedCanvas=canvasApp;
	}
	
	/**
	 * Create an canvas
	 */
	@Override
	public CanvasApp excuteCmd(String[] inputs) {
		if(checkValidCommand(inputs,3))
			if(this.cmdAppliedCanvas.checkCanvasEmpty()) {
				this.cmdAppliedCanvas=new CanvasApp(Integer.parseInt(inputs[1]),Integer.parseInt(inputs[2]));
			}else {
				throw new CanvasException(ExceptionConstant.CANVAS_ALREADY_EXIST);
			}
		return this.cmdAppliedCanvas;
	}
}
