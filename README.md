# movieLibrary

How to start the movieLibrary application
---

1. Run `mvn package` to build your application
1. Start application with `java -jar target/movie-library-1.0-SNAPSHOT.jar server config.yml`
1. Application running on `http://localhost:8080/movies`

---
# My answer for the question
`Write down a small description on how you would store the data in a database (NoSQL vs SQL) and explain your choice`

Arguments for NoSQL
1. Highly scalable by adding more servers
1. Optimized queries with large amounts of data(ex. better performance full text search)
1. Support distributed structure
1. Dynamic schema

Arguments for SQL
1. Support transactions
1. Relational model describes real-world-relatable data more naturally
1. Mature well defined software

To sum it up I would say that NoSQL is better for cases where data consistancy is not crucial, the performence is more important,
data is not well defined, the requirements are fluid and change over time.
An example would be a social network.

On the other hand the SQL is best for systems that require robust data integrity and have well defined data schema.
An example would be banking system.

This application is very basic - it does not require complex queries on large amounts of data
and it also should not require a schema change if enough research is put into defining all the possible fields describing the movie. 
The data consistancy that comes with transactions also is not crucial. It would seem that either one could be chosen.
However, the movie library is a real-world case best reflected with relations(actors/directors etc. participate in movies, moreover it is many-to-many type relationship).
Storing such data in NoSql would require relationship or data duplication. Choosing NoSql that is not relational by definition to store relational data makes no sense and is counterproductive.
This is why i would choose SQL.
