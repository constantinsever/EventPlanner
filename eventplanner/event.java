
package eventplanner;

import java.awt.event.ActionListener;
import java.io.Serializable;


public class event implements Serializable {
     String day, month, hour, minute, active;
     String description;
     
     public event(String dateTime, String aDescription){
         description = aDescription;
         
         if (dateTime != "")
         {
          String[] parts = dateTime.split(":");
          day = parts[0];
          month = parts[1];
          hour = parts[2];
          minute = parts[3];
          active = parts[4];
         }
     }
      
     public void setDate(String dateString ){ // 21/07/16/45
        String[] parts = dateString.split(":");
        day = parts[0];
        month = parts[1];
        hour = parts[2];
        minute = parts[3];
        active = parts[4];
    }
     
     public String getDate(){
         String s = day +':' + month + ':' +hour + ':' +minute;
         return s;
      }
    
     public String getDateDisplay(){ //afisare in forma [04/12  14:15]
         String s = day + '/' + month + "  " + hour + ':' + minute;
         return s;
     }
     
     public String getDescription(){
        return description;    
    }
    
    public void setDescription(String s){
        description = s;
    }
    
    public void setStatus(String s){
        active = s;
    }
     
     public String getStatus(){
        return active;    
    }
   
     
   //getteri  pt eveniment
     
     
  public String getDay(){
      return day;
  }
  
  public String getMonth(){
      return month;
  }
    
  public String getHour(){
      return hour;
  }
     
  public String getMinute(){
      return minute;
  } 
}


