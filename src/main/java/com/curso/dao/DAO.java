package com.curso.dao;

import com.curso.usuario.Usuario;

import java.util.List;

public interface DAO {

    public List<Usuario> loadUsers();
    public String insertUser(Usuario usuario);
    public String deleteUser(int id);


}
