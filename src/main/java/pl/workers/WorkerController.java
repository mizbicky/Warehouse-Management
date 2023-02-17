package pl.workers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.malfunctions.Malfunction;

import java.util.List;

@Controller
@RequestMapping("/worker")
public class WorkerController {

    private final WorkerRepository workerRepository;

    public WorkerController(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        Worker worker = new Worker();
        model.addAttribute("worker", worker);
        return "/workers/add";
    }

    @PostMapping("/save")
    public String add(Worker worker) {
        workerRepository.save(worker);
        return "redirect:/worker/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Worker> workers = workerRepository.findAll();
        model.addAttribute("workers", workers);
        return "/workers/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable long id) {
        Worker worker = workerRepository.findById(id).get();
        model.addAttribute("worker", worker);
        return "/workers/edit";
    }

    @PostMapping("/edit")
    public String edit(Worker worker) {
        workerRepository.save(worker);
        return "redirect:/worker/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable long id, Model model) {
        Worker worker = workerRepository.findById(id).get();
        model.addAttribute("worker", worker);
        return ("/workers/delete");
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Worker worker = workerRepository.findById(id).get();
        workerRepository.delete(worker);
        return "redirect:/worker/list";
    }

}
