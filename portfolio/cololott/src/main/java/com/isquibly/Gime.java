package com.isquibly;


public class Gime {
    private final String name, gimeCode;
    private final int pickCount, mainLo, mainHi, extraLo, extraHi;

    public Gime(String name, String gimeCode, int pickCount, int mainLo, int mainHi, int extraLo, int extraHi) {
        this.name = name;
        this.gimeCode = gimeCode;
        this.pickCount = pickCount;
        this.mainLo = mainLo;
        this.mainHi = mainHi;
        this.extraLo = extraLo;
        this.extraHi = extraHi;
    }

    public String getName() {
        return name;
    }

    public String getGimeCode() {
        return gimeCode;
    }

    public int getPickCount() {
        return pickCount;
    }

    public int getMainLo() {
        return mainLo;
    }

    public int getMainHi() {
        return mainHi;
    }

    public int getExtraLo() {
        return extraLo;
    }

    public int getExtraHi() {
        return extraHi;
    }

    @Override
    public String toString() {
        return "Gime{" +
                "name='" + name + '\'' +
                ", gimeCode='" + gimeCode + '\'' +
                ", pickCount=" + pickCount +
                ", mainLo=" + mainLo +
                ", mainHi=" + mainHi +
                ", extraLo=" + extraLo +
                ", extraHi=" + extraHi +
                '}';
    }
}
