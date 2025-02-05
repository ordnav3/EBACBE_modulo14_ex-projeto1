package br.com.ordnav3.dao;

import br.com.ordnav3.domain.Cliente;

import java.util.Collection;

public interface IClienteDao {
    public Boolean cadastrar(Cliente cliente);
    public void excluir(long cpf);
    public void alterar(Cliente cliente);
    public Cliente consultar(long cpf);
    public Collection<Cliente> buscarTodos();
}
