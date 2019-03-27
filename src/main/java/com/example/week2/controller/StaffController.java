package com.example.week2.controller;

//<editor-fold defaultstate="collapsed" desc="IMPORT">
import com.example.week2.DTO.StaffDTO;
import com.example.week2.service.StaffService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//</editor-fold>

@Controller
public class StaffController {

    @Autowired
    @Lazy
    StaffService staffService;

    //<editor-fold defaultstate="collapsed" desc="GET HOME PAGE">
    @GetMapping(value = {"/", "/home"})
    public String home(HttpSession session, ModelMap modelMap) {
        if (session.getAttribute("id") == null) {
            return "redirect:/login";
        }
        int id = Integer.parseInt(session.getAttribute("id").toString());
        StaffDTO staff = staffService.findStaffById(id);
        modelMap.addAttribute("staff", staff);
        return "home";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET LOGIN PAGE">
    @GetMapping(value = "/login")
    public String moveToLoginPage(HttpSession session) {
        if (session.getAttribute("id") != null) {
            return "redirect:/home";
        }
        return "login";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="LOGIN">
    @PostMapping(value = "/login")
    public String login(HttpServletRequest request,
            @RequestParam Map<String, String> req, RedirectAttributes redirectAttributes) {
        int loginId = staffService.checkLogin(req.get("username"), req.get("password"));
        if (staffService.checkUsername(req.get("username"))) {
            if (loginId != 0) {
                HttpSession session = request.getSession();
                session.setAttribute("id", loginId);
                return "redirect:/home";
            }
            redirectAttributes.addFlashAttribute("error", "Password is not correct!");
            return "redirect:/login";
        }
        redirectAttributes.addFlashAttribute("error", "Account is not correct!!!");
        return "redirect:/login";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="GET REGISTER PAGE">
    @GetMapping(value = "/register")
    public String moveToRegisterPage(HttpSession session) {
        if (session.getAttribute("id") != null) {
            return "redirect:/home";
        }
        return "register";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="REGISTER">
    @PostMapping(value = "/register")
    public String register(@RequestParam Map<String, String> req, RedirectAttributes redirectAttributes) {
        if (staffService.checkUsername(req.get("username"))) {
            redirectAttributes.addFlashAttribute("error", "This Username already exist.!");
            return "redirect:/register";
        }
        StaffDTO staff = new StaffDTO();
        staff.setName(req.get("name"));
//        staff.setPassword(utils.EncrytedPasswordUtils.encrytePassword(req.get("password")));
        staff.setPassword(req.get("password"));
        staff.setUsername(req.get("username"));
        staffService.addStaff(staff);
        redirectAttributes.addFlashAttribute("msg", "You have successfully registered!!!");
        return "redirect:/login";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="LOGOUT">
    @GetMapping(value = "/signout")
    public String signout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ADD STAFF PAGE">
    @GetMapping(value = "/new-staff")
    public String loadAddPage(HttpSession session) {
        if (session.getAttribute("id") == null) {
            return "redirect:/login";
        }
        return "add";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ADD STAFF">
    @PostMapping(value = "/add-staff")
    public String addStaff(@RequestParam Map<String, String> req, RedirectAttributes redirectAttributes) {
        if (staffService.checkUsername(req.get("username"))) {
            redirectAttributes.addFlashAttribute("msg", "Please choose another Username!");
            return "redirect:/new-staff";
        }
        StaffDTO staff = new StaffDTO();
        staff.setName(req.get("name"));
        staff.setPassword(req.get("password"));
        staff.setUsername(req.get("username"));
        staffService.addStaff(staff);
        /* missing return add result */
        redirectAttributes.addFlashAttribute("msg", "Add Staff: " + req.get("name") + " success!!!");
        return "redirect:/list";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="UPDATE STAFF PAGE">
    @GetMapping(value = "/edit/{id}")
    public String editStaffPage(HttpSession session, Model model, @PathVariable Integer id) {
        if (session.getAttribute("id") == null) {
            return "redirect:/login";
        }
        StaffDTO staff = staffService.findStaffById(id);
        model.addAttribute("staff", staff);
        return "edit";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="UPDATE STAFF">
    @PostMapping(value = "/edit/{id}")
    public String updateStaff(@PathVariable Integer id,
            @RequestParam Map<String, String> req,
            RedirectAttributes redirectAttributes) {
        /* if new username is exist, then notify replace another username */
        if (staffService.checkUsernameExceptID(id, req.get("username"))) {
            redirectAttributes.addFlashAttribute("msg", "Please choose another Username!");
            return "redirect:/edit/" + id;
        }
        StaffDTO staff = new StaffDTO();
        staff.setId(id);
        staff.setName(req.get("name"));
        staff.setPassword(req.get("password"));
        staff.setUsername(req.get("username"));
        /* if update staff method success, notify and return list page, otherwise notify error */
        if (staffService.updateStaff(staff)) {
            redirectAttributes.addFlashAttribute("msg", "Update info success!");
            return "redirect:/list";
        }
        redirectAttributes.addFlashAttribute("msg", "An error has occured! Please contact us.");
        return "redirect:/edit/" + id;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="DELETE STAFF">
    @GetMapping(value = "/delete/{id}")
    public String deleteStaff(HttpSession session, @PathVariable Integer id, Model model) {
        int idSession = (int) session.getAttribute("id");
        /* can not delete your current account */
        if (idSession == id) {
            model.addAttribute("error", "Can't delete yourself!!!");
            return "forward:/list";
        }
        if (staffService.deleteStaff(id)) {
            model.addAttribute("msg", "Deleted!");
            return "forward:/list";
        }
        model.addAttribute("error", "An error has occured! Please contact us.");
        return "forward:/list";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="LIST STAFF">
    @GetMapping(value = "/list")
    public String listStaff(Model model, HttpSession session) {
        if (session.getAttribute("id") == null) {
            return "redirect:/login";
        }
        model.addAttribute("staffList", staffService.findAllStaff());
        /* Highlight row of your id*/
        model.addAttribute("staffId", session.getAttribute("id"));
        return "list";
    }
    //</editor-fold>

}
