
// Example class Time with overloaded consructors

import java.text.DecimalFormat;
import java.util.TimerTask;

public class Time extends TimerTask
{
	private int hour; // 0 - 23
	private int minute; // 0 - 59
	private int second; // 0 - 59

	// Time constructor initializes each instance variable
	// to zero. Ensures that Time object starts in a
	// consistent state.
	public Time()
	{
		setTime(0, 0, 0);
	}

	// Time constructor: hour supplied, minute and second
	// defaulted to 0
	public Time(int h)
	{
		setTime(h, 0, 0);
	}

	// Time constructor: hour and minute supplied, second
	// defaulted to 0
	public Time(int h, int m)
	{
		setTime(h, m, 0);
	}

	// Time constructor: hour, minute and second supplied
	public Time(int h, int m, int s)
	{
		setTime(h, m, s);
	}

	// Time constructor: another Time object supplied
	public Time(Time time)
	{
		setTime(time.getHour(), time.getMinute(), time.getSecond());
	}

	// Set Methods
	// Set a new time value using universal time. Perform
	// validity checks on data. Set invalid values to zero.
	public void setTime(int h, int m, int s)
	{
		setHour(h); // set the hour
		setMinute(m); // set the minute
		setSecond(s); // set the second
	}

	// validate and set hour
	public void setHour(int h)
	{
		hour = ((h >= 0 && h < 24) ? h : 0);
	}

	// validate and set minute
	public void setMinute(int m)
	{
		minute = ((m >= 0 && m < 60) ? m : 0);
	}

	// validate and set second
	public void setSecond(int s)
	{
		second = ((s >= 0 && s < 60) ? s : 0);
	}

	// Get Methods
	// get hour value
	public int getHour()
	{
		return hour;
	}

	// get minute value
	public int getMinute()
	{
		return minute;
	}

	// get second value
	public int getSecond()
	{
		return second;
	}

	public void incrementMinute()
	{
		// Pr�fe ob das Inkrement der Minute 60 ergibt
		// falls ja Inkrementiere hour aber pr�fe
		// ob das Inkrement der Stunde 24 ergibt
		// falls ja setze Stunde auf 0
		// falls nein inkrementiere Stunde.
		if (minute + 1 == 60)
		{
			incrementHour();
			minute = 0;
		}
		else
		{
			minute++;
		}
	}

	public void incrementHour()
	{
		if (hour + 1 == 24)
		{
			hour = 0;
		}
		else
		{
			hour++;
		}
	}

	public void tick()
	{
		if (second + 1 == 60)
		{
			incrementMinute();
			second = 0;
		}
		else
		{
			second++;
		}
	}

	// convert to String in standard-time format
	public String toString()
	{
		DecimalFormat twoDigits = new DecimalFormat("00");

		return ((getHour() == 12 /* || getHour() == 0 */) ? 12 : getHour() % 12) + ":"
				+ twoDigits.format(getMinute()) + ":" + twoDigits.format(getSecond())
				+ (getHour() < 12 ? " AM" : " PM");
	}

	@Override
	public void run()
	{
		
		
	}

} // end class Time
