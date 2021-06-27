package cmd;

import app.CanvasApp;
import constant.Constant;
import constant.ExceptionConstant;
import exception.CanvasException;

public class CreateLineCanvas extends Cmd {
	
	/**
	 * Create local copy of canvas for command execution
	 * @param canvasApp
	 */
	public CreateLineCanvas(CanvasApp canvasApp) {
		this.cmdAppliedCanvas=canvasApp;
	}

	/**
	 * Create a line in canvas
	 */
	@Override
	public CanvasApp excuteCmd(String[] inputs) {
		if(checkValidCommand(inputs,5))
			if(this.cmdAppliedCanvas.checkCanvasEmpty()) {
				throw new CanvasException(ExceptionConstant.CANVAS_NOT_EXIST);
			}else {
				this.cmdAppliedCanvas.drawLineWithSpecificCharacters(Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]), Integer.parseInt(inputs[3]), Integer.parseInt(inputs[4]), Constant.CROSS);
			}
		return this.cmdAppliedCanvas;
	}

}
