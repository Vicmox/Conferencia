/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.conferenciaUFPS.conferencias.controller;

import com.conferenciaUFPS.conferencias.entity.Conferencia;
import com.conferenciaUFPS.conferencias.repository.ConferenciaRepository;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/view")
public class VistaController {

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/conferencia")
    public String showView() {

        return "conferencias";
    }

}
