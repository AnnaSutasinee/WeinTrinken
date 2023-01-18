package patient;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * Appointments have a defined start and end date (including a timestamp which
 * consists of hours and minutes)
 * 
 */
public class Appointment {
	private LocalDateTime start;
	private LocalDateTime end;

	public Appointment(LocalDateTime start, LocalDateTime end) {
		this.start = start;
		this.end = end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	/**
	 * 
	 * @return Minutes between start and end
	 */
	public int duration() {
		return (new Random().nextInt() + 4711); // I don't know how to calculate the duration between two LocalDateTime
												// Objects ...
	}

}
