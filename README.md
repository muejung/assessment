# Posttest | ระบบย่อยซื้อลอตเตอรี่
_Developed by PRERTH NASA-NGIUM_

## User Stories
### Story: EXP01
#### ผู้ดูแลระบบ ทำการเพิ่มใบลอตเตอรี่ เพื่อที่จะสร้างคลังเก็บลอตเตอรี่

– ยืนยันสิทธิ์การเข้าใช้งานด้วย `Basic Authentication (username = admin, password = password)`
####
* Request URL
```java
  POST /admin/lotteries
```

* Request Body
```json
{
	"ticket": "123456",
	"price": 80,
	"amount": 1
}
```
* Response Body
```json
{
	"ticket": "123456",
	"price": 80,
	"amount": 1
}
```
– ผู้ดูแลระบบต้องทำการเพิ่ม `"ticket"` ด้วยตัวเลข 6 หลักเท่านั้น
* Request Body
```json
{
	"ticket": "123",
	"price": 80,
	"amount": 1
}
```
* Response Body
```json
"Lottery must contain 6 digits without spaces"
```
---

### Story: EXP02
#### ผู้ใช้ ดูรายการลอตเตอรี่ทั้งหมด เพื่อจะได้เลือกซื้อ

* Request URL
```java
  GET /lotteries
```

* Response Body
```json
"tickets": ["123456", "007007", "303030"]
```
---

### Story: EXP03
#### ผู้ใช้ ทำการซื้อลอตเตอรี่ เพื่อที่จะได้ลุ้นถูกหวย
– ผู้ใช้ป้อน `userId` และ `ticketId` ผ่านทาง URL `POST /users/:userId/lotteries/:ticketId`
####
* Request URL
```java
  POST /users/1234567890/lotteries/123456
```

* Response Body
```json
"id": "1"
```
โดย id แสดงถึงหมายเลขการทำรายการสั่งซื้อจาก ID ของตาราง `userId`

– ผู้ใช้ต้องทำการป้อน `"userId"` ด้วยตัวเลข 10 หลักเท่านั้น
* Request URL
```java
  POST /users/12345/lotteries/123456
```
* Response Body
```json
"UserId must contain 10 digits without spaces"
```
– ผู้ใช้ต้องทำการป้อน `"ticketId"` ด้วยตัวเลข 6 หลักเท่านั้น
* Request URL
```java
  POST /users/1234567890/lotteries/123
```
* Response Body
```json
"Lottery must contain 6 digits without spaces"
```
---

### Story: EXP04
#### ผู้ใช้ ดูรายการลอตเตอรี่ทั้งหมดที่เคยซื้อ
– ผู้ใช้ป้อน `userId` ผ่านทาง URL `POST /users/:userId/lotteries/`

* Request URL
```java
  GET /users/1234567890/lotteries
```

* Response Body
```java
"tickets": ["123456"|count:1|price:80, "007007"|count:1|price:80, 
Total Ticket = 2 | Total Price = 160]
```
– ผู้ใช้ต้องทำการป้อน `"userId"` ด้วยตัวเลข 10 หลักเท่านั้น
* Request URL
```java
  GET /users/12345/lotteries
```
* Response Body
```json
"UserId must contain 10 digits without spaces"
```
---

### Story: EXP05
#### ผู้ใช้ ทำการขายคืนลอตเตอรี่ เพื่อได้เงินคืน

– ผู้ใช้ป้อน `userId` และ `ticketId` ผ่านทาง URL `DELETE /users/:userId/lotteries/:ticketId`
####
* Request URL
```java
  DELETE /users/1234567890/lotteries/123456
```

* Response Body
```json
"tickets": "123456"
```
โดย "ticket" แสดงถึงลอตเตอรี่ใบที่ผู้ใช้ทำการขายคืน

– ผู้ใช้ต้องทำการป้อน `"ticketId"` ด้วยตัวเลข 6 หลักเท่านั้น
* Request URL
```java
  DELETE /users/1234567890/lotteries/123
```
* Response Body
```json
"Lottery must contain 6 digits without spaces"
```
– ผู้ใช้ต้องทำการป้อน `"ticketId"` ที่มีการทำรายการซื้อไปแล้วเท่านั้น
* Request URL
```java
  DELETE /users/1234567890/lotteries/999999
```
* Response Body
```json
"Lottery tickets you want to sell back were not found"
```