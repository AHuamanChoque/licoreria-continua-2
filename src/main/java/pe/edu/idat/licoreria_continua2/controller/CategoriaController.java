package pe.edu.idat.licoreria_continua2.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.idat.licoreria_continua2.model.bd.Categoria;
import pe.edu.idat.licoreria_continua2.model.bd.Proveedor;
import pe.edu.idat.licoreria_continua2.model.dto.CategoriaDto;
import pe.edu.idat.licoreria_continua2.service.ICategoriaService;
import pe.edu.idat.licoreria_continua2.service.IProveedorService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/categoria")
public class CategoriaController {
    private ICategoriaService iCategoriaService;

    @GetMapping("")
    public String frmCategoria(Model model){
        model.addAttribute("listcategoria",iCategoriaService.listarCategorias());

        return "categoria/frmcategoria"; //Aqui no se usa RESPONSE BODY porque es una vista!
    }

    @GetMapping("/listar")
    @ResponseBody
    public List<CategoriaDto> listarCategorias(){
        return iCategoriaService.listarCategorias();

    }

}
