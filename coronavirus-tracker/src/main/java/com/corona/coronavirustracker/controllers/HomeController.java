/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.corona.coronavirustracker.controllers;

import com.corona.coronavirustracker.models.LocationStats;
import com.corona.coronavirustracker.servises.CoronaVirusDataService;
import java.text.NumberFormat;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author PC
 */

@Controller
public class HomeController {
    
    @Autowired
    CoronaVirusDataService coronaVirusDataService;
    
    @GetMapping("/")
    public String home(Model model) {
        List<LocationStats> allStats = coronaVirusDataService.getAllStats();
        int totalReportedCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
        NumberFormat number = NumberFormat.getInstance(); 
        number.setMaximumFractionDigits(3);
        String TotalNewCasesFormated = number.format(totalNewCases);
        String TotalReportedCasesFormated = number.format(totalReportedCases);
        model.addAttribute("totalNewCases", TotalNewCasesFormated);
        model.addAttribute("LocationStats", coronaVirusDataService.getAllStats());
        model.addAttribute("totalReportedCases", TotalReportedCasesFormated);
        return "home";
    }
    
}
