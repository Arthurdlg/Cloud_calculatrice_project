package com.Calculatrice;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/calculatrice")
public class CalculatriceController {

    @GetMapping("/addition")
    public double addition(@RequestParam double a, @RequestParam double b) {
        return a + b;
    }

    @GetMapping("/soustraction")
    public double soustraction(@RequestParam double a, @RequestParam double b) {
        return a - b;
    }

    @GetMapping("/multiplication")
    public double multiplication(@RequestParam double a, @RequestParam double b) {
        return a * b;
    }

    @GetMapping("/division")
    public double division(@RequestParam double a, @RequestParam double b) {
        if (b == 0) throw new IllegalArgumentException("Division par zéro impossible !");
        return a / b;
    }

    @GetMapping("/puissance")
    public double puissance(@RequestParam double a, @RequestParam double b) {
        return Math.pow(a, b);
    }

    @GetMapping("/racine")
    public double racine(@RequestParam double a) {
        if (a < 0) throw new IllegalArgumentException("Nombre négatif !");
        return Math.sqrt(a);
    }
}
