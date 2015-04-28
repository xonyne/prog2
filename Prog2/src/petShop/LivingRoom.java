package petShop;


import javax.swing.JOptionPane;

import petShop.food.definition.CatFood;
import petShop.food.definition.Food;
import petShop.food.implementation.Cheese;
import petShop.pet.definition.Pet;
import petShop.pet.exception.IllegalNameException;
import petShop.pet.exception.WrongFoodException;
import petShop.pet.implementation.Cat;

public class LivingRoom {
	public static void main (String args[]) throws Exception {
		Pet p = null;
		while (p == null) {
			try {
				String name = JOptionPane.showInputDialog(null, "Name");
				p = new Cat(name);
				System.out.println("Name: " + p.getName());
			} catch (IllegalNameException ex) {
				System.out.println("Gib deinem Tier einen Namen");
			}
		}
		boolean hasEaten = false;
		while (!hasEaten) {
			Food f = null;
			int feedCheese = JOptionPane.showConfirmDialog(null, "Shall it get cheese?");
			if (feedCheese == JOptionPane.YES_OPTION) {
				f = new Cheese();
			}
			try {
				p.feed(f);
				hasEaten=true;
			}catch (WrongFoodException ex) {
				System.out.println("The plate was empty. Pet is still hungry...");
			}
			}
		}
	}
