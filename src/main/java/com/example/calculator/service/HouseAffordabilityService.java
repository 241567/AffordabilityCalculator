package com.example.calculator.service;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.calculator.entity.HouseAffordability;
import com.example.calculator.exceptions.NotFoundException;
import com.example.calculator.repository.HouseAffordabilityRepository;

@Service
public class HouseAffordabilityService {
    @Autowired
    private HouseAffordabilityRepository houseAffordabilityRepository;

    // Method to calculate the affordable house price
    public double calculateAffordableHousePrice(HouseAffordability houseAffordability) {
        double monthlyGrossIncome = houseAffordability.getGrossIncome() / 12;
        double monthlyOtherEMIs = houseAffordability.getOtherEMIs();
        int tenureMonths = houseAffordability.getTenureYears() * 12;
        double monthlyInterestRate = (houseAffordability.getInterestRate() / 100) / 12;
        double loanAmount = houseAffordability.getDownPayment();
        double affordableEMI = (monthlyGrossIncome * 0.3) - monthlyOtherEMIs;
        
        while (tenureMonths > 0) {
            double interest = (loanAmount * monthlyInterestRate);
            double principal = (affordableEMI - interest);
            loanAmount -= principal;
            tenureMonths--;
        }

        // Round the affordable house price to 2 decimal places
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        loanAmount = Double.parseDouble(df.format(loanAmount));

        return houseAffordability.getDownPayment() + loanAmount;
    
    }

    // Method to save a house affordability record
    public HouseAffordability saveHouseAffordability(HouseAffordability houseAffordability) {
        double affordableHousePrice = calculateAffordableHousePrice(houseAffordability);
        houseAffordability.setAffordableHousePrice(affordableHousePrice); // Set the calculated affordable house price
        
        // Check if affordable house price is greater than or equal to down payment
        if (affordableHousePrice >= houseAffordability.getDownPayment()) {
            houseAffordability.setAffordable(true); // Set isAffordable to true
        } else {
            houseAffordability.setAffordable(false); // Set isAffordable to false
        }
        
         return houseAffordabilityRepository.save(houseAffordability);
    }
    
 // Method to get HouseAffordability by id
    public HouseAffordability getHouseAffordabilityById(Long id) {
        return houseAffordabilityRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("HouseAffordability not found with id: " + id));
    }

}
