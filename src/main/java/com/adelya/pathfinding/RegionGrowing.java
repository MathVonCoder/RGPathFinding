/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adelya.pathfinding;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mathieu
 */
public class RegionGrowing {

	protected Board board = null;
	public Region region = new Region();
	public boolean diagonalModeAllowed = true;

	List<Cell> processList = new ArrayList<>();
	int idxCellUnProcessed = 0;

	boolean stop = false;

	public RegionGrowing(Board b) {
		this.board = b;
	}

	protected boolean doStop(Cell c) {
		return false;
	}

	public void grow() {
		// seed from lower corner
		Cell c = new Cell(Board.BOARD_SIZE - 1, 0, null);
		addToProcessList(c);

		doGrow();
	}

	protected void doGrow() {

		Cell c = getFirstUnprocessCell();

		while (c != null && !stop) {
			addSurroundingCell(c);
			c = getFirstUnprocessCell();
		}

	}

	protected void addToProcessList(Cell c) {
		// protect
		if (c.x < 0 || c.y < 0 || c.x >= Board.BOARD_SIZE || c.y >= Board.BOARD_SIZE) {
			return;
		}

		// already in region
		if (region.get(c.x, c.y) == 1) {
			return;
		}
		// do not grow a wall
		if (board.get(c.x, c.y) >= 1) {
			return;
		}

		processList.add(c);
		region.set(c.x, c.y, 1);
		
		// check stop
		doStop(c);
	}

	protected void addSurroundingCell(Cell c) {

		Cell cNW = new Cell(c.x + 1, c.y - 1, c);
		Cell cW = new Cell(c.x + 1, c.y, c);
		Cell cSW = new Cell(c.x + 1, c.y + 1, c);
		Cell cS = new Cell(c.x, c.y + 1, c);
		Cell cSE = new Cell(c.x - 1, c.y + 1, c);
		Cell cE = new Cell(c.x - 1, c.y, c);
		Cell cNE = new Cell(c.x - 1, c.y - 1, c);
		Cell cN = new Cell(c.x, c.y + 1, c);

		if (diagonalModeAllowed) addToProcessList(cNW);
		addToProcessList(cW);
		if (diagonalModeAllowed) addToProcessList(cSW);
		addToProcessList(cS);
		if (diagonalModeAllowed) addToProcessList(cSE);
		addToProcessList(cE);
		if (diagonalModeAllowed) addToProcessList(cNE);
		addToProcessList(cN);
		
		
		c.processed = true;
	}

	protected Cell getFirstUnprocessCell() {
		Cell c = null;
		for (int i = idxCellUnProcessed; i < processList.size(); i++) {
			c = processList.get(i);
			if (!c.processed) {
				idxCellUnProcessed = i + 1;
				return c;
			}
		}
		return c;

	}

}
