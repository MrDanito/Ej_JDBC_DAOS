package com.curso.dao;

import com.curso.usuario.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPostgres implements DAO {

    Conexion conex = new Conexion();

    @Override
    public List<Usuario> loadUsers() {

        List<Usuario> usuarios = new ArrayList<>();

        Statement st = conex.conex();

        String sentenciaSql = "SELECT * FROM usuarios";
        ResultSet rs = null;
        try {
            rs = st.executeQuery(sentenciaSql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellidos");

                Usuario user = new Usuario(id, nombre, apellido);

                usuarios.add(user);
                st.close();

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public String insertUser(Usuario usuario) {

        Statement st = conex.conex();

        String sentenciaSql = "INSERT INTO usuarios (nombre, apellidos) VALUES ('" + usuario.getName() + "', '" + usuario.getLastName() + "');";

        int rows = 0;

        try {
            rows = st.executeUpdate(sentenciaSql);

            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (rows == 1) {

            return "Se ha creado el usuario: " + usuario.getName() + " " + usuario.getLastName();

        } else {

            return "No se ha podido añadir el usuario";

        }


    }

    @Override
    public String deleteUser(int id) {

        Statement st = conex.conex();

        String sentenciaSql = "DELETE from usuarios where id= '" + id + "';";

        int rows = 0;

        try {
            rows = st.executeUpdate(sentenciaSql);

            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (rows == 1) {

            return "Se ha borrado correctamente";

        } else {

            return "No se ha podido borrar el usuario";

        }
    }


    class Conexion {

        Connection cn = null;

        public Statement conex() {

            try {

                String url = "jdbc:postgresql://192.168.56.2:5432/empresa";

                String usuario = "admin";

                String pass = "abc";

                cn = DriverManager.getConnection(url, usuario, pass);

                Statement st = cn.createStatement();

                return st;

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        }

    }

}


