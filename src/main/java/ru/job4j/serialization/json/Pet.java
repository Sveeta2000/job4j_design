package ru.job4j.serialization.json;

import java.util.Arrays;
import java.util.Objects;

public class Pet {
    private String petName;
    private boolean isGirl;
    private int age;
    private Owner owner;
    private String[] vaccines;

    public Pet(String petName, boolean isGirl, int age, Owner owner, String[] vaccines) {
        this.petName = petName;
        this.isGirl = isGirl;
        this.age = age;
        this.owner = owner;
        this.vaccines = vaccines;
    }

    public String getPetName() {
        return petName;
    }

    public boolean isGirl() {
        return isGirl;
    }

    public int getAge() {
        return age;
    }

    public Owner getOwner() {
        return owner;
    }

    public String[] getVaccines() {
        return vaccines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pet pet = (Pet) o;
        return isGirl == pet.isGirl && Objects.equals(petName, pet.petName)
                && Objects.equals(owner, pet.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(petName, isGirl, owner);
    }

    @Override
    public String toString() {
        return "Pet{"
                + "petName='" + petName + '\''
                + ", isGirl=" + isGirl
                + ", age=" + age
                + ", owner=" + owner
                + ", vaccines=" + Arrays.toString(vaccines)
                + '}';
    }
}
