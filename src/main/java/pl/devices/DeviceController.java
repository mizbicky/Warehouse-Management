package pl.devices;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.malfunctions.Malfunction;

import java.util.List;

@Controller
@RequestMapping("/device")
public class DeviceController {

    private final DeviceReposiotry deviceReposiotry;

    public DeviceController(DeviceReposiotry deviceReposiotry) {
        this.deviceReposiotry = deviceReposiotry;
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        Device device = new Device();
        model.addAttribute("device", device);
        return "/devices/add";
    }

    @PostMapping("/save")
    public String add(Device device) {
        deviceReposiotry.save(device);
        return "redirect:/malfunction/add";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Device> devices = deviceReposiotry.findAll();
        model.addAttribute("devices", devices);
        return "/devices/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable long id) {
        Device device = deviceReposiotry.findById(id).get();
        model.addAttribute("device", device);
        return "/devices/edit";
    }

    @PostMapping("/edit")
    public String edit(Device device) {
        deviceReposiotry.save(device);
        return "redirect:/device/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable long id, Model model) {
        Device device = deviceReposiotry.findById(id).get();
        model.addAttribute("device", device);
        return ("/devices/delete");
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Device device = deviceReposiotry.findById(id).get();
        deviceReposiotry.delete(device);
        return "redirect:/device/list";
    }

}
