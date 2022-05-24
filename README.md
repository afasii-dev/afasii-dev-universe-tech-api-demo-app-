# ENDPOINTS (CRUD):

### 1. Get all users:

     GET: http://localhost:8080/v1/users/        

### 2. Get user by Id:

     GET: http://localhost:8080/v1/users/{id}  

### 3. Save User

     POST: http://localhost:8080/v1/users/
     {
        "username":"{username}",
        "password":"{password}"
     }

### 4. Update User

     PUT: http://localhost:8080/v1/users/
     {
        "id":"{id}",
        "username":"{username}",
        "password":"{password}"
     }

### 5. Delete user by Id

     DELETE: http://localhost:8080/v1/users/{id} 
