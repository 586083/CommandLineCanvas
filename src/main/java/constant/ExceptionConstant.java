package constant;

import lombok.Getter;

@Getter
public enum ExceptionConstant {
	
	
	CANNOT_PARSE("EXE001","Cannot parse command"),
	CANVAS_ALREADY_EXIST("EXE002","Canavs already exist cannot create new canvas"),
	CANVAS_NOT_EXIST("EXE003","Canavs not exist . Use 'C' to create canvas"),
	INVALID_COLOR("EXE004","Cannot parse command, Color code should not be an digit");
	
	private String code;
	private String message;
	
	
	ExceptionConstant(String exeCode,String exeMessage){
		this.code=exeCode;
		this.message=exeMessage;
	}
}
