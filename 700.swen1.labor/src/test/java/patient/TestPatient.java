package patient;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class TestPatient {
	// TODO
    @InjectMocks Patient p;

   @Mock AppointmentService as;

   @Mock Appointment a;

   @Mock Appointment b;

   @Before
    public void setUp() {
       Patient p = new Patient("Fred", 23);
       MockitoAnnotations.openMocks(this);
   }

   @Test(timeout = 1000)
    public void validID() {
       boolean have = new Patient("Rofl", 23).getId() > 0;
       assertTrue(have);

   }

   @Test(timeout=1000, expected = IllegalArgumentException.class)
    public void isNameValid() {
       p = new Patient(null, 23);

   }

   @Test(timeout=1000, expected = IllegalArgumentException.class)
    public void isAgeValid() {
       p = new Patient("Flo", -1);
   }

   @Test (timeout=1000)
    public void addAppointmentValid() {
       LocalDateTime time = LocalDateTime.now();
       boolean have = p.addAppointment(time, time.plusMinutes(10));
       assertTrue(have);
   }

   @Test (timeout=1000)
    public void isAppointmentValid() {
       LocalDateTime time = LocalDateTime.now();
       boolean have = p.addAppointment(time, time.minusMinutes(10));
       assertFalse(have);
   }

   @Test (timeout=1000)
    public void averageDurationValid() {
       Mockito.when(a.duration()).thenReturn(10);
       Mockito.when(b.duration()).thenReturn(0);

       int want = 5;
       int have = p.getAverageWaitingTime();
       assertEquals(want, have);
   }


}
