package patient;

import java.time.LocalDateTime;

/**
 * 
 * Patient class represents a patient including all his appointments in the past
 */
public class Patient {
	private static long counter = 0;
	private String name;
	private int age;
	private long id;

	private AppointmentService list;

	public Patient(String name, int age) {
		// TODO validate Input
		this.name = name;
		this.age = age;
		id = counter;

		list = new AppointmentService();
	}

	/**
	 * Add an appointment to the patient's list.
	 * 
	 * @param s start date
	 * @param e end date
	 * @return true, if successful; otherwise false
	 */
	public boolean addAppointment(LocalDateTime s, LocalDateTime e) {
		// TODO validate parameters
		
		list.add(new Appointment(s, e));
		return (true);
	}

	/**
	 * 
	 * @return average waiting time for all appointments in the past
	 */
	public int getAverageWaitingTime() {
		// TODO calculate average waiting time
		return(-1);
	}

	/**
	 * 
	 * @return unique ID of patient
	 */
	public long getId() {
		return (id);
	}

	public String toString() {
		return ("Patient[" + id + "]=" + name + ", " + age);
	}

}
