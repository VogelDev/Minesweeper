package com.onequest.minesweeper;

import java.util.Arrays;

public class Board {
    Cell[][] field;

    public Board(int size) {
        field = new Cell[size][size];

        initField();
        initBombs();
    }

    private void initBombs() {
        int x;
        int y;
        for (int i = 0; i < field.length; i++) {
            do {
                x = (int) (Math.random() * field.length);
                y = (int) (Math.random() * field.length);
            } while (field[x][y].isBomb);

            field[x][y].setBomb(true);
            incBombs(x, y);

        }
    }

    private void incBombs(int x, int y) {
        if (x - 1 >= 0) {
            field[x - 1][y].incBombs();
            if (y - 1 >= 0) {
                field[x - 1][y - 1].incBombs();
            }
            if (y + 1 < field.length) {
                field[x - 1][y + 1].incBombs();
            }
        }

        if (x + 1 < field.length) {
            field[x + 1][y].incBombs();
            if (y - 1 >= 0) {
                field[x + 1][y - 1].incBombs();
            }
            if (y + 1 < field.length) {
                field[x + 1][y + 1].incBombs();
            }
        }

        if (y + 1 < field.length) {
            field[x][y + 1].incBombs();
        }

        if (y - 1 >= 0) {
            field[x][y - 1].incBombs();
        }
    }

    private void initField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new Cell();
            }
        }
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                output += field[i][j];
            }
            output += "\n";
        }
        
        return output;
    }
    
    public void reveal(int x, int y){
        if(field[x][y].isHidden()){
            field[x][y].setHidden(false);
        }
    }

}
