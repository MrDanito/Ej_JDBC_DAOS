package com.curso.app;

import com.curso.constantes.Constantes;
import com.curso.dao.DAO;
import com.curso.dao.FactoryDAO;
import com.curso.usuario.Usuario;

import java.util.List;
import java.util.Scanner;

public class MenuHelper {

    DAO dao = FactoryDAO.createDAO(Constantes.CURRENT_DB);
    Scanner input = new Scanner(System.in);


    public void showUsers() {

        List<Usuario> users = dao.loadUsers();

        for (int i = 0; i < users.size(); i++) {

            System.out.println(users.get(i).toString());

        }

    }

    public void addUser() {

        Usuario usuario = new Usuario();

        System.out.println("¿Cuál es el nombre?");
        usuario.setName(input.next());

        System.out.println("¿Cuál es el apellido?");
        usuario.setLastName(input.next());

        System.out.println(dao.insertUser(usuario));

    }

    public void deleteUser() {

        System.out.println("Introduzca el id del usuario que quiere borrar: ");
        int num = input.nextInt();

        System.out.println(dao.deleteUser(num));

    }


}
