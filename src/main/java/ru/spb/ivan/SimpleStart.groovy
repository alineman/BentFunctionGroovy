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
//        def code = 147
        def code = 39664
        println("Представление функции как числа: " + code)
        def function = new Number(code)
        println("Представление функции, как двоичного вектора: " + function)
        def stringFunction = function.toString()
//        def stringFunction = "10010011"
//        def stringFunction = "1001101011110000"

        printDefinition(stringFunction)

        createANF(stringFunction)
        println("")
        for (int k = 0; k < function.maxValue; k++)
            println("AssumeWalsh: " + assumeWalsh(function, k))


    }

    static printDefinition(String function) {
        println('Таблица истинности: ')
        def length = function.length()
        def list = createTableOfTrue(StringHelper.log2M(length))
        list.eachWithIndex { String entry, int i ->
            println(entry + " | " + function.charAt(length - 1 - i))
        }
    }

    static List<String> createTableOfTrue(int variables) {
        List<String> result = []
        for (int i = 0; i < Math.pow(2, variables); i++) {
            result += StringHelper.binary(i, variables)
        }

        result
    }

    static createANF(String function) {
        def length = function.length()
        def list = createTableOfTrue(StringHelper.log2M(length))
        def matrix = new ANFMatrix(list, function)
        print(matrix)
        matrix.makeANF()
    }

    static int assumeWalsh(Number function, int vector) {
        int result = 0
        for (int u = 0; u < function.maxValue; u++) {
            def uv = weightHammingF(u & vector)
            def fu = Integer.parseInt(function.get(u))
            result += Math.pow(-1, uv ^ fu).intValue()
        }
        result
    }

    static int weightHammingF(int vector) {
        int result = 0
        while (vector != 0) {
            result = result + (vector % 2)
            vector = vector / 2
        }
        result
    }
}