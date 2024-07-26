package pe.edu.idat.licoreria_continua2.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.idat.licoreria_continua2.model.dto.CargoDto;
import pe.edu.idat.licoreria_continua2.model.dto.CategoriaDto;
import pe.edu.idat.licoreria_continua2.service.ICargoService;
import pe.edu.idat.licoreria_continua2.service.ICategoriaService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/cargo")
public class CargoController {

    private ICargoService iCargoService;

    @GetMapping("")
    public String frmCargo(Model model){
        model.addAttribute("listcargo",iCargoService.listarCargos());

        return "cargo/frmcargo"; //Aqui no se usa RESPONSE BODY porque es una vista!
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<CargoDto> listarCargos(){
        return iCargoService.listarCargos();

    }

}
