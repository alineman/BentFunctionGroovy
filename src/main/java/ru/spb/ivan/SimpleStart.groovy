package ru.spb.ivan
/**
 * Created with IntelliJ IDEA.
 * User: ivan
 * Date: 24.04.14
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */
class SimpleStart {

    public static void main(String[] args) {
        def max = 31
        for (int j = 1; j < max; j++) {
//            print (new Number(j) + " ")
            println(j + " " + new Number(j, StringHelper.log2M(max)))
        }

//        printDefinition(max)
    }

    static printDefinition(int function) {
        Number number = new Number(function)
        int radix = number.getPower()
        println(number.getPower())
        println number
        def maxValue = number.getMaxValue()
        for (int i = 0; i <= maxValue; i++) {
            println((new Number(i, StringHelper.log2M(maxValue)).toString() + " | " + number.get(i)))
        }
    }

}
