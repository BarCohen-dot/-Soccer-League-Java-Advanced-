# Soccer League - Advanced Java Project ⚽

## Overview
This project was developed as part of the **Advanced Java Programming** course at **The Max Stern Yezreel Valley College**. It is a **Java-based soccer league management system** that applies **Object-Oriented Programming (OOP)** principles and utilizes various Java **Collections** to efficiently manage league operations.

## Features
- **Teams & Players Management:**
  - Each team can have up to 20 players.
  - Players can transfer between teams.
- **Match Management:**
  - Tracks match results, scores, and participating teams.
- **Coaches & Sponsors:**
  - Each team is assigned a coach.
  - Teams can be sponsored by multiple sponsors.
- **Customer (Fan) System:**
  - Fans can follow and support teams.
  - The system tracks the most favored teams.
- **Trophy & Ranking System:**
  - Awards trophies to outstanding players, coaches, and teams.
  
## Technologies Used
- **Java 17**
- **Object-Oriented Programming (OOP)**
- **Java Collections Framework:**
  - `LinkedList`, `ArrayList`, `HashSet`, `TreeSet`, `HashMap`, `TreeMap`, `Queue`, `PriorityQueue`
- **UML-Based Design**

## Project Structure
```
Soccer-League-Java-Advanced/
│── src/
│   ├── models/        # Core entities (Player, Team, Match, Sponsor, etc.)
│   ├── services/      # Business logic and operations
│   ├── utils/         # Utility functions and helper classes
│── input.txt          # Sample input data
│── README.md          # Project documentation
│── Main.java          # Entry point of the program
```

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/Soccer-League-Java-Advanced.git
   ```
2. Open the project in **IntelliJ IDEA** or **Eclipse**.
3. Compile and run `Main.java`.
4. Modify `input.txt` to customize test cases.

## Example Usage
```java
Team team1 = new Team("FC Barcelona");
Player player1 = new Player("Lionel Messi", 10, Position.ATTACKER);
team1.addPlayer(player1);
System.out.println(team1);
```

## Author
**Bar Cohen**

## License
This project is licensed under the **MIT License**.
