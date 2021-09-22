package de.kiltz.neu.in8;

import java.util.Objects;

public class Person {
    private final String name;
    private final int age;
    private final Gender gender;
    private final String favoriteColor;
    private final String city;

    public Person(final String name, final int age) {

        this(name, age, Gender.MALE);
    }

    public Person(final String name, final int age, final String city) {
        this(name, age, Gender.MALE, noFavoriteColor(), city);
    }

    public Person(final String name, final int age, final Gender gender) {
        this(name, age, gender, noFavoriteColor(), noCity());
    }

    public Person(final String name, final int age, final Gender gender,
                  final String favoriteColor, final String city) {
        Objects.requireNonNull(name, "name must not be null");
        Objects.requireNonNull(gender, "gender must not be null");
        Objects.requireNonNull(favoriteColor, "favoriteColor must not be null");
        Objects.requireNonNull(city, "city must not be null");
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.favoriteColor = favoriteColor;
        this.city = city;
    }

    private static String noFavoriteColor() {
        return "";
    }

    private static String noCity() {
        return "";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public boolean livesIn(final String city) {
        return Objects.equals(this.city, city);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", favoriteColor='" + favoriteColor + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
