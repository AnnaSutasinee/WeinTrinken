package patient;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TestPatient {
	// TODO
    @InjectMocks Patient p;

   @Mock AppointmentService as;

   @Before
    public void setUp() {
       Patient p = new Patient("Fred", 23);
       MockitoAnnotations.openMocks(this);
   }

   @Test(timeout = 1000)
    public void validID() {

   }


}
