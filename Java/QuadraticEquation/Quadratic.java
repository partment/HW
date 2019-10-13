/* Quadratic Class
   Anderson, Franceschi
*/

public class Quadratic
{
  // the equation is ax^2 + bx + c = 0
  // we assume that a and b are not both equal to 0
  private int a;
  private int b;
  private int c;
  private String comment;

  /**
  * Overloaded constructor:<BR>
  * Allows client to set beginning values for a, b, c, and d
  * This constructor takes four parameters<BR>
  * Calls mutator methods to validate new values
  * @param newA the coefficient of x^2 in the quadratic equation
  * @param newB the coefficient  of x in the quadratic equation
  * @param newC the constant coefficient in the quadratic equation
  */
  public Quadratic( int newA, int newB, int newC )
  {
    setA( newA );
    setB( newB );
    setC( newC );

    if ( a == 0 )
    {
      // we assume here that b is different from 0 when a = 0
      comment = "Linear equation: one real root";
    }
    else if ( discriminant( ) == 0 )
      comment = "Double real root";
    else if ( discriminant( ) > 0 )
      comment = "Two distinct real roots";
    else
      comment = "Two distinct complex roots";
  }

  /** getA method
  * @return the coefficient of x^2 in the quadratic equation
  */
  public int getA( )
  {
    return a;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of a
  * @param newA the new coefficient of x^2
  */
  public void setA( int newA )
  {
    a = newA;
  }

  /** getB method
  * @return the coefficient of x in the quadratic equation
  */
  public int getB( )
  {
    return b;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of b
  * @param newB the new coefficient of x
  */
  public void setB( int newB )
  {
    b = newB;
  }

  /** getC method
  * @return the constant coefficient in the quadratic equation
  */
  public int getC( )
  {
    return c;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of c
  * @param newC the new constant coefficient
  */
  public void setC( int newC )
  {
    c = newC;
  }

  /** getComment method
  * @return a comment regarding the general solutions of the quadratic equation
  */
  public String getComment( )
  {
    return comment;
  }

  /**
  * @return the quadratic equation as ax^2 + bx + c = 0
  */
  public String toString( )
  {
    String result = "";
    if ( a != 0 && a != 1 && a != -1)
      result += ( a + " x^2 " );
    else if ( a == 1 )
      result += "x^2 ";
    else if ( a == -1 )
      result += "-x^2 ";
    if ( b < 0 )
      result += ( "- " + ( -b ) + " x" );
    else if ( b > 0 )
      result += ( "+ " + b + " x" );
    if  ( c < 0 )
      result += ( " - " + ( -c ) );
    else if ( c > 0 )
      result += ( " + " + c );
    result += " = 0";
    return result;
  }

  /**
  * equals method
  * Compares two Quadratic objects for the same field values
  * @param o another Quadratic object
  * @return a boolean, true if this object
  * has the same field values as the parameter q
  */
  public boolean equals( Object o )
  {
	if ( ! ( o instanceof Quadratic ) )
	  return false;
	else
	{
      Quadratic q = (Quadratic) o;
      return ( a == q.a && b == q.b && c == q.c );
    }
  }

  /**
  * discriminant method
  * Computes the discriminant of the quadratic equation
  * @return an int, the discriminant of the quadratic equation
  */
  private int discriminant( )
  {
    return ( b * b - 4 * a * c );
  }

  /**
  * hasDistinctRealRoots method
  * Checks if the quadratic equation has two distinct real roots
  * @return a boolean, true if the discriminant is strictly positive
  */
  public boolean hasDistinctRealRoots( )
  {
    return ( discriminant( ) > 0 );
  }

  /**
  * hasDoubleRealRoot method
  * Checks if the quadratic equation has a double real roots
  * @return a boolean, true if the discriminant is equal to 0
  */
  public boolean hasDoubleRealRoot( )
  {
    return ( discriminant( ) == 0 );
  }

  /**
  * solveQuadratic method
  * Solves the quadratic equation
  * @return a ComplexPair, representing the two complex roots
  *   of the quadratic equation
  */
  public ComplexPair solveQuadratic( )
  {
    ComplexPair result;
    Complex firstRoot, secondRoot;
    int discrim = discriminant( );
    if ( a == 0 )
    {
      // we assume here that b is different from 0 when a = 0
      firstRoot = new Complex( -c / b, 0 );
      result = new ComplexPair( firstRoot, firstRoot );
    }
    else if ( discrim == 0 )
    {
      firstRoot = new Complex( -b / ( 2 * a ) , 0 );
      result = new ComplexPair( firstRoot, firstRoot );
    }
    else if ( discrim > 0 )
    {
      firstRoot = new Complex( ( -b + Math.sqrt( discrim ) ) / ( 2 * a ) , 0 );
      secondRoot = new Complex( ( -b - Math.sqrt( discrim ) ) / ( 2 * a ) , 0 );
      result = new ComplexPair( firstRoot, secondRoot );
    }
    else
    {
      firstRoot = new Complex( -b / ( 2 * a ), Math.sqrt( -discrim ) / ( 2 * a ) );
      secondRoot = new Complex( -b / ( 2 * a ), - Math.sqrt( -discrim ) / ( 2 * a ) );
      result = new ComplexPair( firstRoot, secondRoot );
    }
    return result;
  }
}