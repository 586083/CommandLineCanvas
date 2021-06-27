package constant;

import lombok.Getter;

@Getter
public enum ExceptionConstant {
	
	
	CANNOT_PARSE("EXE001","Cannot parse command"),
	CANVAS_ALREADY_EXIST("EXE002","Canavs already exist cannot create new canvas"),
	CANVAS_NOT_EXIST("EXE003","Canavs not exist . Use 'C' to create canvas"),
	INVALID_COLOR("EXE004","Cannot parse command, Color code should not be an digit"),
	CANVAS_CREATE_EXE("EXE005","Canvas cannot be created since width or hight is less than 1"),
	CANVAS_DRAW_LINE_EXE("EXE006","Cannot draw in canvas since given input cannot fit in canvas"),
	CANVAS_SUPPORT_LINE_EXE("EXE007","Canvas support only Horizontil and vertical lines"),
	BUCKET_FILL_INVALID_INPUTS("EXE008","Cannot do bucketfill due to invalid inputs"),
	BUCKET_FILL_EMPTY_CHECK("EXE009","Cannot do bucketfill since given input space falls under a line or boder");
	
	private String code;
	private String message;
	
	
	ExceptionConstant(String exeCode,String exeMessage){
		this.code=exeCode;
		this.message=exeMessage;
	}
}
