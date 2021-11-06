package com.pb.kopejkin.hw6;

import java.lang.reflect.Method;

public class VetClinic {
    public static void main(String[] args) throws Exception {
        Animal animal = new Animal();
        Dog dog = new Dog("Собака", "Гав", "Мясо", "в Будке");
        Cat cat = new Cat("Кот", "Мяу", "Вискас", "в Одеяле");
        Horse horse = new Horse("Лошадь", "Игого", "Траву", "в Конюшне");

        Animal[] animals = new Animal[] {dog, cat, horse};

        System.out.println("food и location животнотного на приеме:");

        Class<Veterinarian> clazz = Veterinarian.class;
        Method method = clazz.getMethod("treatAnimal", Animal.class);
        for (Animal i: animals) {
            Object o = clazz.newInstance();
            method.invoke(o, i);
        }

        System.out.println("\nЖивотное");
        animal.makeNoise();
        animal.eat();
        animal.sleep("Животное");

        System.out.println("Собака");
        dog.makeNoise();
        dog.eat();
        dog.sleep(dog.getNameAnimal());

        System.out.println("Кот");
        cat.makeNoise();
        cat.eat();
        cat.sleep(cat.getNameAnimal());

        System.out.println("Лошадь");
        horse.makeNoise();
        horse.eat();
        horse.sleep(horse.getNameAnimal());
    }
}