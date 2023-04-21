package com.kuryaevao.pokemon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", "Lightning", 100, "PIKACHUUUUUU!!!", "Lightning bolt!", 1);
        Pokemon charmander = new Pokemon("Charmander", "Fire", 90, "CHAR CHAR!!!", "Fire breath!", 2);
        Pokemon squirtle = new Pokemon("Squirtle", "Water", 80, "SQUIRTLE!!!", "Water canon!", 3);
        Pokemon attackingPokemon = null;
        Pokemon defendingPokemon = null;

        System.out.println(pikachu.name + " yells " + pikachu.yell + " and uses " + pikachu.attack + " That attack deals " + pikachu.damage + " damage!");
        System.out.println();
        System.out.println(charmander.name + " yells " + charmander.yell + " and uses " + charmander.attack + " That attack deals " + charmander.damage + " damage!");
        System.out.println();
        System.out.println(squirtle.name + " yells " + charmander.yell + " and uses " + charmander.attack + " That attack deals " + squirtle.damage + " damage!");
        System.out.println();

        System.out.println("Select attacking pokemon");
        System.out.println("1 - Pikachu");
        System.out.println("2 - Charmander");
        System.out.println("3 - Squirtle");

        Scanner scanner = new Scanner(System.in);
        int input1 = scanner.nextInt();

        if (input1 == pikachu.id) {
            attackingPokemon = pikachu;
            System.out.println("Your attacking pokemon is " + attackingPokemon.name);
        } else if (input1 == charmander.id) {
            attackingPokemon = charmander;
            System.out.println("Your attacking pokemon is " + attackingPokemon.name);
        } else if (input1 == squirtle.id) {
            attackingPokemon = squirtle;
            System.out.println("Your attacking pokemon is " + attackingPokemon.name);
        } else {
            System.out.println("There is no such pokemon");
            System.exit(0);
        }
        System.out.println();

        System.out.println("Select defending pokemon");
        System.out.println("1 - Pikachu");
        System.out.println("2 - Charmander");
        System.out.println("3 - Squirtle");

        Scanner scanner2 = new Scanner(System.in);
        int input2 = scanner2.nextInt();

        if (input2 == pikachu.id) {
            defendingPokemon = pikachu;
            System.out.println("Enemy's defending pokemon is " + defendingPokemon.name);
        } else if (input2 == charmander.id) {
            defendingPokemon = charmander;
            System.out.println("Enemy's defending pokemon is " + defendingPokemon.name);
        } else if (input2 == squirtle.id) {
            defendingPokemon = squirtle;
            System.out.println("Enemy's defending pokemon is " + defendingPokemon.name);
        } else {
            System.out.println("There is no such pokemon");
            System.exit(0);
        }
        System.out.println();
        System.out.println(Pokemon.Battle());
        System.out.println();
        System.out.println(attackingPokemon.yell + " - Your " + attackingPokemon.name + " deals " + attackingPokemon.damage + " damage by using " + attackingPokemon.attack);
        System.out.println(defendingPokemon.yell + " - Enemy's " + defendingPokemon.name + " deals " + defendingPokemon.damage + " damage by using " + defendingPokemon.attack);
        System.out.println();

        if (attackingPokemon.damage > defendingPokemon.damage) {
            System.out.println(attackingPokemon.name + " is a winner!");
        } else {
            System.out.println(defendingPokemon.name + " is a winner!");
        }
    }
}
