package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import uz.pdp.appwarehouse.entity.Client;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    /**
     * Creat client
     * @param client
     * @return Result
     */
    public Result addClient(Client client) {
        boolean exists = clientRepository.existsByNameAndPhoneNumber(client.getName(), client.getPhoneNumber());
        if (exists)
            return new Result("ERROR! This client already added", false);
        Client addedClient = new Client();
        addedClient.setName(client.getName());
        addedClient.setPhoneNumber(client.getPhoneNumber());
        addedClient.setActive(client.isActive());

        clientRepository.save(addedClient);

        return new Result("Client added", true);
    }

    /**
     * Get all clients
     */
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    /**
     * Get one client
     */
    public Client getClientById(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        return optionalClient.orElseGet(Client::new);
    }

    /**
     * Edit client
     */
    public Result editClient(Integer id, Client client) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client editedClient = optionalClient.get();
            editedClient.setName(client.getName());
            editedClient.setPhoneNumber(client.getPhoneNumber());
            editedClient.setActive(client.isActive());

            clientRepository.save(editedClient);

            return new Result("Client edited", false);
        }
        return new Result("ERROR! Client not found", false);
    }

    /**
     * Delete client
     */
    public Result deleteClient(Integer id) {
        try {
            clientRepository.deleteById(id);
            return new Result("Client deleted", true);
        } catch (Exception exception) {
            return new Result("ERROR! Client not found", false);
        }
    }
}
