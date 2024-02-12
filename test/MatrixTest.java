import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

/* Test failure record:
 * 1.   [Name of test method]  [Method that failed]   [Notes]
 * 2.
 * 3.
 * 4.
 * 5.
 *  ...
 */
class MatrixTest {
    private final static String simpleMatrix = "2 2 1 2 3 4";
    private final static String elementaryMatrix = "2 2 1 0 0 1";
    Matrix matrix = new Matrix(new Scanner(simpleMatrix));

    @Test
    void testEquals() {
    }

    @Test
    void negate() {
    }

    /**Test-1
     * @description Test add() when res is null. The result should be null.
     * Black box test
     */
    @Test
    void add_resIsNull() {
        Matrix y = new Matrix(new Scanner(simpleMatrix));
        assertNull(matrix.add(y,null), "add() doesn't return null when res is null");
    }

    /**Test-2
     * @description Test add() when x is null. The result should be null.
     * Black box test
     */
    @Test
    void add_xIsNull() {
        Matrix x = new Matrix(new Scanner(simpleMatrix));
        Matrix res = new Matrix(x.getHeight(),x.getWidth());
        assertNull(x.add(null,res), "add() doesn't return null when b is null");
    }

    /**Test-3
     * @description Test add() when the height of res is not equal to x. The result should be null.
     * Black box test
     */
    @Test
    void add_resHeightMismatch() {
        Matrix x = new Matrix(new Scanner(simpleMatrix));
        Matrix res = new Matrix(3,x.getWidth());
        assertNull(x.add(null,res), "add() doesn't return null when res's height is incorrect");
    }


    /**Test-4
     * @description Test add() in normal cases.
     * x and y are --> [1 2 3 4]
     * They are 2x2 matrices
     * The result should be [2 4 6 8]
     * Black box test
     */
    @Test
    void add() {
        Matrix x = new Matrix(new Scanner(simpleMatrix));
        Matrix y = new Matrix(new Scanner(simpleMatrix));
        Matrix res = new Matrix(x.getHeight(),x.getWidth());
        x.add(y,res);
        assertEquals(2, res.getElem(1,1),"add() doesn't set (1,1) as we suppose");
        assertEquals(4, res.getElem(1,2),"add() doesn't set (1,2) as we suppose");
        assertEquals(6, res.getElem(2,1),"add() doesn't set (2,1) as we suppose");
        assertEquals(8, res.getElem(2,2),"add() doesn't set (2,2) as we suppose");
    }

    /**4
     * @description Test multiplyWithScalar() when the height of res is not equal to x's
     * x --> [1 2 3 4]  res is a 3 by 2 matrix
     * x is a  2x2 matrices
     * The result should be null
     * Black box test
     */
    @Test
    void multiplyWithScalar_resHeightMismatch() {
        Matrix x = new Matrix(new Scanner(simpleMatrix));
        Matrix res = new Matrix(3,x.getWidth());
        assertNull(x.multiplyWithScalar(2,res), " multiplyWithScalar() doesn't return null when res's height is incorrect");
    }

    /**Test-5
     * @description Test multiplyWithScalar() in normal cases.
     * x --> [1 2 3 4]  scalar is 2
     * x is a  2x2 matrix
     * The result should be [2 4 6 8]
     * Black box test
     */
    @Test
    void multiplyWithScalar() {
        Matrix x = new Matrix(new Scanner(simpleMatrix));
        Matrix res = new Matrix(x.getHeight(),x.getWidth());
        x.multiplyWithScalar(2,res);
        assertEquals(2, res.getElem(1,1),"multiplyWithScalar() doesn't set (1,1) as we suppose");
        assertEquals(4, res.getElem(1,2),"multiplyWithScalar() doesn't set (1,2) as we suppose");
        assertEquals(6, res.getElem(2,1),"multiplyWithScalar() doesn't set (2,1) as we suppose");
        assertEquals(8, res.getElem(2,2),"multiplyWithScalar() doesn't set (2,2) as we suppose");
    }

    /**Test-6
     * @description Test multiplyWithMatrix() when y is null.
     * x --> [1 2 3 4]
     * x is a 2x2 matrix
     * The result should be null
     * Black box test
     */
    @Test
    void multiplyWithMatrix_yIsNull() {
        Matrix x = new Matrix(new Scanner(simpleMatrix));
        Matrix res = new Matrix(x.getHeight(),x.getWidth());
        assertNull(x.multiplyWithMatrix(null, res), "multiplyWithMatrix() doesn't work");
    }

    /**Test-7
     * @description Test multiplyWithMatrix() when the height of res is not equal to x's.
     * x --> [1 2 3 4]  y --> [1 0 0 1]
     * They are 2x2 matrices
     * The result should be null
     * Black box test
     */
    @Test
    void multiplyWithMatrix_resHeightMismatch() {
        Matrix x = new Matrix(new Scanner(simpleMatrix));
        Matrix y = new Matrix(new Scanner(elementaryMatrix));
        Matrix res = new Matrix(3,x.getWidth());
        assertNull(x.multiplyWithMatrix(y, res), "multiplyWithMatrix() doesn't work");
    }

    /**Test-8
     * @description Test multiplyWithMatrix() in normal cases
     * x --> [1 2 3 4]   y --> [1 0 0 1]
     * They are 2x2 matrices
     * The result should be [1 2 3 4]
     * Black box test
     */
    @Test
    void multiplyWithMatrix() {
        Matrix x = new Matrix(new Scanner(simpleMatrix));
        Matrix y = new Matrix(new Scanner(elementaryMatrix));
        Matrix res = new Matrix(x.getHeight(),y.getWidth());
        x.multiplyWithMatrix(y, res);
        assertEquals(1, res.getElem(1,1),"multiplyWithMatrix() doesn't work");
        assertEquals(2, res.getElem(1,2),"multiplyWithMatrix() doesn't work");
        assertEquals(3, res.getElem(2,1),"multiplyWithMatrix() doesn't work");
        assertEquals(4, res.getElem(2,2),"multiplyWithMatrix() doesn't work");
    }

    @Test
    void getElem() {
        assertEquals(2, matrix.getElem(1,2), "getElement() return false value");
    }

    @Test
    void setElem() {
        matrix.setElem(1,2,3);
        assertEquals(3, matrix.getElem(1,2), "setElement() return false value");
    }

    @Test
    void getHeight() {
        assertEquals(1, matrix.getHeight(), "getHeight() return false value");
    }

    @Test
    void getWidth() {
        assertEquals(5, matrix.getWidth(), "getHeight() return false value");
    }
}