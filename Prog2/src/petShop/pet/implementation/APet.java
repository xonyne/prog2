package petShop.pet.implementation;

import petShop.food.definition.Food;
import petShop.pet.definition.Pet;
import petShop.pet.exception.IllegalNameException;

public abstract class APet<F extends Food> implements Pet<F> {
	private final String name;
	private boolean isSick;
	
	public APet (String name) throws IllegalNameException
	{
		if (name == null)
			throw new IllegalNameException();
		this.name = name;
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	public void setSick(boolean isSick) {
		this.setSick(isSick);
	}
	
	public boolean isSick() {
		return this.isSick;
	}
	
	public void heal(){
		this.isSick=false;
	}
	

}
