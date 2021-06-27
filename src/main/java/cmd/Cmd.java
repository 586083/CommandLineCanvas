package cmd;

import app.CanvasApp;
import constant.ExceptionConstant;
import exception.CanvasException;

public abstract class Cmd {
	CanvasApp cmdAppliedCanvas;
	
	//This method will be over ride in each command class 
	public abstract CanvasApp excuteCmd(String[] inputs);
	
	//check entered command are valid else throws exception
	public boolean checkValidCommand(String[] inputs,int length) throws CanvasException{
		if(inputs != null && inputs.length == length) {
			try {
				for(int i=1;i<inputs.length;i++) {
					Integer.parseInt(inputs[i]);
				}
			}catch(NumberFormatException exe) {
				throw new CanvasException(ExceptionConstant.CANNOT_PARSE);
			}
		}else {
			throw new CanvasException(ExceptionConstant.CANNOT_PARSE);
		}
		return true;
	}
}
