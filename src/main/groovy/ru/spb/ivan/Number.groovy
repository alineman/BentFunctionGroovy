package ru.spb.ivan
/**
 * Created with IntelliJ IDEA.
 * User: ivan
 * Date: 25.04.14
 * Time: 0:34
 * To change this template use File | Settings | File Templates.
 */
class Number {
    private String stringView
    private int power
    private int value
    private int maxValue
    private int lengthString

    int getLengthString() {
        return lengthString
    }

    Number(int value) {
        this(value, StringHelper.log2M(value) as int)
    }

    Number(int value, int power) {
        if (value < 1 ) {
            this.value = 0
            this.stringView = StringHelper.binary(0, power)
        }
        this.value = value

        this.power = power
        this.maxValue = (int) Math.pow(2, StringHelper.log2M(power))
        this.lengthString = StringHelper.log2M(maxValue)
        this.stringView = StringHelper.binary(value, maxValue)
    }

    String get(int i) {
        stringView.charAt(maxValue - i -1)
    }

    String toString() {
        stringView
    }

    int getPower() {
        return power
    }

    int getMaxValue() {
        return maxValue
    }

}
