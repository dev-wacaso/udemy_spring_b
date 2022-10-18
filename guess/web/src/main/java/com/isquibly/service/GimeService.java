package com.isquibly.service;

public interface GimeService {
    public boolean isGimeOver();
    public String getMainMessage();
    public String getResultMessage();
    public void checkGuess(int guess);
    public void reset();
}
