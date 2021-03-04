package com.company.standard;

public class Coordinates {
    private Double x; //Значение поля должно быть больше -648, Поле не может быть null
    private int y; //Максимальное значение поля: 803

    public Coordinates(Double x){
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Double getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}