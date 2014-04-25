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
        def code = 42835
        println("Представление функции как числа: " + code)
        def function = new Number(code)
        println("Представление функции, как двоичного вектора: " + function)
//        def stringFunction = function.toString()
        def stringFunction = "10010101"

        printDefinition(stringFunction)

        createANF(stringFunction)

    }

    static printDefinition(String function) {
        println('Таблица истинности: ')
        def length = function.length()
        def list = createTableOfTrue(StringHelper.log2M(length))
        list.eachWithIndex { String entry, int i ->
            println( entry + " | " + function.charAt(length - 1 - i))
        }
    }

    static List<String> createTableOfTrue(int variables){
        List<String> result =[]
        for (int i = 0; i < Math.pow(2,variables); i++){
            result+=StringHelper.binary(i,variables)
        }

        result
    }

    static createANF(String function){
        def length = function.length()
        def list = createTableOfTrue(StringHelper.log2M(length))
        def matrix = new ANFMatrix(list, function)
        print( matrix)
        matrix.makeANF()
    }
}