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

		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Name muss mindestens ein Zeichen erhalten");
		} else {
			this.name = name;
		}

		if (age < 0) {
			throw new IllegalArgumentException("Name darf nicht negativ sein");
		} else {
			this.age = age;
		}
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

		if (e.isBefore(s)) {
			return false;
		}

		list.add(new Appointment(s, e));
		return (true);
	}

	/**
	 * @return average waiting time for all appointments in the past
	 */
	public int getAverageWaitingTime() {
		// TODO calculate average waiting time
		int duration = 0;

		for (Appointment a : list.getAppointments()) {
			duration += a.duration();
		}

		return (duration / list.getAppointments().length);
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
