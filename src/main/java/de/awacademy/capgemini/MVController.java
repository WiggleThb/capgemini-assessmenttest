package de.awacademy.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

//Controller	
@RequestMapping(path="/application") //Application path 
public class MVController {
	@Autowired 
	private WorkerRepository workerRepository;

	@PostMapping(path="/add") // Map ONLY POST Requests
	public @ResponseBody String addNewWorker (@RequestParam String name
			, @RequestParam String branch) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Worker addWorker = new Worker();
		addWorker.setName(name);
		addWorker.setBranch(branch);
		workerRepository.save(addWorker);
		return "Added new worker!";
	}

	@GetMapping(path="/overview")
	public @ResponseBody Iterable<Worker> getAllUsers() {
		// This returns a JSON or XML with the users
		return workerRepository.findAll();
	}
}
