package pl.malfunctions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.devices.Device;
import pl.devices.DeviceReposiotry;
import pl.parts.Part;
import pl.parts.PartRepository;
import pl.workers.Worker;
import pl.workers.WorkerRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/malfunction")
public class MalfunctionCotroller {

    @ModelAttribute("workers")
    public List<Worker> workers() {
        return workerRepository.findAll();
    }

    @ModelAttribute("parts")
    public List<Part> parts () {
        return partRepository.findAll();
    }

    @ModelAttribute("devices")
    public List<Device> devices(){
        return deviceReposiotry.findAll();
    }

    @ModelAttribute("states")
    public List<String> states(){
        return List.of("NEW", "ON WORK", "DONE");
    }

    private final MalfuncionRepository malfuncionRepository;
    private final WorkerRepository workerRepository;
    private final PartRepository partRepository;
    private final DeviceReposiotry deviceReposiotry;


    public MalfunctionCotroller(MalfuncionRepository malfuncionRepository, WorkerRepository workerRepository, PartRepository partRepository, DeviceReposiotry deviceReposiotry) {
        this.malfuncionRepository = malfuncionRepository;
        this.workerRepository = workerRepository;
        this.partRepository = partRepository;
        this.deviceReposiotry = deviceReposiotry;
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        Malfunction malfunction = new Malfunction();
        model.addAttribute("malfunction", malfunction);
        return "/malfunctions/add";
    }

    @PostMapping("/save")
    public String add(Malfunction malfunction) {
        malfunction.setState("NEW");
        malfuncionRepository.save(malfunction);
        return "redirect:/malfunction/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Malfunction> malfunctions = malfuncionRepository.findAll();
        model.addAttribute("malfunctions", malfunctions);
        return "/malfunctions/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable long id) {
        Malfunction malfunction = malfuncionRepository.findById(id).get();
        model.addAttribute("malfunction", malfunction);
        return "/malfunctions/edit";
    }

    @PostMapping("/edit")
    public String edit(Malfunction malfunction) {
        malfuncionRepository.save(malfunction);
        return "redirect:/malfunction/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable long id, Model model) {
        Malfunction malfunction = malfuncionRepository.findById(id).get();
        model.addAttribute("malfunction", malfunction);
        return ("/malfunctions/delete");
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Malfunction malfunction = malfuncionRepository.findById(id).get();
        malfuncionRepository.delete(malfunction);
        return "redirect:malfunction/list";
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable long id, Model model){
        Malfunction malfunction = malfuncionRepository.findById(id).get();
        model.addAttribute("malfunction", malfunction);
        return "redirect:/malfunction/list";
    }
}
