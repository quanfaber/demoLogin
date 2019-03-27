package com.example.DAO;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.example.week2.DTO.StaffDTO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//</editor-fold>

public class StaffDAO {

    //<editor-fold defaultstate="collapsed" desc="GET CONNECTION">
    public static Connection getConnection() {
        Connection connect = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://192.168.33.10:3306/demo?useServerPrepStmts=false&rewriteBatchedStatements=true&user=mieruca&password=123456");
        } catch (Exception e) {
            System.out.println("x");
        }
        return connect;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="CHECK LOGIN">
    /**
     * @param username check user
     * @param password check password
     *
     * @return StaffDTO if login success then id != 0, otherwise id = 0
     */
    public StaffDTO checkLogin(String username, String password) {
        StaffDTO staff = new StaffDTO();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            String sql = "SELECT * FROM staff WHERE username = ? AND password = ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                staff.setId(rs.getInt("id"));
                staff.setName(rs.getString("name"));
                staff.setPassword(rs.getString("password"));
                staff.setUsername(rs.getString("username"));
                return staff;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="FIND STAFF BY ID">
    public StaffDTO findStaffById(Integer id) {
        StaffDTO staff = new StaffDTO();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            String sql = "SELECT * FROM staff WHERE id = ?;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                staff.setId(rs.getInt("id"));
                staff.setName(rs.getString("name"));
                staff.setPassword(rs.getString("password"));
                staff.setUsername(rs.getString("username"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return staff;
    }
    //</editor-fold>  

    //<editor-fold defaultstate="collapsed" desc="GET ALL STAFF">
    public List<StaffDTO> findAllStaff() {
        List<StaffDTO> listStaff = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            String sql = "SELECT * FROM staff ORDER BY id;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                StaffDTO staff = new StaffDTO();
                staff.setId(rs.getInt("id"));
                staff.setName(rs.getString("name"));
                staff.setPassword(rs.getString("password"));
                staff.setUsername(rs.getString("username"));
                listStaff.add(staff);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listStaff;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="CHECK STAFF USERNAME">
    public boolean checkUsername(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            String sql = "SELECT * FROM staff WHERE username = ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="CHECK STAFF USERNAME EXCEPT BY ID">
    public boolean checkUsernameExceptID(int id, String username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            String sql = "SELECT * FROM staff WHERE id != ? AND username = ?;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, username);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ADD STAFF">
    public boolean addStaff(StaffDTO staff) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            String sql = "INSERT INTO staff ( name, username, password) VALUES (?, ?, ?);";
            ps = con.prepareStatement(sql);
            ps.setString(1, staff.getName());
            ps.setString(2, staff.getUsername());
            ps.setString(3, staff.getPassword());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="UPDATE STAFF">
    public boolean updateStaff(StaffDTO staff) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            String sql = "UPDATE staff SET name= ?, username= ?, password= ? WHERE id = ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, staff.getName());
            ps.setString(2, staff.getUsername());
            ps.setString(3, staff.getPassword());
            ps.setInt(4, staff.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StaffDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="DELETE STAFF">
    public boolean deleteStaff(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = getConnection();
            String sql = "DELETE FROM staff WHERE id = ?;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(StaffDAO.class.getName()).log(Level.SEVERE, null, ex);
//            ex.printStackTrace(); //log lại
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StaffDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    //</editor-fold>

}
