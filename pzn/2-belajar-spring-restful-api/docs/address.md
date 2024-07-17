# Address API spec

## Create Address

Endpoint : POST /api/contacts/{contactId}/addresses

Request Header :
- X-API-TOKEN: Token (Mandatory)

Request Body :

```json
{
  "street": "Jalan apa",
  "city": "Kota Apa",
  "province": "Provinsi",
  "country": "Negara",
  "postalCode": "12311"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "<random-string>",
    "street": "Jalan apa",
    "city": "Kota Apa",
    "province": "Provinsi",
    "country": "Negara",
    "postalCode": "12311"
  }
}
```

Response Body (Failed, 404) :

```json
{
  "errors": "Contact is not found" 
}
```

## Update Address

Endpoint : PUT /api/contacts/{contactId}/addresses/{addressId}

Request Header :
- X-API-TOKEN: Token (Mandatory)

Request Body :

```json
{
  "street": "Jalan apa",
  "city": "Kota Apa",
  "province": "Provinsi",
  "country": "Negara",
  "postalCode": "12311"
}
```

Response Body (Success) :

```json
{
  "data": {
    "id": "<random-string>",
    "street": "Jalan apa",
    "city": "Kota Apa",
    "province": "Provinsi",
    "country": "Negara",
    "postalCode": "12311"
  }
}
```

Response Body (Failed, 404) :

```json
{
  "errors": "Contact is not found" 
}
```

## Get Address

Endpoint : GET /api/contacts/{contactId}/addresses/{addressId}

Request Header :
- X-API-TOKEN: Token (Mandatory)

Response Body (Success) :

```json
{
  "data": {
    "id": "<random-string>",
    "street": "Jalan apa",
    "city": "Kota Apa",
    "province": "Provinsi",
    "country": "Negara",
    "postalCode": "12311"
  }
}
```

Response Body (Failed, 404) :

```json
{
  "errors": "Contact is not found" 
}
```

```json
{
  "errors": "Address is not found"
}
```

## Remove Address

Endpoint : DELETE /api/contacts/{contactId}/addresses/{addressId}

Request Header :
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
  "errors": "Contact is not found" 
}
```

```json
{
  "errors": "Address is not found"
}
```

## List Address

Endpoint : GET /api/contacts/{contactId}/addresses

Request Header :
- X-API-TOKEN: Token (Mandatory)

Response Body (Success) :

```json
{
  "data": [
    {
      "id": "<random-string>",
      "street": "Jalan apa",
      "city": "Kota Apa",
      "province": "Provinsi",
      "country": "Negara",
      "postalCode": "12311"
    },
    ....
  ]
}
```

Response Body (Failed, 404) :

```json
{
  "errors": "Contact is not found" 
}
```

