import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;

// This is still  a comment
public class Foo
{
  public static int main(String args[]){
   try{
    if(args.length < 3){
      System.out.println("Error - Expected usage: ./main input.txt output.tx");
      return 1;
    }
      
    //Initialize file streams
    FileInputStream in = new FileInputStream(args[1]);
    //FileOutputStream out = new FileOutputStream(args[2]);
    BufferedWriter out = new BufferedWriter(new FileWriter(args[2]));

    //Process commands
    int n = in.read();
    int g = 0;
    while( n > 0){

      Matrix m = new Matrix(n);

      for(int i = 0; i < n; i++){  // read in the matrix
        for(int j = 0; j < n; j++){
          int k = in.read();
          m.setMdata(k);
        }
      }

      String str = "M = \n";
      //byte b[] = str.getbytes();
      //out.write(b); // may have to use .getbytes() on end of string
      out.write(str);

      for(int i = 0; i < n; i++){  // write out the matrix
        for(int j = 0; j < n; j++){
          out.write(Double.toString(m.getMdata()));
        }
        out.write('\n');
      }

      double det = m.determinant();
      out.write("det(M) = ");
      out.write(Double.toString(det));
      out.write('\n'); out.write('\n');

      if(det != 0){
        Matrix inv = m.inverse();

        out.write("Minv = \n");

        for(int i = 0; i < n; i++){  // write out the matrix
          for(int j = 0; j < n; j++){
            out.write(Double.toString(inv.getMdata()));
          }
          out.write('\n');
        }


         out.write('\n');
      }
      n = in.read();
    }

    //close file stream
    in.close();
    out.close();
   }
   catch(IOException|FileNotFoundException ex){System.out.println("woops");
    
    return 0;

  }//end of main
}//end of Foo
