use [project_Check_Attandance]
-- tra thong tin hoc sinh trong 1 lop
Select Class.ClassName, [User].UserID, [User].name, [User].email, [User].password, [User].dob,[User].gender, [User].phone, [User].address, [User].majorsID, Majors.MajorsName , [User].roleID, [Role].roleName
from Class 
left join ClassMember on Class.ClassID = ClassMember.ClassID
left join [User] on ClassMember.UserID = [User].UserID 
left join Majors on [User].majorsID = [Majors].MajorsID
left join [Role] on [User].roleID = [Role].roleID
where Class.ClassID = 2


--Tra thoi khoa bieu 
select ScheID,  [Schedule].UserID, [User].name, [User].email, [User].password, [User].dob,[User].gender, [User].phone, [User].address, 
[User].majorsID, Majors.MajorsName , [User].roleID, [Role].roleName, Schedule.ClassID, Class.ClassName, [Subject].SubID, [Subject].SubCode,[Subject].Subname, 
[Subject].numberSlot, Schedule.StartDate, Schedule.EndDate
from Schedule 
left join [User] on Schedule.UserID = [User].UserID
left join Majors on [User].majorsID = [Majors].MajorsID
left join [Role] on [User].roleID = [Role].roleID
left join [Subject] on Schedule.SubID = [Subject].SubID
left join [Class] on Schedule.ClassID = [Class].ClassID where Schedule.UserID = 10
