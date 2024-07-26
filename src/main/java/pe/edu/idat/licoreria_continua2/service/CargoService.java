package pe.edu.idat.licoreria_continua2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.licoreria_continua2.model.bd.Cargo;
import pe.edu.idat.licoreria_continua2.model.bd.Categoria;
import pe.edu.idat.licoreria_continua2.model.dto.CargoDto;
import pe.edu.idat.licoreria_continua2.model.dto.CategoriaDto;
import pe.edu.idat.licoreria_continua2.repository.CargoRepository;
import pe.edu.idat.licoreria_continua2.repository.CategoriaRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CargoService implements ICargoService{
    private CargoRepository cargoRepository;


    @Override
    public List<CargoDto> listarCargos() {
        List<CargoDto>cargoDtoList = new ArrayList<>();
        for (Cargo carg : cargoRepository.findAll()){
            CargoDto cargoDto =CargoDto.builder().codcargo(carg.getCodcargo())
                    .nombrecargo(carg.getNombrecargo())
                    .build();
            cargoDtoList.add(cargoDto);

        }
        return cargoDtoList;
    }

    @Override
    public Cargo guardarCargos(Cargo cargo) {
        return cargoRepository.save(cargo);
    }
}
