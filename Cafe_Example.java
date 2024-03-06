package Exception_Example;

public class Cafe_Example{
	
	public static void main (String [] args) {
	 	person one=new person();
		try
		{
			one.drinkCofee(90);
			System.out.println ("Coffee tasted fine");
		}
		catch( TooColdException c)
		{
			System.out.println("Coffee is too cold...warm it again");
		}
		catch( TooHotException h)
		{
			System.out.println("Coffee is too hot...bring it after some time");
		}
		finally
		{
			System.out.println("Person Left");
		}
	}
}



abstract class TemperatureException extends Exception {
    private int temperature; // in Celsius
    public TemperatureException() {
	System.out.println("Temperature exception occurred");
    }
}

class TooColdException extends TemperatureException {
    public TooColdException() {
        super();
	System.out.println("Coffe is too cold");
	}
}

class TooHotException extends TemperatureException {
    public TooHotException() {
        super();
	System.out.println("Coffe is too hot");
	}
}


class person{
void drinkCofee (int temperature) throws TooColdException, TooHotException
{
	if (temperature <= 65) {
           		 throw new TooColdException();
        }
        else if (temperature >= 85) {
            	throw new TooHotException();
        }

}
}

