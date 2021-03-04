package com.company.standard;

import java.time.ZonedDateTime;

public class Dragon {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long age; //Значение поля должно быть больше 0, Поле может быть null
    private Color color; //Поле не может быть null
    private DragonType type; //Поле не может быть null
    private DragonCharacter character; //Поле не может быть null
    private DragonCave cave; //Поле не может быть null

    public Dragon(Integer id, String name, Coordinates coordinates, Color color, DragonType dragonType, DragonCharacter dragonCharacter, DragonCave dragonCave, ZonedDateTime zonedDateTime){
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.color = color;
        this.type = dragonType;
        this.character = dragonCharacter;
    }

    public void setAge(Long age){
        this.age = age;
    }

    public Integer getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Coordinates getCoordinates(){
        return coordinates;
    }
    public ZonedDateTime getCreationDate(){
        return creationDate;
    }
    public Long getAge(){
        return age;
    }
    public Color getColor(){
        return color;
    }
    public DragonType getType(){
        return type;
    }
    public DragonCharacter getCharacter(){
        return character;
    }
    public DragonCave getCave(){
        return cave;
    }
}
