/* Complex Class
   Anderson, Franceschi
*/

public class Complex
{
  private double real;
  private double imaginary;

  /**
  * Overloaded constructor:<BR>
  * Allows client to set beginning values for real and imaginary
  * This constructor takes two parameters<BR>
  * Calls mutator methods to validate new values
  * @param newReal the real part of the complex number
  * @param newImaginary the imaginary part of the complex number
  */
  public Complex( double newReal, double newImaginary )
  {
    setReal( newReal );
    setImaginary( newImaginary );
  }

  /** getReal method
  * @return the real part of the complex number
  */
  public double getReal( )
  {
    return real;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of real
  * @param newReal the new real part of the complex number
  */
  public void setReal( double newReal )
  {
    real = newReal;
  }

  /** getImaginary method
  * @return the imaginary part of the complex number
  */
  public double getImaginary( )
  {
    return imaginary;
  }

  /**
  * Mutator method:<BR>
  * Allows client to set value of imaginary
  * @param newImaginary the new imaginary part of the complex number
  */
  public void setImaginary( double newImaginary )
  {
    imaginary = newImaginary;
  }

  /**
  * @return the complex number as x + yi
  */
  public String toString( )
  {
    String result = real + "";
    if ( imaginary < 0 )
      result += ( " - " + ( -imaginary ) + "i" );
    else if ( imaginary > 0 )
      result += ( " + " + imaginary + "i" );
    return result;
  }

  /**
  * equals method
  * Compares two Complex objects for the same field values
  * @param o another Complex object
  * @return a boolean, true if this object
  * has the same field values as the parameter c
  */
  public boolean equals( Object o )
  {
	if ( ! ( o instanceof Complex ) )
	   return false;
	else
	{
		Complex c = (Complex) o;
        return ( real == c.real && imaginary == c.imaginary );
	}
  }

  /**
  * isReal method
  * @return a boolean, true if the imaginary part is considered equal to 0
  */
  public boolean isReal( )
  {
    return ( Math.abs( imaginary ) < 0.0001 );
  }
}