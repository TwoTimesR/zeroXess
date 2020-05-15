package com.zeroxess;

public class Animal {
    public String nameCompany;
    public String typeAnimal;
    public String nameAnimal;
    public double weight;
    public Integer age;
    public double price;

    public Animal(){
        this.nameCompany = "";
        this.typeAnimal="";
        this.nameAnimal = "";
        this.weight = 0;
        this.age = 0;
        this.price = 0;

    }

    public Animal(String nameCompany ,String typeAnimal, String nameAnimal, double weight, Integer age , double price){
        this.nameCompany = nameCompany;
        this.typeAnimal=typeAnimal;
        this.nameAnimal = nameAnimal;
        this.weight = weight;
        this.age = age;
        this.price = price;

    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getNameAnimal() {
        return nameAnimal;
    }

    public void setNameAnimal(String nameAnimal) {
        this.nameAnimal = nameAnimal;
    }

    public double getWeight() {
        return weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
