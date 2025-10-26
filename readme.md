# European Company Crawler 🌍

A full-stack application that aggregates company data from multiple European countries (UK, France, Germany) with search and filtering capabilities.

**🔗 Live Demo:** https://java-company-crawler.vercel.app

---

## 🛠️ Tech Stack

### Backend
- **Java 21** - Modern Java with latest features
- **Spring Boot 3.3** - REST API framework
- **PostgreSQL** - Production database (Render)
- **H2** - Local development database
- **Maven** - Dependency management

### Frontend
- **TypeScript** - Type-safe JavaScript
- **React** - UI framework
- **Semantic UI** - Component library
- **Axios** - HTTP client
---

## 🚀 Quick Start

### Prerequisites
- Java 21+
- Node.js 18+
- Maven 3.8+

### Backend Setup

```bash
# Clone repository
git clone https://github.com/THETOTOJ/JavaCompanyCrawler.git
cd JavaCompanyCrawler

# Run backend
mvn spring-boot:run

# Backend runs on http://localhost:8080
```

### Frontend Setup

```bash
# Navigate to frontend
cd frontend

# Install dependencies
npm install

# Run development server
npm start

# Frontend runs on http://localhost:3000
```

---

## 🌐 Deployment

### Backend
- **Platform:** Render.com
- **URL:** https://javacompanycrawler.onrender.com
- **Database:** PostgreSQL (Render)
- **Monitoring:** UptimeRobot pings every 5 minutes to keep backend awake

### Frontend
- **Platform:** Vercel
- **URL:** https://java-company-crawler.vercel.app
- **Auto-deploys:** On git push to main branch

---

## ⚙️ Keep-Alive Strategy

Free-tier backends sleep after 15 minutes of inactivity. To prevent cold starts:

1. **UptimeRobot** - Pings backend every 5 minutes
2. **GitHub Actions** - Automated cron job every 10 minutes

This ensures ~200ms response time instead of 50-second cold starts.

---

## 📊 Features

- 🔍 Search companies by name or registration number
- 🌍 Filter by country (UK, France, Germany)
- 📈 Real-time statistics dashboard
- 🏢 15 sample companies across 3 countries
- 🎨 Semantic UI design system

---

## 🔧 API Endpoints

```
POST   /api/companies/crawl           - Load company data
GET    /api/companies                 - Get all companies
GET    /api/companies/search?q=term   - Search companies
GET    /api/companies/country/{code}  - Filter by country
```

---

## 📂 Project Structure

```
JavaCompanyCrawler/
├── src/main/java/com/taha/CompanyCrawler/
│   ├── controller/     # REST endpoints
│   ├── service/        # Business logic
│   ├── model/          # Database entities
│   ├── repository/     # Data access
│   └── config/         # CORS & configuration
├── frontend/
│   ├── src/
│   │   ├── components/ # React components
│   │   ├── services/   # API client
│   │   └── App.tsx     # Main application
│   └── package.json
└── pom.xml
```

---

## 👨‍💻 Local Development

### Backend Environment

Development uses H2 in-memory database (no setup required).

For PostgreSQL in production, set environment variable:
```bash
DATABASE_URL=postgresql://user:pass@host:5432/dbname
```

### Frontend Environment

Create `frontend/.env.local`:
```
REACT_APP_API_URL=http://localhost:8080/api
```

---

## 📝 Notes

- Mock data is used to demonstrate data aggregation patterns
- Production-ready architecture - easy to swap mock data with real APIs
- Designed to showcase multi-source data integration skills

---

## 🔗 Links

- **Live App:** https://java-company-crawler.vercel.app
- **Backend API:** https://javacompanycrawler.onrender.com/api/companies
- **GitHub:** https://github.com/THETOTOJ/JavaCompanyCrawler

---

## 📧 Contact

**Taha Tahiri Jotey**
- Portfolio: [tahiri.xyz](https://tahiri.xyz)
- LinkedIn: [linkedin.com/in/tahatj](https://linkedin.com/in/tahatj)
- Email: tahirijoteytaha@gmail.com

---

Built as a learning project to demonstrate Java backend development and full-stack capabilities.