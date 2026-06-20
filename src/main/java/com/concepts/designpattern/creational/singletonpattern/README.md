# Singleton Design Pattern

A simple guide to understanding and implementing the **Singleton Design Pattern**.

---

## 📖 What is it?

The Singleton Design Pattern ensures that a class has **only one instance** throughout the entire application.

Instead of creating a new object every time you need one, the application reuses the **same single instance** everywhere it's needed. This avoids unnecessary duplication of resources and keeps things consistent.

---

## 🤔 Why use it?

Some resources should never be duplicated. Creating multiple instances of them would be wasteful or even cause bugs. The Singleton pattern is perfect for these cases.

**Common real-world examples:**
- 🗄️ **Database Connection** — you don't want to open a new database connection every time; one shared connection is more efficient.
- 📁 **File Stream** — when reading/writing to a specific file path, you want a single, consistent stream rather than multiple conflicting ones.

---

## ⚙️ How does it work?

The pattern is implemented in two parts: **building the Singleton class**, and **using it**.

### A. Inside the class you want to make a Singleton

Follow these three steps:

1. **Add a static instance variable**
   Introduce a `static` variable inside the class — usually named `instance` — of the same type as the class itself. This variable will hold the one and only instance.

2. **Make the constructor private**
   This prevents the class from being instantiated directly using `new` from outside the class. The only way to get an instance becomes the method we define in the next step.

3. **Create a static `getInstance()` method**
   This method controls access to the single instance:
   - If the instance **doesn't exist yet**, it creates one and stores it.
   - If the instance **already exists**, it simply returns the existing one.

   This guarantees that no matter how many times `getInstance()` is called, you always get back the **same object**.

### B. Using the Singleton class

From any other class (e.g., a test class), you don't create the object with `new`. Instead, you call the static method directly:

```java
ClassName.getInstance();
```

This returns the single shared instance, ready to use.

---

## 🧩 Example (Java)

```java
public class DatabaseConnection {

    // 1. Static instance variable
    private static DatabaseConnection instance;

    // 2. Private constructor — prevents external instantiation
    private DatabaseConnection() {
        System.out.println("Creating new Database Connection...");
    }

    // 3. Static method to control access to the instance
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
```

**Using it:**

```java
public class TestApp {
    public static void main(String[] args) {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        // db1 and db2 point to the exact same object
        System.out.println(db1 == db2); // true
    }
}
```

No matter how many times `getInstance()` is called, only **one** `DatabaseConnection` object is ever created and reused.

---

## ✅ Quick Summary

| Step | What to do |
|------|------------|
| 1 | Add a `private static` variable to hold the instance |
| 2 | Make the constructor `private` |
| 3 | Add a `public static getInstance()` method that creates the instance once and reuses it afterward |
| 4 | Access the instance anywhere using `ClassName.getInstance()` |

---

## 💡 Key Takeaway

> The Singleton pattern guarantees **one instance, one resource, shared everywhere** — saving memory and keeping behavior consistent across your application.
