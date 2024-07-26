package pe.edu.idat.licoreria_continua2.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.edu.idat.licoreria_continua2.model.bd.Proveedor;
import pe.edu.idat.licoreria_continua2.model.dto.ProveedorDto;
import pe.edu.idat.licoreria_continua2.service.IProveedorService;

import java.util.List;

@Controller
@RequestMapping("/proveedor")
@AllArgsConstructor
public class ProveedorController {
    private IProveedorService iProveedorService;

    @GetMapping("")
    public String frmProveedor(Model model){
        model.addAttribute("listproveedor",iProveedorService.listarProveedores());

        return "proveedor/frmproveedor"; //Aqui no se usa RESPONSE BODY porque es una vista!
    }


    @GetMapping("/listar")
    @ResponseBody
    public List<ProveedorDto> listarProveedores(){

        return iProveedorService.listarProveedores();
    }
}
