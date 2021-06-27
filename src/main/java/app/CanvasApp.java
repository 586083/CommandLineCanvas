package app;

import constant.Constant;
import constant.ExceptionConstant;
import exception.CanvasException;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CanvasApp {
	char[][] canvasArray;
    int w, h;
    public CanvasApp() {}
    
    /**
     * Constructor is used to create the canvas 
     * @param w
     * @param h
     */
    public CanvasApp(int w, int h) {
        if(w < 1 || h < 1) {
            throw new CanvasException(ExceptionConstant.CANVAS_CREATE_EXE);
        }
        h+=2;
        w+=2;
        this.w = w;
        this.h = h;
        this.canvasArray = new char[h][w];
        drawLineWithSpecificCharacters(0, 0, this.w-1, 0, Constant.PIPE_H);
        drawLineWithSpecificCharacters(0, this.h-1, this.w-1, this.h-1, Constant.PIPE_H);
        drawLineWithSpecificCharacters(0, 1, 0, this.h-2, Constant.PIPE_V);
        drawLineWithSpecificCharacters(this.w-1, 1, this.w-1, this.h-2, Constant.PIPE_V);
    }
    
	/**
  	 * This method is used to draw an line with given character
  	 * 
  	 * @param x1 - X1 axis element
  	 * @param y1 - Y1 axis element
  	 * @param x2 - X2 axis element
  	 * @param y2 - Y2 axis element
  	 * @param c  - char to be filled in canvas
  	 * @return
  	 */
  	public char[][] drawLineWithSpecificCharacters(int x1,int y1,int x2,int y2,char c) {
  		try {
	  		for(int i=y1;i<=y2;i++) {
	  			for(int j=x1;j<=x2;j++) {
	  				canvasArray[i][j]=c;
	  			}
	  		}
  		}catch (Exception e) {
  			throw new CanvasException(ExceptionConstant.CANVAS_DRAW_LINE_EXE);
  		}
  		return canvasArray;
  	}
  	
  	/**
  	 * This method converts canvas to string to help printing
  	 * @return
  	 */
  	public String printCanvas() {
  		checkCanvasEmpty();
        StringBuilder strBuilder = new StringBuilder();
        for(int i=0;i<this.h;i++) {
            for(int j=0;j<this.w;j++) {
                strBuilder.append(this.canvasArray[i][j] == '\u0000'?' ':this.canvasArray[i][j]);
            }
            strBuilder.append("\n");
        }
        return strBuilder.toString().trim();
    }
  	
  	/**
  	 * This method check canvas is empty or not
  	 */
  	public boolean checkCanvasEmpty() {
        if(this.canvasArray == null) {
        	return true;
        }else {
        	return false;
        }
    }
}
