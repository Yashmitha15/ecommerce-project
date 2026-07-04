# MegaStore — Full-Stack E-Commerce Engine

A full-stack e-commerce store architecture engineered using Java, Spring Boot, and MySQL. The platform features an automated database-driven inventory catalog, enterprise-grade data validation, parameterized protection mechanisms against common web vulnerabilities, and an interactive frontend dashboard optimized for asynchronous state updates.

---

##  System Architecture

The application implements a strict Layered (3-Tier) Architecture to ensure clean separation of concerns, high maintainability, and loose coupling between structural components:

* **Presentation Layer (Frontend):** Responsive User Interface authored in semantic HTML5, CSS3 Grid/Flexbox layouts, and dynamic asynchronous state tracking built entirely via native JavaScript (Fetch API).
* **Application/Controller Layer (Backend REST API):** Orchestrated by Java 17 and the Spring Boot framework using RESTful controllers to handle user sessions, routing context, and inventory workflows.
* **Data Access Layer (Persistence):** Managed through Spring Data JPA abstraction layered over a high-performance relational MySQL database instance.

---

##  Key Functional Features

### 1. Robust User Authentication & Session Control
* Secure customer onboarding and entry pathways backed by custom relational persistence engines.
* Real-time identity tracking ensuring authenticated operational domains upon dynamic UI state switches.

### 2. High-Fidelity Interactive Storefront (E-Commerce UX)
* Designed with modern e-commerce visual patterns mimicking production retail platforms.
* Features responsive product grids displaying custom item metadata, dynamic inventory tallies, and high-quality image resource pipelines.

### 3. Live Client-Side Data Manipulation
* **Real-time Search Processing:** Instantaneous collection querying via debounced input stream scanning.
* **Multi-Tier Filtering & Sorting:** Dynamic inline array re-ordering supporting custom parameter constraints (e.g., category slicing and price ranking matrix adjustments) without requiring page reload.

---

##  Applied Security Implementation

This codebase implements production-grade protective guardrails against common OWASP Top 10 web vulnerabilities:

### 1. Robust Mitigation Against SQL Injection (SQLi)
Traditional query concatenation exposes database engines to arbitrary payload execution. This application completely mitigates SQLi by leveraging Spring Data JPA's automated object-relational mapping alongside native parameterized expressions. Under the hood, this compiles queries using highly secure prepared statements:

```java
// Secure Parameterized Query Mechanism via Spring Data JPA
public interface UserRepository extends JpaRepository<User, Integer> {
    // Spring automatically utilizes Type-Safe Parameter Binding to block SQL Injection
    Optional<User> findByUsername(String username);
}
