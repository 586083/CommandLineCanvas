package cmd;

import java.util.LinkedList;
import java.util.Queue;

import app.CanvasApp;
import constant.Constant;
import constant.ExceptionConstant;
import exception.CanvasException;

public class BucketFillCanvasBFS extends Cmd{

	/**
	 * Create an local copy of canvas for command execution
	 * @param canvasApp
	 */
	public BucketFillCanvasBFS(CanvasApp canvasApp) {
		this.cmdAppliedCanvas=canvasApp;
	}

	/**
	 * Does bucket fill in canavas
	 */
	@Override
	public CanvasApp excuteCmd(String[] inputs) {
		if(this.checkValidCommand(inputs,4)) {
			if(this.cmdAppliedCanvas.checkCanvasEmpty()) {
				throw new CanvasException(ExceptionConstant.CANVAS_NOT_EXIST);
			}else {
				int x=Integer.parseInt(inputs[1]);
				int y=Integer.parseInt(inputs[2]);
				char mchar=inputs[3].charAt(0);
				bucketFill(this.cmdAppliedCanvas.getCanvasArray(),y,x,mchar);
			}
		}
		return this.cmdAppliedCanvas;
	}
	
	/**
	 * @author aravinthrajchakkaravarthy
	 * Capture co-ordinate details
	 */
	static class Cordinate
	{
	    int height, width;
	     
	    public Cordinate(int h, int w) 
	    {
	        this.height = h;
	        this.width = w;
	    }   
	}
	
	
	/**
	 * before push to stack validate whether the cell eligible for fill
	 * @param vis
	 * @param adjHeight
	 * @param adjWidth
	 * @param input
	 * @param colourToBechanged
	 * @param currentColor
	 * @return
	 */
	private boolean isValidToFill(boolean[][] vis,int adjHeight, int adjWidth,char[][] input,char colourToBechanged,char currentColor)
	{
	     
	    // If cell lies out of bounds
	    if (adjHeight <= 0 || adjWidth <= 0 || adjHeight >= input.length || adjWidth >= input[0].length)
	        return false;
	    
	    // If cell already has the color value
	    if(input[adjHeight][adjWidth] == colourToBechanged)
	    return false;
	    	
	    //if cell is not having current color, because current color cell only should be pushed for replacement
	    if(input[adjHeight][adjWidth] != currentColor)
		    return false;
	    
	    //if cell is 'x' then already line drawn, so dont add to stack
	    if(input[adjHeight][adjWidth] == Constant.CROSS)
	    	return false;
	    		
	    //if already visited then no need to add to list
	    if(vis[adjHeight][adjWidth])
	    	return false;
	    
	    // Otherwise
	    return true;
	}
		
	private void bucketFill(char[][] input,int height,int width,char c) {
		
		//Direction vectors
		int[] dh = { 1,0,-1,-1,-1,0,1,1};
		int[] dW = { -1,-1,-1,0,1,1,1,0};
		
		// Stores indices of the matrix cells
	    Queue<Cordinate > q = new LinkedList<Cordinate>();
	    
	    //visited elements
	    boolean[][] vis=new boolean[input.length][input[0].length];
	    
	    // Mark the starting cell as visited
	    // and push it into the queue
	    q.add(new Cordinate(height, width));
	    vis[height][width]=true;
	    
	    //current color
	    char currentColor=input[height][width];
	    		
	    // Iterate while the queue
	    // is not empty
	    while (!q.isEmpty())
	    {
	    	Cordinate cell=q.peek();
	    	int h1=cell.height;
	    	int w1=cell.width;
	    	
	    	input[h1][w1]=c;
	    	q.remove();
	    	
	    	//Go to adjacent cells
	    	for(int i=0;i<dh.length;i++) {
	    		int adjHeight = h1 + dh[i];
	            int adjWidth = w1 + dW[i];
	            if(isValidToFill(vis,adjHeight,adjWidth,input,c,currentColor)) {
	            	q.add(new Cordinate(adjHeight, adjWidth));
	            	vis[adjHeight][adjWidth]=true;
	            }
	    	}
	    }
	}
	
	 
	//check entered command are valid else throws exception
	public boolean checkValidCommand(String[] inputs,int length) throws CanvasException{
		if(inputs != null && inputs.length == length) {
			try {
				for(int i=1;i<inputs.length-1;i++) {
					Integer.parseInt(inputs[i]);
				}
				if(Character.isDigit(inputs[length-1].charAt(0))) {
					throw new CanvasException(ExceptionConstant.INVALID_COLOR);
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
