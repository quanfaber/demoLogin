package com.example.week2.service;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.example.DAO.StaffDAO;
import com.example.week2.DTO.StaffDTO;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//</editor-fold>

@Service
@Component
public class StaffServiceImpl implements StaffService {

    StaffDAO demoDAO = new StaffDAO();

    //<editor-fold defaultstate="collapsed" desc="CHECK LOGIN">
    @Override
    public int checkLogin(String username, String password) {
        StaffDTO staff = demoDAO.checkLogin(username, password);
        if (staff == null) {
            return 0;
        }
        if (staff.getPassword().equals(password)) {
            return staff.getId();
        }
        return 0;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="FIND STAFF BY ID">
    @Override
    public StaffDTO findStaffById(Integer id) {
        return demoDAO.findStaffById(id);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="FIND ALL STAFF">
    @Override
    public List<StaffDTO> findAllStaff() {
        List<StaffDTO> staffs = demoDAO.findAllStaff();
        return staffs;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="CHECK STAFF USERNAME">
    @Override
    public boolean checkUsername(String username) {
        return demoDAO.checkUsername(username);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="CHECK STAFF USERNAME EXCEPT BY ID">
    @Override
    public boolean checkUsernameExceptID(int id, String username){
        return demoDAO.checkUsernameExceptID(id, username);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ADD STAFF">
    @Override
    public boolean addStaff(StaffDTO staff) {
        return demoDAO.addStaff(staff);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="UPDATE STAFF">
    @Override
    public boolean updateStaff(StaffDTO staff) {
        return demoDAO.updateStaff(staff);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="DELETE STAFF">
    @Override
    public boolean deleteStaff(int id) {
        return demoDAO.deleteStaff(id);
    }
    //</editor-fold>

}
