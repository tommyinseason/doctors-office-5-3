import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class PatientTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/doctorsoffice_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deletePatientsQuery = "DELETE FROM doctors *;";
      String deleteDoctorsQuery = "DELETE FROM patients *;";
      con.createQuery(deletePatientsQuery).executeUpdate();
      con.createQuery(deleteDoctorsQuery).executeUpdate();
    }
  }

  @Test
  public void Task_instantiatesCorrectly_true() {
    Patient myPatient = new Patient("Phil Collins", "05-05-1982", 1);
    assertEquals(true, myPatient instanceof Patient);
  }

  @Test
  public void getNameandGetBirthday_patientInstantiatesWithNameandBirthday_String() {
    Patient myPatient = new Patient("Phil Collins", "05-05-1982", 1);
    assertEquals("Phil Collins", myPatient.getName());
    assertEquals("05-05-1982", myPatient.getBirthdate());
  }
  @Test
   public void all_emptyAtFirst() {
     assertEquals(Patient.all().size(), 0);
   }


}
