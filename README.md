# RadioButtonDemo - Java Swing Pet Viewer

A graphical Java desktop application developed as part of **Java (Assignment 2)**. The application features five radio buttons allowing users to select a pet type, dynamically updating the displayed image and prompting a message dialog box upon selection.

---

## 🚀 Features

* **Dynamic UI Selection:** Choose between five different pets (Bird, Cat, Dog, Rabbit, Pig).
* **Button Grouping:** Built-in validation ensures only one radio button can be selected at a time.
* **Graphical Image Support:** Renders `.webp` graphics dynamically based on user interaction.
* **Alert Notifications:** Triggers a `JOptionPane` message box confirming the selection.
* **Centered UI Design:** Implements a custom layout manager to perfectly center components regardless of screen scaling.

---

## 📸 Application Preview

Below are the screenshots illustrating the required functionality:

### 1. Main UI Interface
![Main Application Window](https://raw.githubusercontent.com/Alexander12xx/RadioButton/main/images/Pig.webp)
*The desktop window displays clear radio buttons aligned next to the corresponding pet image.*

### 2. Message Box Selection Prompt
> **Pet Selection Alert:** Clicking any radio button instantly triggers a dialog box saying: `"You selected the [Pet Name]!"`

---

## 🛠️ Project Structure

The project repository is structured cleanly as shown below to ensure smooth resource path management:

```text
📁 RadioButton/
│
├── 📄 RadioButtonDemo.java   # Main Java Source Code
├── 📄 README.md              # Project Documentation
└── 📁 images/                # Asset Directory
     ├── Bird.webp
     ├── Cat.webp
     ├── Dog.webp
     ├── Rabbit.webp
     └── Pig.webp
