package com.curso.app;

import java.util.Scanner;

public class Aplicacion {

    MenuHelper menuHelper = new MenuHelper();
    Scanner input = new Scanner(System.in);

    public void execute() {

        int num = -1;

        do {

            System.out.println("Menu:" +
                    "\n1- Listar usuarios" +
                    "\n2- Añadir usuario" +
                    "\n3- Borrar usuario" +
                    "\n0- Salir");

            num = input.nextInt();

            switch (num) {

                case 1:
                    menuHelper.showUsers();
                    break;
                case 2:
                    menuHelper.addUser();
                    break;
                case 3:
                    menuHelper.deleteUser();
                    break;
                case 0:
                    System.out.println("Saliendo del programa. Hasta la vista.");
            }

        } while (num != 0);
    }

}



