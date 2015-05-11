package petShop.pet.definition;

import petShop.food.definition.Food;
import petShop.pet.exception.SickException;
import petShop.pet.exception.WrongFoodException;

public interface Pet <F extends Food> {
	public void stroke();
	public void feed(F food) throws WrongFoodException, SickException;
	public boolean isSick();
	public void heal();
	public String getName();
}
