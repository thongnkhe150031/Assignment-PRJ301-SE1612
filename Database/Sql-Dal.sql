use [project_Check_Attandance]
-- tra thong tin hoc sinh trong 1 lop
Select Class.ClassName, [User].UserID, [User].name, [User].email, [User].password, [User].dob,[User].gender, [User].phone, [User].address, [User].majorsID, Majors.MajorsName , [User].roleID, [Role].roleName
from Class 
left join ClassMember on Class.ClassID = ClassMember.ClassID
left join [User] on ClassMember.UserID = [User].UserID 
left join Majors on [User].majorsID = [Majors].MajorsID
left join [Role] on [User].roleID = [Role].roleID
where Class.ClassID = 2


--Get class in Schedule by Teacher
select ScheID,  [Schedule].UserID, [User].name, [User].email, [User].password, [User].dob,[User].gender, [User].phone, [User].address, 
[User].majorsID, Majors.MajorsName , [User].roleID, [Role].roleName, Schedule.ClassID, Class.ClassName, [Subject].SubID, [Subject].SubCode,[Subject].Subname, 
[Subject].numberSlot, Schedule.StartDate, Schedule.EndDate
from Schedule 
left join [User] on Schedule.UserID = [User].UserID
left join Majors on [User].majorsID = [Majors].MajorsID
left join [Role] on [User].roleID = [Role].roleID
left join [Subject] on Schedule.SubID = [Subject].SubID
left join [Class] on Schedule.ClassID = [Class].ClassID where Schedule.UserID = 10

--Get Class member in Schedule by Teacher and ClassID
Select distinct  [User].UserID, [User].email, [User].[password], [User].[name], [User].dob,
[User].gender, [User].[address], [User].phone, [User].majorsID, Majors.MajorsName, [User].roleID,
[Role].roleName from Schedule 
left join Class on Schedule .ClassID = Class.ClassID
left join ClassMember on Schedule.ClassID = ClassMember.ClassID
left join [User] on ClassMember.UserID = [User].UserID  
left join Majors on [User].majorsID =  Majors.MajorsID
left join [Role] on [User].roleID = [Role].roleID
where Schedule.ClassID = 1

--I
Select * from [User] -- 1 9 11 12 13
Select * from Schedule
Select * from Attendance
--get timetable in Table attendance where UserID

Select distinct Attendance.ScheID, [Subject].SubCode, [Date], Attendance.SlotID, Slot.[Time]
from Attendance left join Schedule 
on Attendance.ScheID = Schedule.ScheID
left join [Subject] on Schedule.SubID = [Subject].SubID
left join Slot on Attendance.SlotID = Slot.SlotID
where Schedule.UserID = 4 and Schedule.ClassID = 1


Select AttenID, Attendance.ScheID, Attendance.UserID, [Date], SlotID, Attendance, note 
from Attendance left join Schedule 
on Attendance.ScheID = Schedule.ScheID
where Schedule.UserID = 4 and Schedule.ClassID = 1
select * from [user]
select * from Schedule
select * from Attendance
--view attend by Student
Select AttenID, Attendance.UserID as studentID ,Attendance.ScheID, Schedule.UserID, [User].email, [User].[password], [User].[name], [User].dob,
[User].gender, [User].[address], [User].phone, [User].majorsID, Majors.MajorsName, [User].roleID,
[Role].roleName, Schedule.ClassID, Class.ClassName, [Subject].SubID, [Subject].SubCode,[Subject].Subname, 
[Subject].numberSlot, Schedule.StartDate, Schedule.EndDate,[Date], Attendance.SlotID, Slot.[Time],Attendance, note from Attendance
left join Schedule on Attendance.ScheID = Schedule.ScheID
left join [User] on Schedule.UserID = [User].UserID 
left join [Majors] on [User].majorsID = [Majors].MajorsID
left join [Role] on  [User].roleID = [Role].roleID
left join [Subject] on [Schedule].SubID = [Subject].SubID
left join [Class] on [Schedule].ClassID = [Class].ClassID
left join [Slot] on [Attendance].SlotID = Slot.SlotID
where Attendance.UserID =1




                    