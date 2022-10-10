package com.isquibly;

public interface Gime {
    public int getMagicNumber();
    public int getGuess();
    public void setGuess(int guess);
    public int getRangeLo();
    public int getRangeHi();
    public int getRemainingGuesses();

    public int getGuessCount();
    public void reset();
    public void check();
    public boolean isValidNumberRange();
    public boolean isGimeWon();
    public boolean isGimeLost();
}
