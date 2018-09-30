package cz.system.police.controllers;

import cz.system.police.services.FinesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class PoliceController {


    FinesService finesService;

    public PoliceController(FinesService finesService) {
        this.finesService = finesService;
    }

    @GetMapping("/getAllFines")
    public String getAllFines(Model model){
        model.addAttribute("fines",finesService.getAllFines());

    return "fines/finesAll";
    }

    @GetMapping({"/", "/index"})
    public String dashboard(){
        return "fines/index";
    }

}
