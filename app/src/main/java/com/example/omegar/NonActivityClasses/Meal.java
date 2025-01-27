package com.example.omegar.NonActivityClasses;
import java.util.Calendar;
import java.io.Serializable;
import java.util.Calendar;

public class Meal implements Serializable, Comparable<Meal> {
    private String name;
    private double omega3;        //mg per 100g of food
    private double omega6;        //mg per 100g of food
    private double amount;        //grams of food
    private double omega3Total;
    private double omega6Total;
    private Calendar mealDate;
    //Add timestamp with custom date
    //Add picture?

    public Meal() {
        this.omega3Total = -1;
        this.omega6Total = -1;
        mealDate = Calendar.getInstance();
    }

    public Meal(String name, double omega3, double omega6, double amount) {
        this.name = name;
        this.omega3 = omega3;
        this.omega6 = omega6;
        this.amount = amount;
        //the date the user input the meal
        mealDate = Calendar.getInstance();

        this.omega3Total = calcTotal(this.omega3, this.amount);
        this.omega6Total = calcTotal(this.omega6, this.amount);
    }

    public Meal(String name, double omega3, double omega6, double amount, Calendar mealDate) {
        this.name = name;
        this.omega3 = omega3;
        this.omega6 = omega6;
        this.amount = amount;
        this.mealDate = mealDate;

        this.omega3Total = calcTotal(this.omega3, this.amount);
        this.omega6Total = calcTotal(this.omega6, this.amount);
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setOmega3(double omega3) {
        this.omega3 = omega3;
    }

    public void setOmega6(double omega6) {
        this.omega6 = omega6;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    //Getters
    public String getName() {
        return this.name;
    }

    public double getOmega3() {
        return this.omega3;
    }

    public double getOmega6() {
        return this.omega6;
    }

    public double getAmount() {
        return this.amount;
    }

    public double getOmega3Total() {
        if (this.omega3Total == -1) {
            System.out.println("Error: Required Omega3 Info Not Found.");
            return 0;
        } else {
            this.omega3Total = calcTotal(this.omega3, this.amount);
            return this.omega3Total;
        }
    }

    public double getOmega6Total() {
        if (this.omega6Total == -1) {
            System.out.println("Error: Required Omega6 Info Not Found.");
            return 0;
        } else {
            this.omega6Total = calcTotal(this.omega6, this.amount);
            return this.omega6Total;
        }
    }


    //returns the day of the month in integer (e.g. 2020-02-23 returns 23)
    public Calendar getMealDate() {
        return this.mealDate;
    }

    public void setMealDateToNow(){

    }

    //General Methods
    private double calcTotal(double omegaAcid, double amount) {
        double total = (omegaAcid * amount) / 100;

        return total;
    }

    public int compareTo(Meal meal2) {
        return this.mealDate.compareTo(meal2.getMealDate());
    }

}

