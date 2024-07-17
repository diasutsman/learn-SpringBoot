# Contact API Spec


## Create Contact
Endpoint : POST /api/contacts

Request Headers :
- X-API-TOKEN: Token (Mandatory)

Request Body :

```json
{
  "firstName": "Dias",
  "lastName": "Utsman",
  "email": "utsmand91@gmail.com",
  "phone": "0812868461212"
}
```

Response Body (Success) :
```json
{
  "data": {
    "id": "<random-string>",
    "firstName": "Dias",
    "lastName": "Utsman",
    "email": "utsmand91@gmail.com",
    "phone": "0812868461212"
  }
}
```

Response Body (Failed) : 
```json
{
  "errors": "Email format invalid, phone format invalid, ..."
}
```

## Update Contact
Endpoint : PUT /api/contacts/{contactId}

Request Headers :
- X-API-TOKEN: Token (Mandatory)

Request Body :

```json
{
  "firstName": "Dias",
  "lastName": "Utsman",
  "email": "utsmand91@gmail.com",
  "phone": "0812868461212"
}
```

Response Body (Success) :
```json
{
  "data": {
    "id": "<random-string>",
    "firstName": "Dias",
    "lastName": "Utsman",
    "email": "utsmand91@gmail.com",
    "phone": "0812868461212"
  }
}
```

Response Body (Failed) :
```json
{
  "errors": "Email format invalid, phone format invalid, ..."
}
```

## Get Contact

Endpoint : GET /api/contacts/{contactId}


Request Headers :
- X-API-TOKEN: Token (Mandatory)

Response Body (Success) :
```json
{
  "data": {
    "id": "<random-string>",
    "firstName": "Dias",
    "lastName": "Utsman",
    "email": "utsmand91@gmail.com",
    "phone": "0812868461212"
  }
}
```

Response Body (Failed, 404) :
```json
{
  "errors": "Contact not found"
}
```


## Search Contact
Endpoint : GET /api/contacts

Query params :
- name: String, contact first name or last name, using like query, optional
- phone: String, contact phone, using like query, optional
- email: String, contact email, using like query, optional
- page: integer, starts from 0, default 0
- size: integer, default 10

Request Headers :
- X-API-TOKEN: Token (Mandatory)

Response Body (Success) :
```json
{
  "data": [
    {
      "id": "<random-string>",
      "firstName": "Dias",
      "lastName": "Utsman",
      "email": "utsmand91@gmail.com",
      "phone": "0812868461212"
    }
  ],
  "paging": {
    "currentPage": 0,
    "totalPage": 10,
    "size": 10
  } 
}
```

Response Body (Failed) :
```json
{
  "errors": "Unauthorized"
}
```

## Remove Contact
Endpoint : DELETE /api/contacts/{contactId}

Request Headers :
- X-API-TOKEN: Token (Mandatory)

Response Body (Success) :
```json
{
  "data": "OK"
}
```

Response Body (Failed, 404) :
```json
{
  "errors": "Contact not found"
}
```