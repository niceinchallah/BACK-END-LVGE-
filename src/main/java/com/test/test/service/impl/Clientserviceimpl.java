package com.test.test.service.impl;

import com.test.test.DTO.ClientDTO;
import com.test.test.EXCEPTION.ResourceNOTfoundexception;
import com.test.test.entity.Client;
import com.test.test.mapper.Clientmapper;
import com.test.test.repository.Clientrep;
import com.test.test.service.Clientservice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class Clientserviceimpl implements Clientservice {
    private Clientrep clientrep;
    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client= Clientmapper.mapToClient(clientDTO);
         Client savedClient=clientrep.save(client);
        return Clientmapper.mapToClientDTO(savedClient);
    }

    @Override
    public ClientDTO getClientbyid(Long clientID) {
       Client client =  clientrep.findById(clientID)
                .orElseThrow(()->
                        new ResourceNOTfoundexception("not exist with given id "+ clientID));

        return Clientmapper.mapToClientDTO(client);
    }

    @Override
    public List<ClientDTO> getAllCients() {
        List<Client >  clients = clientrep.findAll();
        return clients.stream().map((client) ->Clientmapper.mapToClientDTO(client)  )
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO updateClients(Long Clientid, ClientDTO updatedClients) {
         Client client =    clientrep.findById(Clientid).orElseThrow(()
        -> new ResourceNOTfoundexception("not exist with givfen id: "+ Clientid)
        );
        client.setName(updatedClients.getName());
        client.setBrand(updatedClients.getBrand());
        client.setModel(updatedClients.getModel());
        client.setId(updatedClients.getId());
        client.setDate(updatedClients.getDate());
        client.setPhoto(updatedClients.getPhoto());
           Client updatedClientObj = clientrep.save(client);
        return Clientmapper.mapToClientDTO(updatedClientObj);
    }

    @Override
    public void deleteClients(Long Clientid) {


        Client client =    clientrep.findById(Clientid).orElseThrow(()
                -> new ResourceNOTfoundexception("not exist with givfen id: "+ Clientid)
        );
        clientrep.deleteById(Clientid);
    }
}
