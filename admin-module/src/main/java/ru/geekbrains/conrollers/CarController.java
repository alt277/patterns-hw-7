package ru.geekbrains.conrollers;


import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.geekbrains.entity.Car;
import ru.geekbrains.entity.CarMemento;
import ru.geekbrains.entity.Exterior;
import ru.geekbrains.entity.Interior;
import ru.geekbrains.services.*;

import java.io.IOException;
import java.sql.SQLException;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
@RequestMapping("/car")
public class CarController {

    private CarService carService;
    private InteriorService interiorService;
    private ExteriorService exteriorService;
    private CarMemento carMemento;
    private CarMementoService carMementoService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/base")
    public String getBaseConfiguration(
    ) throws NotFoundException {
        Car car = carService.findCarById(1L);
        return "car_page";
    }

    @PostMapping("/save_conf")
    public String saveCar(Model model, Car car) throws IOException {
        model.addAttribute("car", car);
        carMemento = car.saveConfiguration();
        carMementoService.save(carMemento);
        return "redirect:/car_page";

    }

    @PostMapping("/restore_conf/{id}")
    public String restoreCar(@PathVariable Long id, Model model, Car car) throws IOException {
        model.addAttribute("car", car);
        CarMemento carMemento = carMementoService.findById2(id);
        car.restoreConfiguration(carMemento);
        model.addAttribute("car", car);
        return "redirect:/car_page";

    }

    @GetMapping("/{id}")
    public String geCarById(
            @PathVariable Long id,
            Model model
    ) throws NotFoundException, SQLException {
        Car car = carService.findById(id).orElseThrow(() -> new NotFoundException("Car with id: " + id + " doesn't exists"));
        Exterior exterior = exteriorService.findById(car.getExteriorId());
        Interior interior = interiorService.findById(car.getInteriorId());
        model.addAttribute("car", car);
        model.addAttribute("exterior", exterior);
        model.addAttribute("interior", interior);
        return "car_page";
    }
}
