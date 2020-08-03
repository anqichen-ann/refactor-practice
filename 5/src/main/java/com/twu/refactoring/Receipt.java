package com.twu.refactoring;

public class Receipt {
    private static final int FIXED_CHARGE = 50;
    private static final double PEAK_TIME_MULTIPLIER = 1.2;
    private static final int RATE_CHANGE_DISTANCE = 10;
    private static final int[] NON_AC_RATE = {15, 12};
    private static final int[] AC_RATE = {20, 17};
    private static final double SALES_TAX_RATE = 0.1;

    private final Taxi taxi;

    public Receipt(Taxi taxi) {
        this.taxi = taxi;
    }

    public double getTotalCost() {
        double totalCost;

        int totalKms = taxi.getTotalKms();
        if(taxi.isAirConditioned()) {
            totalCost = ConditionCost(totalKms, AC_RATE);
        } else {
            totalCost = ConditionCost(totalKms, NON_AC_RATE);
        }

        return (totalCost + FIXED_CHARGE) * (1 + SALES_TAX_RATE);
    }

    public double ConditionCost(int totalKms, int[] RATE) {
        double result = 0;
        if (totalKms > RATE_CHANGE_DISTANCE) {
            result += RATE_CHANGE_DISTANCE*RATE[0]+(totalKms-RATE_CHANGE_DISTANCE)*RATE[1];
        } else {
            result += totalKms*RATE[0];
        }
        return taxi.isPeakTime() ? result*PEAK_TIME_MULTIPLIER : result;
    }}
