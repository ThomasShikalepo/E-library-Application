# 📚 E-Library Android Application

Welcome to the **E-Library Application**, a fully responsive, modern Android app designed to make digital reading simple, accessible, and engaging. Built using **Jetpack Compose** and backed by **Firebase**, this app offers a clean, smooth experience for discovering and reading e-books. Whether you’re a student, a casual reader, or someone who just loves learning, this digital library platform is tailored for you.

---

## ✨ Overview

In today's fast-moving world, physical libraries are becoming less accessible, especially in under-resourced communities. The E-Library App bridges that gap by providing users with **mobile access to books**, sorted by categories and enhanced with powerful tools like **real-time syncing, PDF viewing**, and a **cloud-based backend**.

This project was created to showcase both design thinking and robust backend integration using **modern Android development practices**. It can be scaled for institutional use (e.g., schools or universities) or customized for commercial distribution.

---

## 🌟 Key Features

### 📖 Book Catalog & Categories
- Easily browse a wide selection of books, organized by genre.
- Dynamically loaded from **Firebase Firestore** in real time.

### 🔍 Search Functionality
- Quickly find any book using a responsive search bar.

### 📄 In-App PDF Book Reader
- Read full PDF books directly within the app using **Bouquet’s VerticalPDFReader**.
- Smooth scrolling and optimized for long reading sessions.

### ⏳ Splash Screen with Circular Loading
- Professionally designed launch screen with a loading animation that sets the tone for the app experience.

### 🔥 Firebase Integration
- **Firestore** for storing metadata (title, author, category, etc.)
- **Firebase Storage** for hosting and retrieving actual PDF files.
- Live data binding ensures instant updates across the app.

### 🎨 Clean UI with Jetpack Compose
- Built entirely with **Jetpack Compose** for a modern, declarative UI.
- Dark theme and elegant typography for immersive reading.

---

## 📸 Screenshots

| Home Screen | Category View | PDF Reader |
|-------------|----------------|-------------|
| ![Home](https://via.placeholder.com/200x400?text=Home+Screen) | ![Category](https://via.placeholder.com/200x400?text=Category+View) | ![Reader](https://via.placeholder.com/200x400?text=PDF+Reader) |

> Replace the placeholder image URLs above with your own screenshots, either uploaded in the repo (`/assets/`) or from an image host like Imgur or Cloudinary.

---

## 🛠 Tech Stack & Architecture

| Layer              | Tech                                |
|--------------------|-------------------------------------|
| UI                 | Jetpack Compose, Material3          |
| State Management   | ViewModel, State Hoisting           |
| Dependency Injection | Hilt                             |
| Backend/Database   | Firebase Firestore & Firebase Storage |
| PDF Viewer         | [Bouquet](https://github.com/RizziTech/bouquet) |
| Architecture       | MVVM (Model-View-ViewModel)         |

---

## 🚀 Getting Started

To run this project locally on your machine, follow these steps:

### 1. Clone the Repository

```bash
git clone https://github.com/ThomasShikalepo/E-library-Application.git
cd E-library-Application
