/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adelya.pathfinding;

/**
 * based on region growing implements a stop condition
 * and add a method to draw the path to the console
 * @author mathieu
 */
public class PathFinder extends RegionGrowing {

	Board path = new Board();
	public Cell start, end;
	
	public PathFinder(Board b) {
		super(b);
	}

	@Override
	protected boolean doStop(Cell c) {
		if (c.equals(end)) {
			this.stop = true;
			drawPath(c);
		}

		return stop;
	}
	
	public void drawPath(Cell c) {
		
		path.init();
		path.copy(board);
		
		do
		{
			path.set(c.x, c.y,2);
			c = c.parent;
		} while (c!= null && !c.equals(start));
		
		path.set(start.x,start.y,2);
	}

}
