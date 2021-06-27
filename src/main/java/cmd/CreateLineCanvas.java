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
		if(checkValidCommand(inputs,5) && checkHorizontalVerticalLine(inputs))
			if(this.cmdAppliedCanvas.checkCanvasEmpty()) {
				throw new CanvasException(ExceptionConstant.CANVAS_NOT_EXIST);
			}else {
				if(checkLineCrossBorder(inputs))
				this.cmdAppliedCanvas.drawLineWithSpecificCharacters(Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]), Integer.parseInt(inputs[3]), Integer.parseInt(inputs[4]), Constant.CROSS);
			}
		return this.cmdAppliedCanvas;
	}

	private boolean checkHorizontalVerticalLine(String[] inputs) {
		boolean checkLine=false;
		if(inputs[1].equals(inputs[3])) {
			checkLine=true;
		}else if(inputs[2].equals(inputs[4])) {
			checkLine=true;
		}
		if(!checkLine)
			throw new CanvasException(ExceptionConstant.CANVAS_SUPPORT_LINE_EXE);
		return checkLine;
	}
	
	private boolean checkLineCrossBorder(String[] inputs) {
		if (Integer.parseInt(inputs[2]) <= 0 || Integer.parseInt(inputs[1]) <= 0 || Integer.parseInt(inputs[4])
				 >= this.cmdAppliedCanvas.getCanvasArray().length-1 || Integer.parseInt(inputs[3]) >= this.cmdAppliedCanvas.getCanvasArray()[0].length-1)
			throw new CanvasException(ExceptionConstant.CANVAS_DRAW_LINE_EXE_BORDER);
		return true;
	}
}
