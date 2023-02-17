package pl.parts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.warehouse.Shelf;
import pl.warehouse.ShelfReposiotry;

import java.util.List;

@Controller
@RequestMapping("/part")
public class PartController {

    private final PartRepository partRepository;
    private final CategoryRepository categoryRepository;

    private final ShelfReposiotry shelfReposiotry;


    public PartController(PartRepository partRepository, CategoryRepository categoryRepository, ShelfReposiotry shelfReposiotry) {
        this.partRepository = partRepository;
        this.categoryRepository = categoryRepository;
        this.shelfReposiotry = shelfReposiotry;

    }

    @ModelAttribute("category")
    public List<Category> categories() {
        return categoryRepository.findAll();
    }

    @ModelAttribute("shefls")
    public List<Shelf> shelfList(){
        return shelfReposiotry.findAll();
    }


    @GetMapping("/add")
    public String addForm(Model model) {
        Part part = new Part();
        model.addAttribute("part", part);
        return "/parts/add";
    }

    @PostMapping("/save")
    public String add(Part part) {
        partRepository.save(part);
        return "redirect:/part/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Part> parts = partRepository.findAll();
        model.addAttribute("parts", parts);
        return "/parts/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable long id) {
        Part part = partRepository.findById(id).get();
        model.addAttribute("part", part);
        return "/parts/edit";
    }

    @PostMapping("/edit")
    public String edit(Part part) {
        partRepository.save(part);
        return "redirect:/part/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable long id, Model model) {
        Part part = partRepository.findById(id).get();
        model.addAttribute("part", part);
        return ("/parts/delete");
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Part part = partRepository.findById(id).get();
        partRepository.delete(part);
        return "redirect:/part/list";
    }

}
