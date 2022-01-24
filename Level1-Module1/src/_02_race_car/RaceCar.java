package _02_race_car;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */



public class RaceCar {
	private String brand;
	private int positionInRace;
	public boolean damaged = false;
	
	/**
	 * 
	 * @param brand Brand of race car
	 * @param positionInRace Position of race car in the race
	 */
	public RaceCar(String brand, int positionInRace) {
		System.out.println("Your " +brand +" race car has been created.");
		if (positionInRace <= 0)
			throw new IllegalArgumentException("The car's position cannot be negative.");
		else if (positionInRace > 15) 
			throw new IllegalArgumentException("There are only 15 cars in the race.");
		
		this.brand = brand;
		this.positionInRace = positionInRace;
	}
	
	public int getPositionInRace() {
		return this.positionInRace;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	/**
	 * Checks if car need a pit stop
	 * @return needsPitStop
	 */
	boolean isDamaged() {
		return damaged;
	}
	/**
	 * Brings the car in for a pit stop.
	 */
	public void pit() {
		if (damaged) {
			damaged = false;
			System.out.println("The car has been pitted.");
		}
		else
			System.out.println("The car does not need a pit stop.");	
	}
	
	/**
	 * Crashes the car. It falls back three positions and needs a pit stop.
	 */
	public void crash() {
		positionInRace += 3;
		if (positionInRace > 15) 
			positionInRace = 15;
		damaged = true;
		System.out.println("\nYour car has been damaged and needs a pit stop.\nThree cars zoomed by you.");
	}
	
	/**
	 * Overtakes the next car in the race.
	 */
	public void overtake() {
		if (positionInRace <= 1)
			System.out.println("The car is already in the lead.");
		else {
			positionInRace--;
			System.out.println("Your car has moved into position number "+positionInRace+"!");
		}
	}
}
