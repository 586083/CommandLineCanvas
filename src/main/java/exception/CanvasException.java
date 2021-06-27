package exception;

import constant.ExceptionConstant;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CanvasException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String code;
	private String message;
	
	public CanvasException(ExceptionConstant exe) {
       this.code=exe.getCode();
       this.message=exe.getMessage();
    }
}
