package controller;

public class Procedure {
    int step;
    String abbreviation;
    int xi;
    int yi;
    int xf;
    int yf;
    int type;

    public Procedure(int step, String abbreviation, int xi, int yi, int xf, int yf, int type) {
        this.step = step;
        this.abbreviation = abbreviation;
        this.xi = xi;
        this.yi = yi;
        this.xf = xf;
        this.yf = yf;
        this.type = type;
    }
}
