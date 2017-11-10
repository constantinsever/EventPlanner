
package eventplanner;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class eventTableModel extends AbstractTableModel implements Serializable{
    ArrayList<event> lista = new ArrayList<>(); //diamond operator

    
    @Override
    public int getRowCount() {
            return lista.size();
           }

    @Override
    public int getColumnCount() {
        return 3; // nr de coloane
    }

     public Object getElementAt(int pos) {
        return lista.get(pos);
        
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       event e = (event)lista.get(rowIndex);  
       switch(columnIndex){
              case 0 : e.setDate(aValue.toString());
              case 1 : e.setDescription(aValue.toString());  
              case 2 : e.setStatus(aValue.toString());  
          }
   
    }
    
    
    @Override
    public String getColumnName(int col) {
          switch(col){
              case 0 : return "Data si ora";
              case 1 : return "Descriere";    
              case 2 : return "Activ";    
          };
        return null;  
    }

     
    @Override
    public Object getValueAt(int row, int col) { // celulele din matrice, de fapt.
       event e = (event)lista.get(row);

        switch(col){
            case 0: return e.getDateDisplay(); //  afisare in forma 04/12  14:15
            case 1: return e.getDescription();
            case 2: return e.getStatus();
        }
        return null;

    }
    
}
