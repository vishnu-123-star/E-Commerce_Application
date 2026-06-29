# 🛒 ShopSphere2 - Modern Android E-Commerce Application

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-brightgreen?style=for-the-badge&logo=android" />
  <img src="https://img.shields.io/badge/Language-Kotlin-purple?style=for-the-badge&logo=kotlin" />
  <img src="https://img.shields.io/badge/UI-Jetpack%20Compose-blue?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Architecture-MVVM-orange?style=for-the-badge" />
  <img src="https://img.shields.io/badge/Backend-Firebase-yellow?style=for-the-badge&logo=firebase" />
  <img src="https://img.shields.io/badge/Image%20Storage-Cloudinary-blue?style=for-the-badge" />
</p>

---

## 📱 Overview

**ShopSphere2** is a modern Android E-Commerce application developed using **Kotlin** and **Jetpack Compose** following the **MVVM (Model-View-ViewModel)** architecture.

The application allows users to browse products, authenticate securely using Firebase, upload product images to Cloudinary, manage favorite products, and enjoy a clean, responsive shopping experience.

The project demonstrates modern Android development practices including:

- MVVM Architecture
- REST API Integration
- Firebase Authentication
- Cloudinary Image Storage
- Retrofit Networking
- Jetpack Compose UI
- State Management
- Repository Pattern

---

# ✨ Features

### 🔐 Authentication

- User Registration
- User Login
- Firebase Authentication
- Secure User Sessions

### 🛍️ Product Catalog

- Browse Products
- Product Details
- Product Images
- Product Categories

### ❤️ Favorites

- Add to Favorites
- Remove from Favorites
- Persistent Favorite Items

### ☁️ Cloudinary Integration

- Upload Product Images
- Cloud Image Storage
- Retrieve Uploaded Images

### 🌐 Networking

- REST API Integration
- Retrofit
- JSON Parsing

### 🎨 Modern UI

- Jetpack Compose
- Material Design
- Responsive Layout
- Smooth Navigation

---

# 🏗️ Architecture

The project follows **MVVM Architecture**.

```
                UI (Jetpack Compose)
                       │
                       ▼
                 ViewModel Layer
                       │
                       ▼
                Repository Layer
               /                 \
              ▼                   ▼
     Firebase Services      REST APIs
              │                   │
              ▼                   ▼
       Authentication      Product Data
```

---

# 📂 Project Structure

```
ShopSphere2
│
├── app
│   ├── auth
│   ├── data
│   │     └── model
│   ├── details
│   ├── favorites
│   ├── home
│   ├── navigation
│   ├── network
│   ├── repository
│   ├── upload
│   ├── ui
│   └── utils
│
├── gradle
│
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

---

# 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| Kotlin | Programming Language |
| Jetpack Compose | UI Development |
| MVVM | Architecture Pattern |
| Firebase Authentication | User Authentication |
| Cloudinary | Image Upload & Storage |
| Retrofit | REST API Communication |
| Coroutines | Asynchronous Programming |
| ViewModel | UI State Management |
| Repository Pattern | Data Layer |
| Android Studio | Development IDE |

---

# 📦 Libraries Used

- Jetpack Compose
- AndroidX Navigation
- Firebase Authentication
- Retrofit
- Gson Converter
- Kotlin Coroutines
- ViewModel
- LiveData / State Management

---

# 🚀 Getting Started

## Clone Repository

```bash
git clone https://github.com/vishnu-123-star/E-Commerce_Application.git
```

---

## Open Project

Open the project using:

- Android Studio Hedgehog or above

---

## Sync Gradle

Allow Android Studio to download all dependencies.

---

## Firebase Setup

Create your own Firebase project.

Download

```
google-services.json
```

Place it inside

```
app/
```

Enable:

- Authentication
- Email & Password Sign-in

---

## Cloudinary Setup

Create a Cloudinary account.

Configure:

- Cloud Name
- Upload Preset

Update these values inside the project.

---

## Run

Connect an Android device or emulator and click

```
Run ▶
```

---

# 📸 Screenshots

> Add your application screenshots here.

Example:

```
screenshots/
    login.png
    home.png
    details.png
    upload.png
    favorites.png
```

You can display them like this:

```markdown
## Login Screen

![Login](screenshots/login.png)

## Home Screen

![Home](screenshots/home.png)

## Product Details

![Details](screenshots/details.png)

## Upload Screen

![Upload](screenshots/upload.png)
```

---

# 🔮 Future Enhancements

- Shopping Cart
- Payment Gateway Integration
- Order Tracking
- Search Products
- Product Reviews
- Push Notifications
- Wishlist Synchronization
- Admin Dashboard
- Dark Mode
- Offline Caching

---

# 📖 Learning Outcomes

This project demonstrates practical knowledge of:

- Android App Development
- MVVM Architecture
- Repository Pattern
- REST API Integration
- Firebase Authentication
- Cloudinary Image Upload
- Jetpack Compose
- State Management
- Kotlin Coroutines
- Clean Project Structure

---

# 🤝 Contributing

Contributions are welcome.

To contribute:

1. Fork the repository

2. Create a new branch

```bash
git checkout -b feature-name
```

3. Commit your changes

```bash
git commit -m "Added new feature"
```

4. Push

```bash
git push origin feature-name
```

5. Create a Pull Request

---

# 👨‍💻 Author

**Kunchala Vishnu**

GitHub:
https://github.com/vishnu-123-star

---

# ⭐ Support

If you found this project useful,

⭐ Star this repository.

It helps others discover the project and motivates further development.

---

## 📄 License

This project is developed for educational and learning purposes.

Feel free to use and modify it for personal or academic projects.
