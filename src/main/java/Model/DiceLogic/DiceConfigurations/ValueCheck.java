package Model.DiceLogic.DiceConfigurations;

public class ValueCheck {
    public static boolean isInCorrectRange(int value1){
        return value1 > 0 && value1 < 7;

    }
    public static boolean isInCorrectRange(int value1, int value2){
        return isInCorrectRange(value1) && isInCorrectRange(value2);
    }
}
