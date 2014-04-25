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
//        for (int j = 1; j < max; j++) {
//            print (new Number(j) + " ")
//            println(j + " " + new Number(j, StringHelper.log2M(j)))
//            println(j + ' ' + StringHelper.log2M(j) )
//        }

        printDefinition(function.toString())
    }

    static printDefinition(String function) {
        println('Таблица истинности: ')
        def length = function.length()
        for (int i = 0; i < length; i++) {
            println(StringHelper.binary(i, StringHelper.log2(length)) + " | " + function.charAt(length - 1 - i))
        }
    }
}