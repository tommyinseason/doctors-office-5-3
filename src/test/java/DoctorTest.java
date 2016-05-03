import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;


public class DoctorTest {

  @Before
    public void setUp() {
      DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/doctorsoffice_test", null, null);
  }

  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deleteDoctorsQuery = "DELETE FROM doctors *;";
      String deletePatientsQuery = "DELETE FROM patients *;";
      con.createQuery(deleteDoctorsQuery).executeUpdate();
      con.createQuery(deletePatientsQuery).executeUpdate();
    }
  }
  @Test
  public void getName_DoctorInstantiatesWithName_String() {
    Doctor myDoctor = new Doctor("Phil Collins", "Lobotomist");
    assertEquals("Phil Collins", myDoctor.getName());
  }
  @Test
   public void all_emptyAtFirst() {
     assertEquals(Doctor.all().size(), 0);
   }
}
