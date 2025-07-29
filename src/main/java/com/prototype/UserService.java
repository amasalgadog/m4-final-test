package com.prototype;

public class UserService {
    private String name;
    private double weight;

    public UserService(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double updateWeight(double newWeight) { 
        //ERROR: En lugar de asignar el nuevo weight, se está restando 1kg.
        //this.weight = -1;
        if (newWeight <= 0) {
            // Esto es un error lógico, ya que no se debe permitir un weight negativo. 
            throw new IllegalArgumentException("Weight cannot be negative or zero");
        }
        this.weight = newWeight; // Aquí se corrige el error original
        return getWeight();
    }

    public void showUserInfo() {
        System.out.println("User: " + name + ", Weight (to date): " + weight + " kg");
    }
}
