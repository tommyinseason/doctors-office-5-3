import java.util.List;
import org.sql2o.*;

public class Patient {
  private int id;
  private String name;
  private String birthdate;
  private int doctorId;

  public Patient (String name, String birthdate, int doctorId)  {
    this.name = name;
    this.birthdate = birthdate;
    this.doctorId = doctorId;
  }

  public String getName() {
    return name;
  }

  public String getBirthdate() {
    return birthdate;
  }

  public int getDoctorId() {
    return doctorId;
  }
  public static List<Patient> all() {
    String sql = "SELECT name, birthdate, doctorId FROM patients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Patient.class);
    }
  }
}
