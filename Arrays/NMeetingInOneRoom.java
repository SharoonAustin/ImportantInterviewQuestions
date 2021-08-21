package Arrays;
import java.util.*;
public class NMeetingInOneRoom {
	
	public void NMeetingOneRoom(int start[],int end[]){
		int meetingCount=1;
		Arrays.sort(end);
		int currentMeetingEnd=end[0];
		System.out.print(meetingCount+++" ");
		
		for(int i=1;i<start.length;i++){
			if(currentMeetingEnd<=start[i]){
				System.out.print(meetingCount+" ");
				currentMeetingEnd=end[i];
			}
			meetingCount++;
		}
	}
	
	public static void main(String[] args) {
		NMeetingInOneRoom n1=new NMeetingInOneRoom();
		int S[] = {75250,50074,43659,8931,11273,
				27545,50879,77924};
		int F[] = {112960,114515,81825,93424,
				54316,35533,73383,160252};
		n1.NMeetingOneRoom(S, F);
	}

}
