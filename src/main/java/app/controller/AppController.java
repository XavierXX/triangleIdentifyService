package app.controller;

import java.math.BigDecimal;

import app.domain.Triangle;
import app.service.TriangleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Autowired
    TriangleService triangleService;


    @RequestMapping("/triangle")
    public Triangle getTriangleType(@RequestParam(name="sideA", required = true)BigDecimal sideA,
                                    @RequestParam(name="sideB", required = true)BigDecimal sideB,
                                    @RequestParam(name="sideC", required = true)BigDecimal sideC) {
        return triangleService.getTriangleType(sideA, sideB, sideC);
    }
}
