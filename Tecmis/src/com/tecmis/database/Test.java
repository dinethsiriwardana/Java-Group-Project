package com.tecmis.database;

// This is an example of a Java CRUD (Create, Read, Update, Delete) application that incorporates classes and objects, inheritance, abstraction, polymorphism, and encapsulation.
abstract class DatabaseObject {
    protected int id;

    public DatabaseObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public abstract void save();

    public abstract void delete();
}

// Child class for representing users
class User extends DatabaseObject {
    private String username;
    private String password;

    public User(int id, String username, String password) {
        super(id);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void save() {
        // Code for saving user data to the database
    }

    @Override
    public void delete() {
        // Code for deleting user data from the database
    }
}

// Child class for representing products
class Product extends DatabaseObject {
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void save() {
        // Code for saving product data to the database
    }

    @Override
    public void delete() {
        // Code for deleting product data from the database
    }
}

// Example usage of the classes
public class Test {
    public static void main(String[] args) {
        // Create a new user object
        User user = new User(1, "john.doe", "password123");
        user.save(); // Save user data to the database

        // Create a new product object
        Product product = new Product(1, "Widget", 19.99);
        product.save(); // Save product data to the database

        // Update the user's password
        user.setPassword("newPassword456");
        user.save(); // Save the updated user data to the database

        // Delete the product from the database
        product.delete();
    }
}

/*
In this example, the DatabaseObject class serves as an abstract parent class for all objects that will be stored in the database.
The User and Product classes inherit from DatabaseObject and provide specific functionality for representing users and products in the database.

The User and Product classes both implement the save() and delete() methods,
which are abstract methods defined in DatabaseObject.
This demonstrates abstraction, as the parent class defines a set of methods that must be implemented by the child classes.

The User and Product classes also demonstrate encapsulation,
as their properties (such as username, password, name, and price)
are private and can only be accessed through public getter and setter methods.

Finally, the DatabaseObject class and its child classes demonstrate polymorphism,
as they can all be treated as DatabaseObject objects, allowing for more generic code that can operate on any type of DatabaseObject
without needing to know the specific implementation details of the child classes.
This makes the code more flexible and easier to maintain, as changes to the implementation of a child class will not require
changes to the code that operates on DatabaseObject objects. For example, a method that takes a DatabaseObject parameter
can be called with either a User or Product object, and the method will be able to operate on the object regardless of its specific type.
This allows for greater code reuse and modularity, as well as easier testing and debugging.
*/