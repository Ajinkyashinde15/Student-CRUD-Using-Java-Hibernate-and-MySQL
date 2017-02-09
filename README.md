# Student-CRUD-Using-Java-Hibernate-and-MySQL

In this project, I have created a simple CRUD (Create Read Update Delete) User Management Console Application using Java, Hibernate and MySQL. In this project I have shown OnetoOne mapping between Stundet and StudenDetails tables.

Software Stack:-

1. Eclipse IDE for Java EE Developers (Indigo – ver. 3.7)

2. MySQL Community Server and MySQL Workbench (GUI Tool) OR PHPmyAdmin(XAMPP Server)

3. MySQL Connector for Java (mysql-connector-java-5.1.38-bin.jar file)

4. Hibernate ORM (download jar files from http://hibernate.org/downloads)

First, lets create the database and table for User using the following SQL scripts. I have created two Tables. StudentDerails table connect with Student table via foreign key (id). 

CREATE TABLE `studentt` (
  `id` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `school` varchar(40) NOT NULL,
  `year` varchar(40) NOT NULL,
  `marks` varchar(40) NOT NULL
);

CREATE TABLE `studentdetails` (
  `id` int(11) NOT NULL,
  `address` varchar(40) NOT NULL,
  `mobile` int(11) NOT NULL
) ;

ALTER TABLE `studentdetails`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `studentt`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `studentt`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
  
Following Screenshots are describe classes have been created to mapping hibernate and perform CRUD operations:-


# Student Model Java Class:

![picture alt](https://github.com/Ajinkyashinde15/Student-CRUD-Using-Java-Hibernate-and-MySQL/blob/master/Student%20class.png "Student Model Java Class")


# StudentDetails Model Java Class:

![picture alt](https://github.com/Ajinkyashinde15/Student-CRUD-Using-Java-Hibernate-and-MySQL/blob/master/StudentDetails%20class.png "StudentDetails Model Java Class")


# Controller Java Class:

![picture alt](https://github.com/Ajinkyashinde15/Student-CRUD-Using-Java-Hibernate-and-MySQL/blob/master/StudentController.png "Student Controller Java Class")


# hibernate.cfg.xml:

![picture alt](https://github.com/Ajinkyashinde15/Student-CRUD-Using-Java-Hibernate-and-MySQL/blob/master/hibernate.cfg.png "hibernate.cfg.xml")

