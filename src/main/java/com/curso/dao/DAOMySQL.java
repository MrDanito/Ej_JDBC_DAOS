package com.curso.dao;

import com.curso.usuario.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class DAOMySQL implements DAO {

    Conexion conex = new Conexion();

    @Override
    public List<Usuario> loadUsers() {

        List<Usuario> usuarios = new ArrayList<>();

        String sentenciaSql = "SELECT * FROM usuarios";
        ResultSet rs = null;
        try {
            Statement st = conex.conn.createStatement();

            rs = st.executeQuery(sentenciaSql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellidos");

                Usuario user = new Usuario(id, nombre, apellido);

                usuarios.add(user);

            }
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public String insertUser(Usuario usuario) {

        String sentenciaSql = "INSERT INTO usuarios (nombre, apellidos) VALUES ('" + usuario.getName() + "', '" + usuario.getLastName() + "');";

        int rows = 0;

        try {
            Statement st = conex.conn.createStatement();

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

        String sentenciaSql = "DELETE from usuarios where id= '" + id + "';";

        int rows = 0;

        try {

            Statement st = conex.conn.createStatement();

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

        public Connection conn = null;

        public Conexion() {

            try {

                String url = "jdbc:mysql://127.0.0.1:3306/talleres_ebro?serverTimezone=  " + TimeZone.getDefault().getID();

                String usuario = "root";

                String pass = "Administrator";

                conn = DriverManager.getConnection(url, usuario, pass);


            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

}
