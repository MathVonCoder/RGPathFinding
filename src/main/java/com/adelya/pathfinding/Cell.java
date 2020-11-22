/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adelya.pathfinding;

/**
 * base class for processList in region growing
 * @author mathieu
 */
public class Cell {

		boolean processed = false;
		Cell parent = null;
		int x, y;

		Cell(int x, int y, Cell parent) {
			this.x = x;
			this.y = y;
			this.parent = parent;
		}

		@Override
		public boolean equals(Object o) {

			if (this == o) {
				return true;
			}

			if (o == null) {
				return false;
			}

			Cell c = (Cell) o;
			return (c.x == this.x && c.y == this.y);
		}
	}
