-- 
-- SQL Server ...
-- 
CREATE DATABASE delphix_demo;
GO
use delphix_demo;
GO

CREATE TABLE dbo.EMPLOYEES  (
	EMPLOYEE_ID int identity, 
    	FIRST_NAME VARCHAR(50), 
	LAST_NAME VARCHAR(50), 
	DEPT_NAME VARCHAR(50), 
	CITY VARCHAR(50)
);

CREATE TABLE dbo.MEDICAL_RECORDS (
	"PATIENT_ID" int PRIMARY KEY, 
	"PHONE_NUMBER" VARCHAR(30), 
	"MEDICAL_RECORD_NUMBER" VARCHAR(30), 
	"EMAIL" VARCHAR(40), 
	"ADDRESS" VARCHAR(60)
);

CREATE TABLE dbo.PATIENT (
	"PATIENT_ID" int PRIMARY KEY, 
	"FIRSTNAME" VARCHAR(40), 
	"LASTNAME" VARCHAR(40), 
	"SOCIAL_SECURITY_NUMBER" VARCHAR(11), 
	"ADDRESS" VARCHAR(60), 
	"CITY" VARCHAR(15), 
	"ZIPCODE" VARCHAR(10), 
	"DOB" DATE, 
	"PHONE_NUMBER" VARCHAR(24), 
	"EMAIL" VARCHAR(40)
);

CREATE TABLE dbo.PATIENT_DETAILS (
	"PATIENT_ID" int PRIMARY KEY, 
	"PHONE_NUMBER" VARCHAR(30), 
	"MEDICAL_RECORD_NUMBER" VARCHAR(30), 
	"ACCOUNT_NUMBER" VARCHAR(30), 
	"CC_NUMBER" VARCHAR(30)
);

Insert into EMPLOYEES (FIRST_NAME,LAST_NAME,DEPT_NAME,CITY) values ('Woody','Evans','Solution Architects','Hoboken');
Insert into EMPLOYEES (FIRST_NAME,LAST_NAME,DEPT_NAME,CITY) values ('Jeff','Zeisler','Solution Architects','Menlo Park');
Insert into EMPLOYEES (FIRST_NAME,LAST_NAME,DEPT_NAME,CITY) values ('Dr. Jeff','Wootton','Lyrical Rap Studies','Reston');
Insert into EMPLOYEES (FIRST_NAME,LAST_NAME,DEPT_NAME,CITY) values ('Dino','Konstantinos','Sales','Fantasyland');
Insert into EMPLOYEES (FIRST_NAME,LAST_NAME,DEPT_NAME,CITY) values ('Ted','Girard','Sales','Bethesda');
Insert into EMPLOYEES (FIRST_NAME,LAST_NAME,DEPT_NAME,CITY) values ('Adam','Bowen','No Sleep Till','Brooklyn');
Insert into EMPLOYEES (FIRST_NAME,LAST_NAME,DEPT_NAME,CITY) values ('Adam','Bowen','Solution Architects','Ashland');
Insert into EMPLOYEES (FIRST_NAME,LAST_NAME,DEPT_NAME,CITY) values ('Luther','Vandross','Superstar','NYC');
Insert into EMPLOYEES (FIRST_NAME,LAST_NAME,DEPT_NAME,CITY) values ('Ted','Girard','Sales','Bethesda');
Insert into EMPLOYEES (FIRST_NAME,LAST_NAME,DEPT_NAME,CITY) values ('Jude','Seth','Solution Architects','DK');
Insert into EMPLOYEES (FIRST_NAME,LAST_NAME,DEPT_NAME,CITY) values ('Darth','Vader','Imperial Army','Death Star');

Insert into MEDICAL_RECORDS (PATIENT_ID,PHONE_NUMBER,MEDICAL_RECORD_NUMBER,EMAIL,ADDRESS) values (1,'803-345-6789','4483838','raygun@aol.com','40 Presidential Dr');
Insert into MEDICAL_RECORDS (PATIENT_ID,PHONE_NUMBER,MEDICAL_RECORD_NUMBER,EMAIL,ADDRESS) values (2,'415-345-6789','5483838','bush@aol.com','2943 SMU Blvd');
Insert into MEDICAL_RECORDS (PATIENT_ID,PHONE_NUMBER,MEDICAL_RECORD_NUMBER,EMAIL,ADDRESS) values (3,'650-456-0987','6483838','obama@aol.com','1600 Pennsylvania Ave');
Insert into MEDICAL_RECORDS (PATIENT_ID,PHONE_NUMBER,MEDICAL_RECORD_NUMBER,EMAIL,ADDRESS) values (4,'123-321-9990','7483838','abe@hotmail.com','112 N 6th St');
Insert into MEDICAL_RECORDS (PATIENT_ID,PHONE_NUMBER,MEDICAL_RECORD_NUMBER,EMAIL,ADDRESS) values (5,'440-345-2345','8483838','Jeff@whitehouse.gov','7415 Arlington Blvd');

Insert into PATIENT (PATIENT_ID,FIRSTNAME,LASTNAME,SOCIAL_SECURITY_NUMBER,ADDRESS,CITY,ZIPCODE,DOB,PHONE_NUMBER,EMAIL) values (1,'Ronald','Reagan','474-78-1234','40 Presidential Dr','Simi Valley','93065-0987',null,'803-345-6789','raygun@aol.com');
Insert into PATIENT (PATIENT_ID,FIRSTNAME,LASTNAME,SOCIAL_SECURITY_NUMBER,ADDRESS,CITY,ZIPCODE,DOB,PHONE_NUMBER,EMAIL) values (2,'George','Bush','111-67-4321','2943 SMU Blvd','Dallas','75205-7367',null,'415-345-6789','bush@aol.com');
Insert into PATIENT (PATIENT_ID,FIRSTNAME,LASTNAME,SOCIAL_SECURITY_NUMBER,ADDRESS,CITY,ZIPCODE,DOB,PHONE_NUMBER,EMAIL) values (3,'Barack','Obama','650-12-5432','1600 Pennsylvania Ave','Washington DC','20500-6353',null,'650-456-0987','obama@aol.com');
Insert into PATIENT (PATIENT_ID,FIRSTNAME,LASTNAME,SOCIAL_SECURITY_NUMBER,ADDRESS,CITY,ZIPCODE,DOB,PHONE_NUMBER,EMAIL) values (4,'Abraham','Lincoln','673-11-3479','112 N 6th St','Springfield','62701-6363',null,'123-321-9990','abe@hotmail.com');
Insert into PATIENT (PATIENT_ID,FIRSTNAME,LASTNAME,SOCIAL_SECURITY_NUMBER,ADDRESS,CITY,ZIPCODE,DOB,PHONE_NUMBER,EMAIL) values (5,'Thomas','Jefferson','123-68-8765','7415 Arlington Blvd','Falls Church','22042-4242',null,'440-345-2345','Jeff@whitehouse.gov');

Insert into PATIENT_DETAILS (PATIENT_ID,PHONE_NUMBER,MEDICAL_RECORD_NUMBER,ACCOUNT_NUMBER,CC_NUMBER) values (1,'803-345-6789','3338383','4483838','4283897623459088');
Insert into PATIENT_DETAILS (PATIENT_ID,PHONE_NUMBER,MEDICAL_RECORD_NUMBER,ACCOUNT_NUMBER,CC_NUMBER) values (2,'415-345-6789','7338383','5483838','5683897623459088');
Insert into PATIENT_DETAILS (PATIENT_ID,PHONE_NUMBER,MEDICAL_RECORD_NUMBER,ACCOUNT_NUMBER,CC_NUMBER) values (3,'650-456-0987','8338383','6483838','3783897623459088');
Insert into PATIENT_DETAILS (PATIENT_ID,PHONE_NUMBER,MEDICAL_RECORD_NUMBER,ACCOUNT_NUMBER,CC_NUMBER) values (4,'123-321-9990','2338383','7483838','4283897623459088');

GO
