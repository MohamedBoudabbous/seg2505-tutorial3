package com.example.pcorderapplication.model.database;

import android.content.Context;

import com.example.pcorderapplication.model.database.tools.DatabaseSQLite;

public class AppDatabase {
    private static AppDatabase instance;

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    //private final ComponentRepository componentRepository;
    private final DatabaseSQLite dbHelper;

    // Constructeur privé (Singleton pattern)
    private AppDatabase(Context context) {
        // Initialise DatabaseSQLite avec le contexte
        this.dbHelper = new DatabaseSQLite(context);

        // Initialise les repositories avec DatabaseSQLite
        this.userRepository = new UserRepository(context);
        this.orderRepository = new OrderRepository(context);
        //this.componentRepository = new ComponentRepository(context);
    }

    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = new AppDatabase(context.getApplicationContext());
        }
        return instance;
    }

    public DatabaseSQLite getDbHelper() {
        return dbHelper;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public void getComponentRepository() {}
}
