/* ComplexPair Class
   Anderson, Franceschi
*/

public class ComplexPair
{
  private Complex first;
  private Complex second;

  /**
  * Overloaded constructor:<BR>
  * Allows client to set beginning values for first and second
  * This constructor takes two parameters<BR>
  * Calls mutator methods to validate new values
  * @param newFirst the first of the two complex numnbers
  * @param newSecond the second of the two complex numbers
  */
  public ComplexPair( Complex newFirst, Complex newSecond )
  {
    setFirst( newFirst );
    setSecond( newSecond );
  }

  /** getFirst method
  * @return the first complex number
  */
  public Complex getFirst( )
  {
    return new Complex( first.getReal( ), first.getImaginary( ) );
  }
  /**
  * Mutator method:<BR>
  * Allows client to set value of first
  * @param newFirst the new first complex number
  */
  public void setFirst( Complex newFirst )
  {
    first = new Complex( newFirst.getReal( ), newFirst.getImaginary( ) );
  }

  /** getSecond method
  * @return the second complex number
  */
  public Complex getSecond( )
  {
    return new Complex( second.getReal( ), second.getImaginary( ) );
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of second
  * @param newSecond the new second complex number
  */
  public void setSecond( Complex newSecond )
  {
    second = new Complex( newSecond.getReal( ), newSecond.getImaginary( ) );
  }

  /**
  * @return the first and second complex number for the pair of complex numbers
  */
  public String toString( )
  {
    return( "first: " + first + "; second: " + second );
  }

  /**
  * equals method
  * Compares two ComplexPair objects for the same field values
  * @param o another ComplexPair object
  * @return a boolean, true if this object
  * has the same field values as the parameter cp
  */
  public boolean equals( Object o )
  {
	if ( ! ( o instanceof ComplexPair ) )
	  return false;
	else
	{
	  ComplexPair cp = (ComplexPair) o;
      return ( first.equals( cp.first )
               && second.equals( cp.second ) );
    }
  }

  /**
  * bothIdentical method
  * @return a boolean, true if first and second are equal in value
  */
  public boolean bothIdentical( )
  {
    return ( first.equals( second ) );
  }
}