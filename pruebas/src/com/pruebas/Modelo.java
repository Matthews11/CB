package com.pruebas;

public class Modelo {
	
	String name;
	
	Integer price;

	public Modelo(String name, Integer price) {
		this.name=name;
		this.price=price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Persona name: " + name + ", price: " + price;
	}
	
	

}
