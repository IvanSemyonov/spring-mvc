package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HelloController {

	@GetMapping(value = "/hello")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}

	@GetMapping("/cars")
	public String printCars(@RequestParam(value = "count", defaultValue = "-1", required = false) int count,
							ModelMap model){
		List<Car> cars = Arrays.asList(
				new Car("Honda Accord", 2020, "black"),
				new Car("Kia Rio", 2016, "red"),
				new Car("Lada Vesta", 2017, "white"),
				new Car("Ford Focus", 2010, "blue"),
				new Car("Kia Optima", 2019, "white"));

		if (count > cars.size() || count < 0){
			count = cars.size();
		}

		model.addAttribute("cars", cars.subList(0, count));
		return "cars";
	}
}