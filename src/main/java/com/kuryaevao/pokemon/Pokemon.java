package com.kuryaevao.pokemon;

public class Pokemon {
    String name;// имя покемона
    String type;// тип покемона
    int damage;// урон покемона
    String yell;// боевой клич
    String attack;// основная атака
    int id;// айдишник

    public Pokemon(String name, String type, int damage, String yell, String attack, int id) {
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.yell = yell;
        this.attack = attack;
        this.id = id;
    }

    public static String Battle(){
       return "The great battle begins now!";
    }
}
