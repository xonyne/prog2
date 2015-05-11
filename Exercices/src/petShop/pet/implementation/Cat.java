package petShop.pet.implementation;

import petShop.food.definition.CatFood;
import petShop.pet.exception.IllegalNameException;
import petShop.pet.exception.SickException;
import petShop.pet.exception.WrongFoodException;

public class Cat extends APet<CatFood>{

	public Cat(String name) throws IllegalNameException {
		super(name);
	}

	@Override
	public void stroke() {
		System.out.println("Prrrrrrr Prrrrrrrrrrr");
	}

	@Override
	public void feed(CatFood food) throws WrongFoodException, SickException {
		if (food == null) {
			super.setSick(true);
			throw new WrongFoodException();
		}
		if (super.isSick()) {
			throw new SickException();
		}
		System.out.println("Mampf: " + food.getClass().getName());		
	}

}
