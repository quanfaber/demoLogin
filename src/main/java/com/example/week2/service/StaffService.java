package com.example.week2.service;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.example.week2.DTO.StaffDTO;
import java.util.List;
//</editor-fold>

public interface StaffService {

    public int checkLogin(String usernam, String password);
    
    StaffDTO findStaffById(Integer id);
    
    List<StaffDTO> findAllStaff();
    
    public boolean addStaff(StaffDTO staff);
    
    public boolean updateStaff(StaffDTO staff);
    
    public boolean deleteStaff(int id);
    
    public boolean checkUsername(String username);
    
    public boolean checkUsernameExceptID(int id, String username);
}
