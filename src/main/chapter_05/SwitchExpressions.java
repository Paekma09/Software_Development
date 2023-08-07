package main.chapter_05;

public class SwitchExpressions {
    public static void main(String[] args) {
        var dealSage = Stage.LEAD;
        var amount = 10;

        var forecastedAmount = amount * switch (dealSage) {
            case LEAD -> 0.2;
            case EVALUATING -> 0.5;
            case INTERESTED -> 0.8;
            case CLOSED -> 1;
        };

        System.out.println(forecastedAmount);
    }
}
