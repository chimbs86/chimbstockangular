package com.jdriven.ng2boot;

import java.util.List;

import static java.lang.Math.floor;
import static java.lang.Math.floorMod;

/**
 * Created by chimbs on 7/7/17.
 */
public class InvestmentCalculator {
    private final List<Historic> historics;
    private final double monthly;
    private final String name;

    public InvestmentCalculator(List<Historic> historics, double monthly, String name) {
        this.historics = historics;
        this.monthly = monthly;
        this.name = name;
    }

    public String getReturn() {
        StringBuffer sb = new StringBuffer();
        sb.append("If you were to invest $"+monthly+" each month in " + name +" starting "+historics.get(historics.size()-1).getDate()+ "  \n<p> ");
        double balance = monthly;
        int stock = 0;
        for (Historic historic : historics) {
            int current = (int) floor(  balance / historic.getValue());
            int curBalance = floorMod( (int) balance, (int) historic.getValue());
            double stockValuePurchased = current * historic.getValue();
            balance -= stockValuePurchased;
            balance += monthly;
            stock += current;
        }
        double today = historics.get(0).getValue() * stock;
        sb.append("today, you would have $"+today +" and some spare change of $"+balance+" insted of $" + historics.size()*monthly);
        return sb.toString();
    }

}
