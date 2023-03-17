package com.rohit.tshirt_search;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Tshirt{

	public Tshirt() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
    private String Id;
    private String Name;
    private String Color;
    private String Gender;
    private String Size;
    private double Price;
    private float Rating;
    private String Availability;


    public  Tshirt(String Id, String Name, String Color, String Gender, String Size, double Price, float Rating,String Availability) {
        this.Id = Id;
        this.Name = Name;
        this.Color = Color;
        this.Gender = Gender;
        this.Size = Size;
        this.Price = Price;
        this.Rating = Rating;
        this.Availability=Availability;
    }
    

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public float getRating() {
        return Rating;
    }

    public void setRating(float rating) {
        Rating = rating;
    }

    public String getAvailability() {
        return Availability;
    }

    public void setAvailability(String availability) {
        Availability = availability;
    }

	@Override
	public String toString() {
		return "Tshirt [Id=" + Id + ", Name=" + Name + ", Color=" + Color + ", Gender=" + Gender + ", Size=" + Size
				+ ", Price=" + Price + ", Rating=" + Rating + ", Availability=" + Availability + "]";
	}
}