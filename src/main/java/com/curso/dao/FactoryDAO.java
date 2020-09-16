package com.curso.dao;

import com.curso.constantes.Constantes;

public class FactoryDAO {

    public static DAO createDAO(Constantes.DATABASES currentDB) {

        switch (currentDB) {

            case POSTGRES:
                return new DAOPostgres();

            case MYSQL:
                return new DAOMySQL();
        }

        return null;
    }

}
