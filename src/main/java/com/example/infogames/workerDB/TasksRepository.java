package com.example.infogames.workerDB;

import com.example.infogames.entity.Tasks;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class TasksRepository {

    private final static String URL_DB = SearchPathDB.SearchPath();

    private ConnectionSource connectionSource = null;

    private Dao<Tasks, String> tasksFromDB = null;

    public void connect() throws SQLException {
        connectionSource = new JdbcConnectionSource(URL_DB);

        tasksFromDB = DaoManager.createDao(connectionSource, Tasks.class);
    }

    public void close() throws Exception{
        connectionSource.close();
    }

    public void createTable() throws SQLException {
        TableUtils.createTable(connectionSource, Tasks.class);
    }

    public Tasks getTasksById(String id) throws SQLException {
        return tasksFromDB.queryBuilder()
                .where()
                .eq("idTasks", id)
                .queryForFirst();
    }

}
