import java.util.List;
import org.sql2o.*;

public class Doctor {
  private int id;
  private String name;
  private String speciality;

  public Doctor(String name, String speciality) {
    this.name = name;
    this.speciality = speciality;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getSpeciality() {
    return speciality;
  }
  public static List<Doctor> all() {
    String sql = "SELECT id, name FROM Doctors";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Doctor.class);
    }
  }

}
