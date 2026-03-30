<p align="center">
  <img src="https://github.com/Muhammed-Turgut/imageRaw/blob/main/tarik_app_logo.png?raw=true" width="400"/>
</p>
<h1 align="center">Tarık App</h1>
<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white"/>
  <img src="https://img.shields.io/badge/Language-Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white"/>
  <img src="https://img.shields.io/badge/API-Google%20Maps-4285F4?style=for-the-badge&logo=googlemaps&logoColor=white"/>
  <img src="https://img.shields.io/badge/Data-AFAD-E63946?style=for-the-badge"/>
</p>
<p align="center">
  Google Maps API ve AFAD'ın son 50 deprem verisi kullanılarak harita üzerinde depremleri gösteren bir Android mobil uygulaması.
</p>

---

## 🔍 Proje Hakkında

Bu proje, **Google Maps API** ve **AFAD'ın gerçekleşen son 50 deprem API'si** kullanılarak geliştirilmiş bir Android Native mobil uygulamasıdır. Kotlin ile yazılmış olup kullanıcıların Türkiye'deki güncel deprem verilerini interaktif bir harita üzerinde takip etmesine olanak tanır.

**Özellikler:**
- 🗺️ Google Maps üzerinde gerçek zamanlı deprem görselleştirmesi
- 📡 AFAD API'sinden son 50 deprem verisini çekme
- 📍 Deprem konumlarını harita üzerinde işaretleme
- 💧 Splash screen ve kullanıcı dostu arayüz

---

## ⚙️ Kurulum

### 1. Google Maps API Key Alma

1. [Google Cloud Console](https://console.cloud.google.com/)'a gidin
2. Yeni bir proje oluşturun veya mevcut projeyi seçin
3. **Maps SDK for Android**'i etkinleştirin
4. **APIs & Services > Credentials** bölümünden API Key oluşturun

### 2. API Key'i Projeye Ekleme

API key'inizi `AndroidManifest.xml` dosyasındaki ilgili alana ekleyin. Detaylar için aşağıdaki kod bloğuna bakın.

---

## 💻 AndroidManifest.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <!-- USB host özelliği: Uygulamanın USB cihazlarla iletişim kurabilmesi için gereklidir -->
    <uses-feature
        android:name="android.hardware.usb.host"
        android:required="true" />

    <application
        android:name=".MyApplication"
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.Tarık_frontend_app">

        <!--
        ╔══════════════════════════════════════════════════════════════╗
        ║                  🔑 GOOGLE MAPS API KEY                     ║
        ╠══════════════════════════════════════════════════════════════╣
        ║  "YOUR_API" yazan kısmı kendi Google Maps API Key'inizle    ║
        ║  değiştirin.                                                 ║
        ║                                                              ║
        ║  Örnek:                                                      ║
        ║  android:value="AIzaSyBxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx"     ║
        ║                                                              ║
        ║  API Key almak için:                                         ║
        ║  https://console.cloud.google.com                           ║
        ║  → APIs & Services → Credentials → Create Credentials       ║
        ║                                                              ║
        ║  ⚠️  API Key'inizi asla GitHub'a push etmeyin!              ║
        ║     local.properties veya secrets.properties dosyasına      ║
        ║     koymanız güvenlik açısından önerilir.                    ║
        ╚══════════════════════════════════════════════════════════════╝
        -->
        <meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="YOUR_API_KEY_HERE" />

        <activity
            android:name=".MainActivity"
            android:exported="true"
            android:label="@string/app_name"
            android:theme="@style/Theme.Tarık_frontend_app">

            <!-- Uygulamanın başlangıç aktivitesi olarak tanımlanması -->
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>

            <!-- USB cihaz (örn: Arduino) takıldığında uygulamayı uyandırmak için -->
            <intent-filter>
                <action android:name="android.hardware.usb.action.USB_DEVICE_ATTACHED" />
            </intent-filter>

            <!--
                USB filtre dosyası: res/xml/device_filter.xml
                Bu dosyada izin verilen USB cihazların Vendor ID ve Product ID bilgileri tanımlanır.
                Yalnızca bu listede yer alan USB cihazlar uygulamayı tetikler.
            -->
            <meta-data
                android:name="android.hardware.usb.action.USB_DEVICE_ATTACHED"
                android:resource="@xml/device_filter" />

        </activity>
    </application>

</manifest>
```

> **⚠️ Güvenlik Notu:** API Key'inizi doğrudan `AndroidManifest.xml` içine yazmak yerine `local.properties` dosyasına ekleyip `build.gradle` üzerinden çekmeniz önerilir. Bu sayede API Key'inizi yanlışlıkla GitHub'a göndermezsiniz.

---

## ⚙️ Nasıl Çalışır?

1. Uygulama açıldığında AFAD API'sine istek atarak son 50 deprem verisini çeker
2. Gelen veriler parse edilerek her deprem için konum (enlem/boylam), büyüklük ve zaman bilgisi alınır
3. Google Maps üzerinde her deprem bir marker ile işaretlenir
4. Kullanıcı haritayı kaydırıp yakınlaştırarak depremleri inceleyebilir

---

## 📸 Uygulama Görüntüleri

<p align="center">
  <img src="https://github.com/Muhammed-Turgut/imageRaw/blob/main/tar%C4%B1k_app_spalsh_screen.png?raw=true" width="700"/>
  <br><i>Splash Screen</i>
</p>
<p align="center">
  <img src="https://github.com/Muhammed-Turgut/imageRaw/blob/main/tar%C4%B1k_app_home_screen.png?raw=true" width="700"/>
  <br><i>Ana Ekran - Deprem Haritası</i>
</p>
<p align="center">
  <img src="https://github.com/Muhammed-Turgut/imageRaw/blob/main/tar%C4%B1k_app_draw_screen.png?raw=true" width="700"/>
  <br><i>Çizim Ekranı</i>
</p>

---

<p align="center">
  <i>Made with ❤️ by Muhammed Turgut</i>
</p>
