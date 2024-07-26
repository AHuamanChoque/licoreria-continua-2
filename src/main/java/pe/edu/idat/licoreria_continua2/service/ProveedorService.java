package pe.edu.idat.licoreria_continua2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.licoreria_continua2.model.bd.Categoria;
import pe.edu.idat.licoreria_continua2.model.bd.Producto;
import pe.edu.idat.licoreria_continua2.model.bd.Proveedor;
import pe.edu.idat.licoreria_continua2.model.dto.CategoriaDto;
import pe.edu.idat.licoreria_continua2.model.dto.ProveedorDto;
import pe.edu.idat.licoreria_continua2.repository.ProductoRepository;
import pe.edu.idat.licoreria_continua2.repository.ProveedorRepository;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ProveedorService implements IProveedorService{
    private ProveedorRepository proveedorRepository;
    @Override
    public List<ProveedorDto> listarProveedores() {
        List<ProveedorDto>proveedorDtoList = new ArrayList<>();
        for (Proveedor prove : proveedorRepository.findAll()){
            ProveedorDto proveedorDto =ProveedorDto.builder().codproveedor(prove.getCodproveedor())
                    .razonsocial(prove.getRazonsocial())
                    .rucproveedor(prove.getRucproveedor())
                    .telefonoproveedor(prove.getTelefonoproveedor())
                    .codtipoprovee(prove.getTipoProveedor().getCodtipoprovee())
                    .descripcion(prove.getTipoProveedor().getDescripcion())
                    .build();
            proveedorDtoList.add(proveedorDto);

        }
        return proveedorDtoList;
    }

    @Override
    public Proveedor guardarProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }
}
