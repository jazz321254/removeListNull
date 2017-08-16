# Remove List Null  

### Usage  

Please import Appach common CollectionUtils before use this object.

### example: 
```java
CollectionUtils.filter(Collection, AnyElementNotNullPredicate.anyElementNotNullPredicate());  
```
If List\<Object\> likes 
```java
[{"Id":null,"creator":"shawn"},{"Id":null,"creator":null},null]
```
After removal, it appears as follows
```java
[{"Id":null,"creator":"shawn"}]
```
