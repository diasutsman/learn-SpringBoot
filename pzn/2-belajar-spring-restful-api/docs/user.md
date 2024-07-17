# User API Spec


## Register User

Endpoint : POST /api/users

Request Body

```json
{
  "username": "dias",
  "password": "password",
  "name": "Dias Utsman"
}
```

Response Body (Success) : 

```json
{
  "data": "OK"
}
```

Response Body (Failed) :

```json
{
  "errors": "Username must not be blank, ??"
}
```

## Login User

Endpoint : POST /api/auth/login

Request Body

```json
{
  "username": "dias",
  "password": "password"
}
```

Response Body (Success) :

```json
{
  "data": {
    "token": "TOKEN",
    "expiredAt": 324324234234324 // miliseconds
  }
}
```

Response Body (Failed, 401) :

```json
{
  "errors": "Username or password is wrong"
}
```

## Get User

Endpoint : GET /api/users/current

Headers:
- X-API-TOKEN: Token (Mandatory)

Response Body (Success) :

```json
{
  "data": {
    "username": "dias",
    "name": "Dias Utsman"
  }
}
```

Response Body (Failed, 401) :

```json
{
  "errors": "Unauthorized"
}
```

## Update User

Endpoint : PATCH /api/users/current

Headers:
- X-API-TOKEN: Token (Mandatory)

Request Body :

```json
{
  "name": "Dias Utsmans", // Use this if you want to update name
  "password": "password" // Use this if you want to update name
}
```

Response Body (Success) :

```json
{
  "data": {
    "username": "Dias Utsmans",
    "name": "password"
  }
}
```

Response Body (Failed, 401) :

```json
{
  "errors": "Unauthorized"
}
```


## Logout User

Endpoint : DELETE /api/auth/logout

Headers:
- X-API-TOKEN: Token (Mandatory)

Response Body (Success) :

```json
{
  "data": "OK"
}
```