/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adelya.pathfinding;


/**
 *
 * @author mathieu
 */
public class Main {

	public static void main(String[] args) {
		Board b = new Board();
		b.init(0.75);
		System.out.println(b.toString());

		/*
		RegionGrowing rg = new RegionGrowing(b);
		rg.grow();
		System.out.println(rg.region);
		 */
		PathFinder pf = new PathFinder(b);
		pf.start = new Cell(Board.BOARD_SIZE - 1,0,null);
		pf.end = new Cell(0, Board.BOARD_SIZE - 1,null);
		pf.diagonalModeAllowed = false;
		
		pf.grow();
		if (pf.region.get(pf.end.x, pf.end.y) != 1) {
			System.out.println("No path");
			System.out.println(pf.region);
		} else {

			System.out.println(pf.path);
		}

	}
}
