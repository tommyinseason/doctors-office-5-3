import java.util.List;
import org.sql2o.*;

public class Patient {
  private int id;
  private String name;
  private String birthday;
  private int doctorId;

  public Patient (String name, String birthday, int doctorId)  {
    this.name = name;
    this.birthday = birthday;
    this.doctorId = doctorId;
  }

  public String getName() {
    return name;
  }

  public String getBirthday() {
    return birthday;
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
