@echo off

set "currentYMD=%date:~,4%-%date:~5,2%-%date:~8,2% %time:~,2%:%time:~3,2%:%time:~6,2%" 
d:
cd D:\gitProject\doc
git pull origin master  
git status  
git add .  
git commit -m "update doc %currentYMD% "
git push origin master 