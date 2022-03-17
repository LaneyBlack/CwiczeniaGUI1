package com.bits.squad.c1.classes;

import java.util.ArrayList;
import java.util.Arrays;

public class Squad {
    private String name;
    private Hero[] heroes;
    private Leader leader;
    private int counterOfHeroes;

    public Squad(String name) {
        this.name = name;
        counterOfHeroes=0;
        heroes = new Hero[1];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    @Override
    public String toString() {
        String heroesNames = "";
        for (int i = 0; i < heroes.length; i++) {
            heroesNames = heroes[i].getName() + ", ";
        }
        return name + ", leader: " + leader.getName()+", heroes: " + heroesNames ;
    }

    public void addHero(Hero hero) throws TooManyHeroesException {
        try {
            heroes[counterOfHeroes] = hero;
            counterOfHeroes++;
        } catch (Exception e) {
            throw new TooManyHeroesException("Too Many Heroes!");
        }
    }
}
