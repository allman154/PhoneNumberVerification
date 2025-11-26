import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Staff {
    private List<StaffMember> staffList;

    public Staff() {
    }

    /**
     * Public call to populate Staff data. 
     * @return
     */
    public int populateStaffInformation() {
        int returnCode = 0;
        populateStudentssMock();
        return returnCode;
    }

    /**
     * -- OJDBC METHOD STUB EXAMPLE
     * Populate the list of staff from the database.
     * return 0 if success 1 if error.
     * 
     * @return returnCode
     */
    private int demoPopulateStaff() {
        int returnCode = 0;
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        Connection conn = null;

        // Connect to DB
        try {
            conn = DriverManager.getConnection("URL", "USER", "PASSWORD");
            pstmt = conn.prepareStatement(
                    "   SELECT  users.first_name fname, "
                            + "         users.last_name fname,  "
                            + "         users.id uid       "
                            + "         phonedirectory.phone pnum        "
                            + " FROM    users,    "
                            + "         phonedirectory"
                            + " WHERE   phonedirectory.id = users.id");
            rset = pstmt.executeQuery();
            while (rset.next()) {
                StaffMember sm = new StaffMember();
                sm.setFirstName(rset.getString("fname"));
                sm.setLastName(rset.getString("fname"));
                sm.setIdNumber(rset.getInt("uid"));
                sm.setPhoneNumber("pnum");
                staffList.add(sm);
            }
        }
        // catch SQL errors
        catch (SQLException se) {
            returnCode = 1;
            se.printStackTrace();
        }
        // catch any errors - close the connections
        finally {
            // Close result set
            if (rset != null) {
                try {
                    rset.close();
                } catch (SQLException se) {
                    returnCode = 1;
                }
            }
            // Close prepared statement
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException se) {
                    returnCode = 1;
                }
            }
            // close connection
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException se) {
                    returnCode = 1;
                }
            }
        }

        return returnCode;
    }

    /**
     * Mock populate method for hardcoded results.
     */
    private int populateStudentssMock() {
        int returnCode = 0;
        staffList = new ArrayList<>();
        StaffMember sm;

        sm = new StaffMember();
        sm.setFirstName("Biff");
        sm.setLastName("Tannen");
        sm.setIdNumber(123456);
        sm.setPhoneNumber("123-456-7890");
        staffList.add(sm);
        sm = new StaffMember();
        sm.setFirstName("James");
        sm.setLastName("Kirk");
        sm.setIdNumber(7891011);
        sm.setPhoneNumber("ABC-456-7890");
        staffList.add(sm);
        sm = new StaffMember();
        sm.setFirstName("Marty");
        sm.setLastName("McFly");
        sm.setIdNumber(7891011);
        sm.setPhoneNumber("&9sj,n93kj");
        staffList.add(sm);
        sm = new StaffMember();
        sm.setFirstName("Ellen");
        sm.setLastName("Ripley");
        sm.setIdNumber(7891011);
        sm.setPhoneNumber("1233-4564-78905");
        staffList.add(sm);
        sm = new StaffMember();
        sm.setFirstName("Peggy");
        sm.setLastName("Olson");
        sm.setIdNumber(7891011);
        sm.setPhoneNumber("123-555-7890");
        staffList.add(sm);

        return returnCode;
    }

    public List<StaffMember> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<StaffMember> staffList) {
        this.staffList = staffList;
    }

}
