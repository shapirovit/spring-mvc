package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarsService;
import web.service.CarsServiceImp;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

	@GetMapping(value = "/cars")
	public String printCars(ModelMap model, @RequestParam(defaultValue = "5") int count) {
		List<Car> cars = new ArrayList<>();
		Car car1 = new Car("bmw", 5,"red");
		Car car2 = new Car("reno", 7,"blue");
		Car car3 = new Car("citroen", 2,"black");
		Car car4 = new Car("volvo", 11,"green");
		Car car5 = new Car("mercedes", 200,"silver");
		cars.add(car1);
		cars.add(car2);
		cars.add(car3);
		cars.add(car4);
		cars.add(car5);

		CarsService carsService = new CarsServiceImp();
		List<Car> result = carsService.listCars(cars, count);
		List<String> messages = new ArrayList<>();

		for (Car car: result) {
			messages.add("Модель: " + car.getModel() + " серия: " + car.getSeries() + " цвет: " + car.getColor());
		}
		model.addAttribute("messages", messages);

		return "cars";
	}
}