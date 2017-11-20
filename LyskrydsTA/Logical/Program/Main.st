
PROGRAM _INIT
	(* Insert code here *)
	light_state_north := red_north;
	light_state_east := green_east;
END_PROGRAM

PROGRAM _CYCLIC
	
	//Timer at 1.5ms for each light change
	
	CASE light_state_north OF
		   
		red_north:
				
			light_timer.IN := TRUE;
			light_timer.PT := T#1500ms;
			
			IF light_timer.Q THEN
				red_north_bool := TRUE;
				red_south_bool := TRUE;
				yellow_south_bool := TRUE;
				yellow_north_bool := TRUE;
				green_north_bool := FALSE;
				green_south_bool := FALSE;
				light_state_north := ry_north;
				light_timer.IN := FALSE;
			END_IF
		
		yellow_north:
			
			light_timer.IN := TRUE;
			light_timer.PT := T#1500ms;	
			
			IF light_timer.Q THEN
				red_north_bool := FALSE;
				red_south_bool := FALSE;
				yellow_north_bool := FALSE;
				yellow_south_bool := FALSE;
				green_south_bool := TRUE;
				green_north_bool := TRUE;
				light_state_north := green_north;
				light_timer.IN := FALSE;
			END_IF
		
		green_north:
			
			light_timer.IN := TRUE;
			light_timer.PT := T#1500ms;	
			
			IF light_timer.Q THEN
				red_north_bool := FALSE;
				red_south_bool := FALSE;
				yellow_north_bool := TRUE;
				yellow_south_bool := TRUE;
				green_south_bool := FALSE;
				green_north_bool := FALSE;
				light_state_north := yellow_north;
				light_timer.IN := FALSE;
			END_IF
		
		ry_north:
		
			light_timer.IN := TRUE;
			light_timer.PT := T#1500ms;	
			
			IF light_timer.Q THEN
				red_north_bool := FALSE;
				red_south_bool := FALSE;
				yellow_north_bool := FALSE;
				yellow_south_bool := FALSE;
				green_south_bool := TRUE;
				green_north_bool := TRUE;
				light_state_north := green_north;
				light_timer.IN := FALSE;
			END_IF
			
		
	END_CASE
	
	CASE light_state_east OF
		
		red_east:
				
			light_timer.IN := TRUE;
			light_timer.PT := T#1500ms;
			
			IF light_timer.Q THEN
				red_west_bool := TRUE;
				red_east_bool := TRUE;
				yellow_west_bool := TRUE;
				yellow_east_bool := TRUE;
				light_state_east := yellow_east;
				light_timer.IN := FALSE;
			END_IF
		
		yellow_east:
			light_timer.IN := TRUE;
			light_timer.PT := T#1500ms;	
			
			IF light_timer.Q THEN
				red_west_bool := FALSE;
				red_east_bool := FALSE;
				yellow_west_bool := FALSE;
				yellow_east_bool := FALSE;
				green_west_bool := TRUE;
				green_east_bool := TRUE;
				light_state_east := green_east;
				light_timer.IN := FALSE;
			END_IF
		green_east:
			
			light_timer.IN := TRUE;
			light_timer.PT := T#1500ms;	
			
			IF light_timer.Q THEN
				red_west_bool := FALSE;
				red_east_bool := FALSE;
				yellow_west_bool := TRUE;
				yellow_east_bool := TRUE;
				green_west_bool := FALSE;
				green_east_bool := FALSE;
				light_state_east := yellow_east;
				light_timer.IN := FALSE;
			END_IF
		
		ry_east:
		
			light_timer.IN := TRUE;
			light_timer.PT := T#1500ms;	
			
			IF light_timer.Q THEN
				red_west_bool := FALSE;
				red_east_bool := FALSE;
				yellow_west_bool := FALSE;
				yellow_east_bool := FALSE;
				green_west_bool := TRUE;
				green_east_bool := TRUE;
				light_state_east := green_east;
				light_timer.IN := FALSE;
			END_IF
		
	END_CASE
	
	light_timer();
	
	
	 
END_PROGRAM

PROGRAM _EXIT
	(* Insert code here *)
	 
END_PROGRAM

