package com.techelevator.controller;

import com.techelevator.model.Pothole;
import com.techelevator.model.PotholeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PotholeRestController {

    @Autowired
    private PotholeDAO potholeDAO;
    private Pothole pothole;

    @RequestMapping(path="/setCoordinates", method = RequestMethod.POST)
    public int setCoordinates(Pothole pothole) {
    potholeDAO.reportPothole(pothole);
    return 0;
    }

    @RequestMapping(path="/getCoordinates", method = RequestMethod.GET)
    public List<Pothole> getCoordinates(HttpServletRequest request) {
        String orderBy = "report_date";
        List<Pothole> potholes = potholeDAO.getListOfPotholes(orderBy);
        return potholes;
    }
}
