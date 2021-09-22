package appendix.streams;

import java.util.Objects;

/**
 * Diese Klasse modelliert eine person auf simple Weise.
 * Dient fuer viele Beispiele als Grundlage. 
 * 
 * @author Michael Inden
 * 
 * Copyright 2014, 2015, 2017 by Michael Inden 
 */
public class Person
{
    private final String name;
    private final int    age;
    private final Gender gender;
    private String       city;
    
    public Person(final String name, final int age)
    {
        this(name, age, Gender.MALE);
    }

    public Person(final String name, final int age, final String city)
    {
        this(name, age, Gender.MALE, city);
    }

    public Person(final String name, final int age, final Gender gender)
    {
        this(name, age, gender, noCity());
    }

    public Person(final String name, final int age, final Gender gender, final String city)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.city = city;
    }

    private static String noCity()
    {
        return "";
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getAge()
    {
        return age;
    }

    public Gender getGender()
    {
        return gender;
    }

    public boolean isAdult()
    {
        return age >= 18;
    }

    public boolean livesIn(final String city)
    {
        return Objects.equals(this.city, city);
    }     
    
    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    @Override
    public String toString()
    {
        if (city.isEmpty())
        {
            return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
        }

        return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", city=" + city + "]";
    }
    
    public void prettyPrint()
    {
        System.out.println("Person [" + name + " (" + age + "/" + gender.toString().charAt(0)+ ") from " + city + "]");
    }    
}