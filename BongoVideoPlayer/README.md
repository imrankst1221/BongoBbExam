## Written test for Bongo’s Android Developer position.

## Problem: 
Write a video player application with ‘Play’, ‘Forward’, ‘Rewind’ functionalities. Please write pseudocode for this program and explain the design pattern you will use to develop these three functionalities. 

## Solution:
I choose the MVVM (Model-View-ViewModel) and Singleton design pattern with live data.

### Pseudocode for this program: 
```
Start: 
    initial video player in single instance

Play:
if video playing 
    pause the video and memorize the current time 
else
    if video time empty 
        start from begunning 
    else 
        start from memorized time
    
   
Forward: 
  set new_time (memorizer time + forwad)
 	if new_time not beyond maximum limit
		update video with new_time
	else 
		do nothing


Rewind: 
  set new_time (memorizer time - rewing)
if new_time is not negative
  update video with new_time
else 
	do nothing

```
