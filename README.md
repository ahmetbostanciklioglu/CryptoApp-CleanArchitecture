<div align="center">

# 📈 Crypto App — Clean Architecture

**A modern Android crypto price tracker built with Jetpack Compose and Clean Architecture.**

![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?style=flat-square&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-2.0-7F52FF?style=flat-square&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-4285F4?style=flat-square&logo=jetpackcompose&logoColor=white)
![Hilt](https://img.shields.io/badge/DI-Hilt-6E48AA?style=flat-square)
![Stars](https://img.shields.io/github/stars/ahmetbostanciklioglu/CryptoApp-CleanArchitecture?style=flat-square&color=6E48AA)
![Last Commit](https://img.shields.io/github/last-commit/ahmetbostanciklioglu/CryptoApp-CleanArchitecture?style=flat-square&color=4776E6)

</div>

## 📖 Overview

Crypto App is an Android application that fetches live cryptocurrency prices from a remote API and displays them in a clean, scrollable list. It is built as a reference implementation of **Clean Architecture**, separating the codebase into distinct `domain`, `data`, and `presentation` layers. The UI is written entirely in Jetpack Compose with Material 3, and the app relies on Hilt for dependency injection, Retrofit for networking, and Kotlin Coroutines with Flow for reactive, asynchronous data handling.

## ✨ Features

- 💰 Fetches a list of cryptocurrencies with their code, price, and currency from the CollectAPI economy endpoint.
- 🧱 Clean Architecture with clear separation across domain, data, and presentation layers.
- 🔄 Reactive state handling with a `Resource` wrapper exposing Loading, Success, and Error states via Kotlin Flow.
- ⏳ Loading spinner and inline error messaging driven by a single Compose UI state.
- 💉 Dependency injection wired through Dagger Hilt (API, repository, and use case modules).
- 🌐 Retrofit + OkHttp networking with a Gson converter and logging interceptor.

## 📸 Preview

<div align="center">
  <img width="1658" alt="clean-architecture" src="https://github.com/user-attachments/assets/6b764924-b573-45da-b0a0-80d1a4b370cc" />
</div>

## 🚀 Getting Started

```bash
# Clone the repository
git clone https://github.com/ahmetbostanciklioglu/CryptoApp-CleanArchitecture.git
cd CryptoApp-CleanArchitecture
```

1. Open the project in **Android Studio**.
2. Let Android Studio **sync the Gradle** files and download dependencies.
3. Add your CollectAPI key in `app/src/main/java/com/cleanapp/util/Constants.kt` (replace the `API_KEY` placeholder).
4. Select a device or emulator and press **Run** ▶️.

## 📋 Requirements

- Android Studio (Ladybug or newer recommended)
- Android SDK: `minSdk 24`, `targetSdk 34`, `compileSdk 35`
- Kotlin 2.0 · JDK 11
- A valid [CollectAPI](https://collectapi.com/) key for the crypto endpoint

## 🧑‍💻 Author

**Ahmet Bostancıklıoğlu** — [@ahmetbostanciklioglu](https://github.com/ahmetbostanciklioglu) · ahmetbostancikli@gmail.com

> ⭐ If this helped you, consider giving the repo a star!
