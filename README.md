# Eksplorasi Anime

Aplikasi Android sederhana untuk mencari dan menampilkan informasi anime menggunakan **Tenrai API**. Proyek ini dibuat untuk memenuhi tugas responsi pemrograman mobile.

## Fitur Utama
- **Daftar Anime**: Menampilkan daftar anime populer dengan informasi rating, tahun rilis, dan jumlah episode.
- **Detail Anime**: Menampilkan informasi lengkap termasuk sinopsis anime yang dipilih.
- **State Management**: Menangani kondisi Loading, Success, dan Error secara responsif.
- **Material Design 3**: Antarmuka pengguna modern dengan komponen Material 3.

## Arsitektur & Teknologi
- **Bahasa**: Kotlin
- **UI Framework**: Jetpack Compose
- **Arsitektur**: MVVM (Model-View-ViewModel)
- **Networking**: Retrofit & Gson
- **Navigation**: Jetpack Navigation Compose
- **State**: Flow & StateFlow

## Screenshot
*(Tambahkan screenshot aplikasi di sini)*

## Penjelasan Teknis
1. **Data Layer**: Terdiri dari `ApiService` untuk koneksi ke Tenrai API, `Model` sebagai representasi data, dan `Repository` untuk abstraksi pengambilan data.
2. **UI Layer**: Menggunakan `UiState` (sealed interface) untuk mendefinisikan status layar. `AnimeViewModel` mengelola data dan berinteraksi dengan repository.
3. **Navigation**: Menggunakan `NavHost` untuk berpindah antara `HomeScreen` (daftar) dan `DetailScreen` (detail).
4. **Theme**: Custom theme dan typography menggunakan MaterialTheme M3.

## API yang Digunakan
- **Base URL**: `https://api.tenrai.org/v1/`
- **Endpoints**: `/anime` dan `/anime/{id}`

## Cara Menjalankan
1. Clone repository ini.
2. Buka di Android Studio (Koala atau lebih baru).
3. Pastikan perangkat/emulator terhubung ke internet.
4. Build dan Run aplikasi.
