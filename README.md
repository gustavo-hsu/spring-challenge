<h1> How to test the application </h1>

<h3> Create some users </h3>
<h4> POST /users </h4>

```
{ 
    "name": "User1", 
    "seller": true
}
```
<h3> US 01: Follow a seller </h3>
<h4> POST /users/{userId}/follow/{userIdToFollow} </h4>

<h3> US 02: Get the number of followers from a user </h3>
<h4> GET /users/{userId}/followers/count </h4>

<h3> US 03: Get the list of followers from a user </h3>
<h4> GET /users/{userId}/followers/list </h4>

<h3> US 04: Get the list of followed sellers of a user </h3>
<h4> GET /users/{userId}/followed/list </h4>

<h3> US 05: Publish a new post </h3>
<h4> POST /products/newpost </h4>

Obs: only existent sellers can publish posts

```
{
    "userId": 2,
    "id_post": 2,
    "date": "02-06-2021",
    "detail": {
        "product_id": 2,
        "productName": "Cadeira Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 1,
    "price": 1500.50
}
```

You probably got an error, because there are none categories created. To create one:
<h4> POST /products/category </h4>
 ```
{ 
    "name": "CategoryName"
}
 ```

<h3> US 06: Get the post list of sellers followed by the user (last 2 weeks)  </h3>
<h4> GET /products/followed/{userId}/list </h4>


<h3> US 07: Unfollow a seller </h3>
<h4> POST /users/{userId}/unfollow/{userIdToUnfollow}</h4>

<h3> US 08: Order by name asc or desc</h3>
Examples:
<br>
GET
<br>
/users/{userId}/followers/list?order=name_asc <br>
/users/{userId}/followers/list?order=name_desc <br>
/users/{userId}/followed/list?order=name_asc <br>
/users/{userId}/followed/list?order=name_desc <br>

<h3> US 09: Order by date asc or desc </h3>
Examples:
<br>
GET
<br>
/products/followed/{userId}/list?order=date_asc <br>
/products/followed/{userId}/list?order=date_desc <br>

<h3> Extra Bonus </h3>

<h3> US 10: Publish a new promotion product </h3>
<h4> POST /products/newpromopost </h4>

```
{
    "userId": 2,
    "id_post": 2,
    "date": "02-06-2021",
    "detail": {
    "product_id": 2,
    "productName": "Cadeira Gamer",
    "type": "Gamer",
    "brand": "Racer",
    "color": "Red & Black",
    "notes": "Special Edition"
    },
    "hasPromo": true,
    "discount": 0.25,
    "category": 1,
    "price": 1500.50
}
```

<h3> US 11: Get the promotion products count from a seller </h3>
<h4> GET /products/{userId}/countPromo </h4>

<h3> US 12: Get all promotion product from a seller </h3>
<h4> GET /products/{userId}/list</h4>

_________
<h1> GO MELI !</h1>

![](src/main/resources/images/img.png)

Built by @gustavo-hsu for the bootcamp challenge