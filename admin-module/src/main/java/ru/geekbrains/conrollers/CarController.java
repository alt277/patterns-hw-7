package ru.geekbrains.conrollers;


import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.geekbrains.entity.Car;
import ru.geekbrains.entity.Exterior;
import ru.geekbrains.entity.Interior;

import ru.geekbrains.services.CarService;
import ru.geekbrains.services.ExteriorDao;
import ru.geekbrains.services.InteriorDao;

import java.sql.SQLException;

@Controller
@RequestMapping("/car")
public class CarController {

    private CarService carService;
    private InteriorDao interiorDao;
    private ExteriorDao exteriorDao;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    public String geCartById(
            @PathVariable Long id,
            Model model
    ) throws NotFoundException, SQLException {
      Car car = carService.findById(id).orElseThrow(() -> new NotFoundException("Product with id: " + id + " doesn't exists"));
        model.addAttribute("car", car);
      Exterior exterior=exteriorDao.findById(car.getExteriorId());
      Interior interior = interiorDao.findById(car.getInteriorId());
        model.addAttribute("exterior", exterior);
        model.addAttribute("interior", interior);
        return "car_page";
    }
    @PostMapping("/car")
    public String adminUpsertProduct(Model model, RedirectAttributes redirectAttributes, Car car,Exterior exterior,Interior interior) {
        model.addAttribute("activePage", "car");

        try {
            carService.save(car);
            interiorDao.save(interior);
            exteriorDao.save(exterior);
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("error", true);
            if (car.getId() == null) {
                return "redirect:/car/create";
            }
            return "redirect:/car/" + car.getId() + "/edit";
        }
        return "redirect:/car_page";
    }

}
