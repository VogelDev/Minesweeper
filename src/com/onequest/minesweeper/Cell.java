package com.onequest.minesweeper;

/**
 * An individual cell for the minesweeper game
 * 
 * @author Rob Vogel
 *
 */
public class Cell {
    int manyBombs;
    boolean isBomb;
    boolean isHidden;

    public Cell() {
        manyBombs = 0;
        isBomb = false;
        isHidden = true;
    }

    public int getManyBombs() {
        return manyBombs;
    }

    public void setManyBombs(int manyBombs) {
        this.manyBombs = manyBombs;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean isBomb) {
        this.isBomb = isBomb;
    }

    public void incBombs() {
        manyBombs++;
    }

    @Override
    public String toString() {
        if(isHidden()){
            return "?";
        }else if(isBomb()){
            return "X";
        }else if(manyBombs == 0){
            return " ";
        }else{
            return String.valueOf(manyBombs);
        }
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }
}
