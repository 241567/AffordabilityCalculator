package com.example.calculator.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



	@Entity
	public class HouseAffordability {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private double downPayment;
	    private double grossIncome;
	    private int tenureYears;
	    private double interestRate;
	    private double otherEMIs;
	    private double affordableHousePrice;
	    private boolean isAffordable;
	    public HouseAffordability() {
	        // Default constructor
	    }
		public HouseAffordability(Long id, double downPayment, double grossIncome, int tenureYears, double interestRate,
				double otherEMIs,double affordableHousePrice,boolean isAffordable) {
			super();
			this.id = id;
			this.downPayment = downPayment;
			this.grossIncome = grossIncome;
			this.tenureYears = tenureYears;
			this.interestRate = interestRate;
			this.otherEMIs = otherEMIs;
			this.affordableHousePrice= affordableHousePrice;
			this.isAffordable= isAffordable;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public double getDownPayment() {
			return downPayment;
		}
		public void setDownPayment(double downPayment) {
			this.downPayment = downPayment;
		}
		public double getGrossIncome() {
			return grossIncome;
		}
		public void setGrossIncome(double grossIncome) {
			this.grossIncome = grossIncome;
		}
		public int getTenureYears() {
			return tenureYears;
		}
		public void setTenureYears(int tenureYears) {
			this.tenureYears = tenureYears;
		}
		public double getInterestRate() {
			return interestRate;
		}
		public void setInterestRate(double interestRate) {
			this.interestRate = interestRate;
		}
		public double getOtherEMIs() {
			return otherEMIs;
		}
		public void setOtherEMIs(double otherEMIs) {
			this.otherEMIs = otherEMIs;
		}
		public double getAffordableHousePrice() {
			return affordableHousePrice;
		}
		public void setAffordableHousePrice(double affordableHousePrice) {
			this.affordableHousePrice = affordableHousePrice;
		}
		public boolean isAffordable() {
			return isAffordable;
		}
		public void setAffordable(boolean isAffordable) {
			this.isAffordable = isAffordable;
		}
		
		
	    
	    
}
