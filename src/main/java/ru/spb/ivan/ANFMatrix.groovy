package ru.spb.ivan

/**
 * Created with IntelliJ IDEA.
 * User: ivan
 * Date: 25.04.14
 * Time: 4:47
 * To change this template use File | Settings | File Templates.
 */
class ANFMatrix {
    int dimension
    int[][] matrix
    List<String> names
    final String alphabet ="abcdefgh"


    ANFMatrix(List<String> codes, String function) {
        if (codes.size() != function.length())
            throw new Exception("A different size from codes & functions")
        this.dimension = codes.size()
        this.matrix = new char[dimension][dimension]
        char[] charArray = function.toCharArray()
        for (int i = 0; i < dimension; i++) {
            matrix[i][0] = Integer.parseInt(charArray[dimension - i - 1].toString())
        }
        for (int j = 1; j < dimension; j++) {
            for (int i = 0; i < dimension - j; i++) {
                matrix[i][j]= matrix[i][j-1] == matrix[i+1][j-1] ? 0 : 1
            }
        }
        def temp = new ArrayList<String>(dimension)
        codes.each {
            String name = ""
               for (int i =0; i<it.length();i++)
                   if (it.substring(i,i+1) == "1")
                       name+=alphabet.charAt(i).toString()
            if (name.length() == 0)
                name = "1"
            temp.add(name)
        }
        this.names = temp
    }

    String toString() {
        names.each {
            print(it + "\t")
        }
        print "\n\n"
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension - i; j++) {
                print(matrix[i][j])
                print "\t"
            }
            println ""
        }
    }

    String makeANF(){
        println ""
        for (int i = 0; i<dimension;i++){
            if (matrix[0][i] == 1)
                print(names.get(i) + " ")
        }
    }
}
