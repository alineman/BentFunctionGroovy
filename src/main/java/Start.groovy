/**
 * Created with IntelliJ IDEA.
 * User: ivan
 * Date: 24.04.14
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */
class Start extends StringHelper {

    public static void main(String[] args) {

        for (int k = 1; k< 64; k++)
        println (k + " " +  binary(k,log2M(k)))
        def k = 12
        println log2(k)
        println log2M(k)
        println binary(k)
        printTableOfFunction(k)
    }

}
