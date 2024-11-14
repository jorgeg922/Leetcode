# Write your MySQL query statement below
select class from (Select class, count(class) as c from Courses group by class) a where a.c >= 5;