package pl.parts;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.malfunctions.Malfunction;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "/categories/add";
    }

    @PostMapping("/save")
    public String add(Category category) {
        categoryRepository.save(category);
        return "redirect:/part/add";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "/categories/list";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable long id) {
        Category category = categoryRepository.findById(id).get();
        model.addAttribute("category", category);
        return "/categories/edit";
    }

    @PostMapping("/edit")
    public String edit(Category category) {
        categoryRepository.save(category);
        return "redirect:/category/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable long id, Model model) {
        Category category = categoryRepository.findById(id).get();
        model.addAttribute("category", category);
        return ("/categories/delete");
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
        return "redirect:/category/list";
    }

}
