-- tra thong tin hoc sinh trong 1 lop
Select Class.ClassName, [User].UserID, [User].name, [User].email, [User].password, [User].dob,[User].gender, [User].phone, [User].address, [User].majorsID, Majors.MajorsName , [User].roleID, [Role].roleName
from Class 
left join ClassMember on Class.ClassID = ClassMember.ClassID
left join [User] on ClassMember.UserID = [User].UserID 
left join Majors on [User].majorsID = [Majors].MajorsID
left join [Role] on [User].roleID = [Role].roleID
where Class.ClassID = 2