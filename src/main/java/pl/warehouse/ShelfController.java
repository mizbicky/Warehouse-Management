package pl.warehouse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/shelf")
public class ShelfController {



    private final ShelfReposiotry shelfReposiotry;

    public ShelfController( ShelfReposiotry shelfReposiotry) {
        this.shelfReposiotry = shelfReposiotry;
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        Shelf shelf = new Shelf();
        model.addAttribute("shelf", shelf);
        return "/warehouse/shelf/add";
    }

    @PostMapping("/save")
    public String add(Shelf shelf) {
        shelfReposiotry.save(shelf);
        return "redirect:/shelf/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Shelf> shelfs = shelfReposiotry.findAll();
        model.addAttribute("shelfs", shelfs);
        return "/warehouse/shelf/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable long id) {
        Shelf shelf = shelfReposiotry.findById(id).get();
        model.addAttribute("shelf", shelf);
        return "/warehouse/shelf/edit";
    }

    @PostMapping("/edit")
    public String edit(Shelf shelf) {
        shelfReposiotry.save(shelf);
        return "redirect:/shelf/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable long id, Model model) {
        Shelf shelf = shelfReposiotry.findById(id).get();
        model.addAttribute("shelf", shelf);
        return ("/warehouse/shelf/delete");
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Shelf shelf = shelfReposiotry.findById(id).get();
        shelfReposiotry.delete(shelf);
        return "redirect:/shelf/list";
    }
}
