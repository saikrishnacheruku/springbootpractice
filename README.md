In this project, we will build a Spring Boot application to offer a REST service for the 'NxtTrendz' application. Within 'NxtTrendz', users can delve into reviews associated with distinct products, gaining insights into user sentiments and feedback.

For this endeavor, the main entities to be modeled are `Product` and `Review`. The `Review` entity has a Many-to-One relationship with the `Product` entity.

<details>
<summary>**Implementation Files**</summary>

Use these files to complete the implementation:

- `ReviewController.java`
- `ReviewRepository.java`
- `ReviewJpaService.java`
- `ReviewJpaRepository.java`
- `Review.java`
- `ProductController.java`
- `ProductRepository.java`
- `ProductJpaService.java`
- `ProductJpaRepository.java`
- `Product.java`

</details>

Create a database that contains two tables `product` and `review` using the given database schema.

You can refer to this [session](https://learning.ccbp.in/course?c_id=e345dfa4-f5ce-406e-b19a-4ed720c54136&s_id=6a60610e-79c2-4e15-b675-45ddbd9bbe82&t_id=f880166e-2f51-4403-81a0-d2430694dae8), for creating a database.

_Create the SQL files and compose accurate queries to run the application. Inaccurate SQL files will result in test case failures._

<details>
<summary>**Database Schema**</summary>

#### Product Table

|   Columns   |                 Type                  |
| :---------: | :-----------------------------------: |
|  productId  | INTEGER (Primary Key, Auto Increment) |
| productName |                 TEXT                  |
|    price    |                DOUBLE                 |

#### Review Table

|    Columns    |                 Type                  |
| :-----------: | :-----------------------------------: |
|   reviewId    | INTEGER (Primary Key, Auto Increment) |
| reviewContent |                 TEXT                  |
|    rating     |                INTEGER                |
|   productId   |         INTEGER (Foreign Key)         |

You can use the given sample data to populate the tables.

<details>
<summary>**Sample Data**</summary>

#### Product Data

| productId |  productName   |  price  |
| :-------: | :------------: | :-----: |
|     1     |   Smartphone   | 599.99  |
|     2     |     Laptop     | 1299.99 |
|     3     | Gaming Console | 399.99  |

#### Review Data

| reviewContent               | rating | productId |
| :-------------------------- | :----: | :-------: |
| Great battery life!         |   5    |     1     |
| Lags sometimes.             |   3    |     1     |
| Perfect for my daily tasks! |   4    |     2     |
| Bit pricey, but worth it.   |   4    |     2     |
| Awesome gaming experience!  |   5    |     3     |
| Needs more exclusive games. |   4    |     3     |

</details>

</details>

<MultiLineNote>

Use only `review` and `product` as the table names in your code.

</MultiLineNote>

### Completion Instructions

- `Review.java`: The `Review` class should contain the following attributes.

    |   Attribute   |  Type   |
    | :-----------: | :-----: |
    |   reviewId    |   int   |
    | reviewContent | String  |
    |    rating     |   int   |
    |    product    | Product |

- `ReviewRepository.java`: Create an `interface` containing the required methods.
- `ReviewJpaService.java`: Update the service class with logic for managing review data.
- `ReviewController.java`: Create the controller class to handle HTTP requests.
- `ReviewJpaRepository.java`: Create an interface that implements the `JpaRepository` interface.
  
- `Product.java`: The `Product` class should contain the following attributes.

    |  Attribute  |  Type  |
    | :---------: | :----: |
    |  productId  |  int   |
    | productName | String |
    |    price    | double |

- `ProductRepository.java`: Create an `interface` containing the required methods.
- `ProductJpaService.java`: Update the service class with logic for managing product data.
- `ProductController.java`: Create the controller class to handle HTTP requests.
- `ProductJpaRepository.java`: Create an interface that implements the `JpaRepository` interface.

Implement the following APIs.

<details>
<summary>**API 1: GET /products**</summary>

#### Path: `/products`

#### Method: `GET`

#### Description:

Returns a list of all products in the `product` table.

#### Response

```json
[
    {
        "productId": 1,
        "productName": "Smartphone",
        "price": 599.99
    },
    ...
]
```

</details>

<details>
<summary>**API 2: POST /products**</summary>

#### Path: `/products`

#### Method: `POST`

#### Description:

Creates a new product in the `product` table. The `productId` is auto-incremented.

#### Request

```json
{
    "productName": "Smartwatch",
    "price": 199.99
}
```

#### Response

```json
{
    "productId": 4,
    "productName": "Smartwatch",
    "price": 199.99
}
```

</details>

<details>
<summary>**API 3: GET /products/{productId}**</summary>

#### Path: `/products/{productId}`

#### Method: `GET`

#### Description:

Returns a product based on the `productId`. If the given `productId` is not found in the `product` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.


#### Success Response

```json
{
    "productId": 2,
    "productName": "Laptop",
    "price": 1299.99
}
```

</details>

<details>
<summary>**API 4: PUT /products/{productId}**</summary>

#### Path: `/products/{productId}`

#### Method: `PUT`

#### Description:

Updates the details of a product based on the `productId` and returns the updated product details. If the given `productId` is not found in the `product` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.

#### Request

```json
{
    "productName": "Headphones",
    "price": 99.99
}
```

#### Success Response

```json
{
    "productId": 2,
    "productName": "Headphones",
    "price": 99.99
}
```

</details>

<details>
<summary>**API 5: DELETE /products/{productId}**</summary>

#### Path: `/products/{productId}`

#### Method: `DELETE`

#### Description:

Deletes a product from the `product` table based on the `productId` and returns the status code `204`(raise `ResponseStatusException` with `HttpStatus.NO_CONTENT`). If the given `productId` is not found in the `product` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`. 

</details>

<details>
<summary>**API 6: GET /products/reviews**</summary>

#### Path: `/products/reviews`

#### Method: `GET`

#### Description:

Returns a list of all reviews in the `review` table.

#### Response

```json
[
    {
        "reviewId": 1,
        "reviewContent": "Great battery life!",
        "rating": 5,
        "product": {
            "productId": 1,
            "productName": "Smartphone",
            "price": 599.99
        }
    },
    ...
]
```

</details>

<details>
<summary>**API 7: POST /products/reviews**</summary>

#### Path: `/products/reviews`

#### Method: `POST`

#### Description:

Creates a new review in the `review` table and create an association between the review and the product based on the `productId` of the `product` field. The `reviewId` is auto-incremented.

#### Request

```json
{
    "reviewContent": "Comfortable and lightweight.",
    "rating": 5,
    "product": {
        "productId": 4
    }
}
```

#### Response

```json
{
    "reviewId": 7,
    "reviewContent": "Comfortable and lightweight.",
    "rating": 5,
    "product": {
        "productId": 4,
        "productName": "Smartwatch",
        "price": 199.99
    }
}
```

</details>

<details>
<summary>**API 8: GET /products/reviews/{reviewId}**</summary>

#### Path: `/products/reviews/{reviewId}`

#### Method: `GET`

#### Description:

Returns a review based on the `reviewId`. If the given `reviewId` is not found in the `review` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.


#### Success Response

```json
{
    "reviewId": 2,
    "reviewContent": "Lags sometimes.",
    "rating": 3,
    "product": {
        "productId": 1,
        "productName": "Smartphone",
        "price": 599.99
    }
}
```

</details>

<details>
<summary>**API 9: PUT /products/reviews/{reviewId}**</summary>

#### Path: `/products/reviews/{reviewId}`

#### Method: `PUT`

#### Description:

Updates the details of a review based on the `reviewId` and returns the updated review details. If the `productId` in the `product` field is provided, update the association between the review and the product based on the `productId`. If the given `reviewId` is not found in the `review` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.

#### Request

```json
{
    "reviewContent": "Sound quality is average.",
    "rating": 3,
    "product": {
        "productId": 2
    }
}
```

#### Success Response

```json
{
    "reviewId": 7,
    "reviewContent": "Sound quality is average.",
    "rating": 3,
    "product": {
        "productId": 2,
        "productName": "Headphones",
        "price": 99.99
    }
}
```

</details>

<details>
<summary>**API 10: DELETE /products/reviews/{reviewId}**</summary>

#### Path: `/products/reviews/{reviewId}`

#### Method: `DELETE`

#### Description:

Deletes a review from the `review` table based on the `reviewId` and returns the status code `204`(raise `ResponseStatusException` with `HttpStatus.NO_CONTENT`). If the given `reviewId` is not found in the `review` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.

</details>

<details>
<summary>**API 11: GET /reviews/{reviewId}/product**</summary>

#### Path: `/reviews/{reviewId}/product`

#### Method: `GET`

#### Description:

Returns a product of the review based on the `reviewId`. If the given `reviewId` is not found in the `review` table, raise `ResponseStatusException` with `HttpStatus.NOT_FOUND`.

#### Response

```json
{
    "productId": 1,
    "productName": "Smartphone",
    "price": 599.99
}
```

</details>

**Do not modify the code in `NxtTrendzApplication.java`**