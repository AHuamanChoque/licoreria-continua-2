package pe.edu.idat.licoreria_continua2.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.licoreria_continua2.model.bd.Categoria;
import pe.edu.idat.licoreria_continua2.model.bd.Clientes;
import pe.edu.idat.licoreria_continua2.model.dto.CategoriaDto;
import pe.edu.idat.licoreria_continua2.model.dto.ClientesDto;
import pe.edu.idat.licoreria_continua2.repository.ClientesRepository;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ClienteService implements IClienteService{
    private  ClientesRepository clientesRepository;

    @Override
    public List<ClientesDto> listarClientes() {
        List<ClientesDto>clientesDtoList = new ArrayList<>();
        for (Clientes clie : clientesRepository.findAll()){
            ClientesDto clientesDto =ClientesDto.builder().codclientes(clie.getCodclientes())
                    .dnicli(clie.getDnicli())
                    .nombrecli(clie.getNombrecli())
                    .apellidocli(clie.getApellidocli())
                    .celularcli(clie.getCelularcli())
                    .correocli(clie.getCorreocli())
                    .edadcli(clie.getEdadcli())
                    .sexocli(clie.getSexocli())
                    .direccioncli(clie.getDireccioncli())
                    .build();
            clientesDtoList.add(clientesDto);

        }
        return clientesDtoList;
    }



    @Override
    public Clientes guardarClientes(Clientes clientes) {
        return null;
    }
}
