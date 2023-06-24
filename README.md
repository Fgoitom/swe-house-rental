# swe-house-rental
This is the Student Project of Group 1 : House Rental Management System.

# Before run project please run this docker command in order to run database on your machine : 
docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=toor -e MYSQL_DATABASE=houserental mysql
docker build -t app .
docker run app

# Or you are too lazy you can run :
docker-compose up

# Document space
https://mum0-my.sharepoint.com/:f:/r/personal/dinhhuy_dang_miu_edu/Documents/CS425-2023-06A-06D-01_Group1

# Jira board
https://swe-group1.atlassian.net/jira/software/projects/HRS/boards/1/roadmap

# Data and structure
Here's the full implementation of the House Rental Management System problem statement, including the tables and their structure:

**Table: Property**

| Property ID | Landlord ID | Property Name | Number of Rooms | Pricing | Location |
|-------------|-------------|---------------|-----------------|---------|----------|
| 1           | 101         | Property A    | 3               | $1000   | City X   |
| 2           | 102         | Property B    | 2               | $800    | City Y   |
| 3           | 103         | Property C    | 4               | $1500   | City Z   |

**Table: User**

| User ID | User Type     | Username   | Password |
|---------|---------------|------------|----------|
| 1       | Administrator | admin      | ******** |
| 101     | Landlord      | landlord1  | ******** |
| 102     | Landlord      | landlord2  | ******** |
| 201     | Customer      | customer1  | ******** |
| 202     | Customer      | customer2  | ******** |

**Table: Application**

| Application ID | User ID | Property ID | Application Date |
|----------------|---------|-------------|-----------------|
| 1              | 201     | 1           | 2023-05-20      |
| 2              | 202     | 2           | 2023-05-21      |
| 3              | 201     | 3           | 2023-05-22      |

**Table: Contract**

| Contract ID | Application ID | Landlord ID | Customer ID | Start Date | End Date   |
|-------------|----------------|-------------|-------------|------------|------------|
| 1           | 1              | 101         | 201         | 2023-06-01 | 2023-12-01 |
| 2           | 2              | 102         | 202         | 2023-07-01 | 2024-01-01 |

