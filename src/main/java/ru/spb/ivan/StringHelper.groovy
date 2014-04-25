package ru.spb.ivan
/**
 * Created with IntelliJ IDEA.
 * User: ivan
 * Date: 24.04.14
 * Time: 22:07
 * To change this template use File | Settings | File Templates.
 */
class StringHelper {


    static String binary(int i) {
        binary(i,log2M(i))
    }

    static int log2(int x) {
        int n = 0
        for (int j = 0; Math.pow(2,j) < x; j++ )
            n++
        n
    }

//    static int log2M(int x) {
//        (int)Math.ceil(Math.log(x)/Math.log(2))
//    }
    static int log2Service(int x){
        (int)Math.ceil(Math.log(x)/Math.log(2))
    }

    static int log2M(int x) {
        (int)Math.ceil(Math.log(x)/Math.log(2))
    }

//    static int log4M(int x) {
//        (int)Math.ceil(Math.log(x)/Math.log(4))
//    }

    static String binary(int i, int length) {
        final String zero = "00000000000000000000000000000000"

        String result = Integer.toBinaryString(i)
        int dif = length - result.length()
        if (dif > 0 && result.length() > 0)
            result = zero.substring(0, dif) + result

        result
    }

    static int roundUpLn(int i) {
        Integer.toBinaryString(i).length()
    }

    static void printTableOfFunction(int i) {
        int power = log2M(i)
        String stringI = binary(i,power)

        for (int j = 0; j < power; j++) {
            println(binary(j, log2(power)) + " | " + stringI.charAt(stringI.length() - j - 1))
        }
    }
}
