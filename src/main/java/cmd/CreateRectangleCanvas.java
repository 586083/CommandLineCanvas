package cmd;

import app.CanvasApp;
import constant.Constant;
import constant.ExceptionConstant;
import exception.CanvasException;

public class CreateRectangleCanvas extends Cmd{
	
	/**
	 * Create local copy of canvas for command execution
	 * @param canvasApp
	 */
	public CreateRectangleCanvas(CanvasApp canvasApp) {
		this.cmdAppliedCanvas=canvasApp;
	}
	
	/**
	 * Create a rectangle in canvas
	 */
	@Override
	public CanvasApp excuteCmd(String[] inputs) {
		if(checkValidCommand(inputs,5))
			if(this.cmdAppliedCanvas.checkCanvasEmpty()) {
				throw new CanvasException(ExceptionConstant.CANVAS_NOT_EXIST);
			}else {
				this.cmdAppliedCanvas.drawLineWithSpecificCharacters(Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]), Integer.parseInt(inputs[3]), Integer.parseInt(inputs[2]), Constant.CROSS); //first horizontal line
				this.cmdAppliedCanvas.drawLineWithSpecificCharacters(Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]), Integer.parseInt(inputs[1]), Integer.parseInt(inputs[4]), Constant.CROSS); //second vertical line
				this.cmdAppliedCanvas.drawLineWithSpecificCharacters(Integer.parseInt(inputs[3]), Integer.parseInt(inputs[2]), Integer.parseInt(inputs[3]), Integer.parseInt(inputs[4]), Constant.CROSS); //third vertical line
				this.cmdAppliedCanvas.drawLineWithSpecificCharacters(Integer.parseInt(inputs[1]), Integer.parseInt(inputs[4]), Integer.parseInt(inputs[3]), Integer.parseInt(inputs[4]), Constant.CROSS); //fourth horizontal line
			}
		return this.cmdAppliedCanvas;
	}
}
