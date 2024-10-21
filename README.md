# How to run using Docker:

Navigate to the root directory of the project and run the following command to build and run the database including creation of the tables:

```
docker compose up --build -d
```

Go to the frontend directory and run the following command to build and run the frontend:

```
npm install
npm run dev
```

Go to the backend directory and run the following command to build and run the backend:

```
mvn spring-boot:run
```

