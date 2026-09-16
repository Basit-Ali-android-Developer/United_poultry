<h1 align="center">🐔 United Poultry</h1>
<p align="center">A comprehensive poultry business management app — built with Kotlin & MVVM.</p>

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-3DDC84?style=flat&logo=android&logoColor=white" />
  <img src="https://img.shields.io/badge/Kotlin-7F52FF?style=flat&logo=kotlin&logoColor=white" />
  <img src="https://img.shields.io/badge/Architecture-MVVM-1F3864?style=flat" />
  <img src="https://img.shields.io/badge/Koin-DI-orange?style=flat" />
  <img src="https://img.shields.io/badge/Status-In%20Development-yellow?style=flat" />
</p>

United Poultry digitizes and streamlines the complete day-to-day operations of a poultry distribution business — bringing products, orders, dealers, riders, deliveries, expenses, collections, and balances into one centralized platform, in place of manual record keeping.

---

## 📱 Screenshots

<!--
Drag and drop your screenshots directly into this file while editing it on GitHub's
web editor — GitHub uploads them and auto-inserts the image markdown for you.
Move those auto-generated <img> lines in here.
-->

<p align="center">
  <img src="screenshots/screenshot1.png" width="200" />
  <img src="screenshots/screenshot2.png" width="200" />
  <img src="screenshots/screenshot3.png" width="200" />
  <img src="screenshots/screenshot4.png" width="200" />
</p>

---

## 👨‍💼 Admin Panel

Centralized control over the entire business. Administrators can manage:

- Users, dealers, and riders
- Poultry products and product categories (Shop Module)
- Orders, new sales, and business transactions
- Expenses and expense heads
- Collections and payment records
- Previous balances and outstanding amounts
- Rider and delivery-related activities
- Reports and analytics (Admin Report Module)
- App-wide settings (Admin Settings Module)
- Business and operational records / history

## 👤 Rider / User Panel

Role-based access for employees, dealers, and riders. Depending on their role, users can:

- View their dashboard and assigned business activities
- Manage assigned orders and deliveries
- Track their own expenses (Rider Expense)
- View balances and collection information
- Handle product exchanges and waste returns
- Monitor their operational progress and history

## 🐔 Product Management

Supports multiple poultry product categories: **Petti, Tray, Cotton, Shopper, Liquid** — managed through the admin workflow with organized product records.

## 💰 Expense Management

Administrators can manage different **expense heads** and maintain expense records; riders can also track their own expenses individually.

## 💵 Collections & Balances

Handles financial records tied to customers and transactions:

- Collection records
- Previous balances and outstanding amounts
- Decimal-based collection values
- Transaction-related financial information

## ♻️ Exchange & Waste Return

Dedicated workflows for handling product exchanges and waste returns — keeping stock and business records accurate when products come back from the field.

## 🚚 Dealer & Rider Operations

Dedicated workflows connect the multiple parties involved in poultry distribution — dealers interact with the business per their assigned workflow, while riders manage delivery-related activities and their own dashboard, linking orders, users, and deliveries within one system.

## 📊 Unified Business Flow

```
Products → Orders → Dealers → Riders → Deliveries → Expenses → Collections → Balances → Business Records
```

---

## 📂 Project Structure

Organized by feature/module — each package owns a self-contained screen or capability, split cleanly across admin and rider responsibilities:

```
com.example.unitedpoultry/
 ├─ AdminHome/             # Admin dashboard entry point
 ├─ AdminDashBoard/        # Admin overview
 ├─ AdminArea/             # Admin-managed areas/regions
 ├─ adminproduct/          # Admin: product management
 ├─ AdminShopModule/       # Admin: shop/catalog management
 ├─ AdminExpense/          # Admin: expense heads & records
 ├─ AdminRiderModule/      # Admin: manage riders
 ├─ AdminReportModule/     # Admin: reports & analytics
 ├─ AdminSettingModule/    # Admin: app settings
 ├─ NewSale/               # New sale / order creation
 ├─ Collection/            # Collection records
 ├─ History/               # Transaction & activity history
 ├─ Notification/          # Notifications
 ├─ Profile/                # User profile
 ├─ Authentications/       # Login & auth
 ├─ RiderDashBoard/        # Rider dashboard
 ├─ RiderArea/             # Rider-assigned areas
 ├─ rider_home/            # Rider home screen
 ├─ rider_expense/         # Rider expense tracking
 ├─ ShopModule/             # Shop/product browsing
 ├─ exchange_return/       # Product exchange handling
 ├─ waste_return/          # Waste return handling
 ├─ status_check/          # Status/health checks
 ├─ Welcome/               # Onboarding/welcome screen
 ├─ Splash/                # Splash screen
 ├─ network/               # API/network layer
 ├─ util/                  # Shared utilities
 ├─ modules/               # Shared/common modules
 ├─ BaseActivity            # Shared base Activity
 ├─ MyApplication           # Application class
 ├─ RotateTransformation    # Image transform utility
 └─ SessionManager          # Session/auth state handling
```

---

## 🛠️ Tech Stack

- **Platform:** Android
- **Language:** Kotlin
- **Architecture:** MVVM
- **UI:** XML
- **Networking:** REST APIs
- **Dependency Injection:** Koin
- **Asynchronous Programming:** Kotlin Coroutines

---

## 🚀 Getting Started

```bash
git clone https://github.com/casdevelopment/United_poultry.git
```

1. Open the project in **Android Studio**
2. Let Gradle sync finish
3. Run on an emulator or physical device (min SDK: *add your min SDK here*)

---

<p align="center"><i>Built and maintained by <a href="https://github.com/Basit-Ali-android-Developer">Basit Ali</a></i></p>
