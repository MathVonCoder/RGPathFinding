/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adelya.pathfinding;

/**
 * Class containing the game board 
 * able to draw to the console
 * @author mathieu
 */
public class Board {
	
	public static int BOARD_SIZE = 20;
	
	int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
	
	/**
	 *  init the board with 0
	 */
	protected void init() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {

				board[i][j] = 0;
			}
		}
	}
	
	/**
	 * init the board with 0 or 1, 1 is an obastacle
	 * thresold is a double between 0 and 1, the greater the less obstacle
	 * @param thresold 
	 */
	public void init(double thresold) {
		for (int i=0;i<BOARD_SIZE;i++)
			for (int j=0;j<BOARD_SIZE;j++)
			{
				
				board[i][j]=Math.random() > thresold ? 1 : 0;
			}
		board[0][BOARD_SIZE-1] = 0;
		board[BOARD_SIZE-1][0]=0;
	}
	
	public int get(int i, int j) {
		return board[i][j];
	}

	public void set(int i, int j, int s) {
		board[i][j] = s;
	}
	
	// ========= draw methods ==========

	public boolean drawVerticalLine = false;
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(drawSepLine());
		for (int i=0;i<BOARD_SIZE;i++) {
			//sb.append(drawSepLine());
			for (int j=0;j<BOARD_SIZE;j++) {
				if (drawVerticalLine || j == 0) sb.append("|");
				switch (board[i][j])
				{
					case 0 : sb.append(" ");break;
					case 1 : sb.append("X");break;
					case 2 : sb.append(".");break;
				}
			}
			sb.append("|\n");
		}
		sb.append(drawSepLine());
		return sb.toString();
		
	}

	private String  drawSepLine() {
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<BOARD_SIZE;i++)
		{
			if (drawVerticalLine || i==0) sb.append("+");
			sb.append("-");
		}
		sb.append("+\n");
		return sb.toString();	
	}
	
	protected void copy(Board b) {
		for (int i=0;i<BOARD_SIZE;i++)
			for (int j=0;j<BOARD_SIZE;j++)
				board[i][j] = b.board[i][j];
	}
	
}
