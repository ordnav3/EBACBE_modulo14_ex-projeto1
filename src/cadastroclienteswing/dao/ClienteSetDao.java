/**
 * @author Evandro Santos
 */

package br.com.ordnav3.dao;

import br.com.ordnav3.domain.Cliente;

import java.util.*;

public class ClienteSetDao implements IClienteDao {
    private Set<Cliente> set;

    public ClienteSetDao() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        for (Cliente c : set) {
            if (c.getCpf() == cliente.getCpf()) {
                return false;
            }
        }

        this.set.add(cliente);
        return true;
    }

    @Override
    public void excluir(long cpf) {
        Cliente clienteEncontrado = null;

        for (Cliente c : set) {
            if (c.getCpf() == cpf) {
                clienteEncontrado = c;
                break;
            }
        }

        if (clienteEncontrado != null) {
            this.set.remove(clienteEncontrado);
        }
    }

    @Override
    public void alterar(Cliente cliente) {
        Cliente clienteCadastrado = null;

        for (Cliente c : set) {
            if (c.getCpf() == cliente.getCpf()) {
                clienteCadastrado = c;
                break;
            }
        }

        if (clienteCadastrado != null) {
            clienteCadastrado.setNome(cliente.getNome());
            clienteCadastrado.setTel(cliente.getTel());
            clienteCadastrado.setNumero(cliente.getNumero());
            clienteCadastrado.setEnd(cliente.getEnd());
            clienteCadastrado.setCidade(cliente.getCidade());
            clienteCadastrado.setEstado(cliente.getEstado());
        }
    }

    @Override
    public Cliente consultar(long cpf) {
        for (Cliente c : set) {
            if (c.getCpf() == cpf) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return new ArrayList<>(this.set);
    }
}
