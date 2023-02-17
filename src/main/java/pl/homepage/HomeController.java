package pl.homepage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.malfunctions.MalfuncionRepository;
import pl.parts.PartRepository;

@Controller
@RequestMapping("/")
public class HomeController {

    private final PartRepository partRepository;
    private final MalfuncionRepository malfuncionRepository;

    public HomeController(PartRepository partRepository, MalfuncionRepository malfuncionRepository) {
        this.partRepository = partRepository;
        this.malfuncionRepository = malfuncionRepository;
    }


}
