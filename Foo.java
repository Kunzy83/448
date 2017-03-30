import java.lang.*;
import java.io.*;

// This is still  a comment
public class Foo
{
  public static int main(String args[]){
    if(args.length < 3){
      System.out.println("Error - Expected usage: ./main input.txt output.tx");
      return 1;
    }
      
    //Initialize file streams
    FileInputStream in = new FileInputStream(args[1]);
    FileOutputStream out = new FileOutputStream(args[2]);
      
    //Process commands
    int n = 1;
    while( n > 0){
      n = in.read();

      Matrix m = new Matrix(n);

      for(int i = 0; i < n; i++){  // read in the matrix
        for(int j = 0; j < n; j++){
          int k = in.read();
          m.setMdata(k);
        }
      }

      String str = "M = \n";
      byte b[] = str.getbytes();
      out.write(b); // may have to use .getbytes() on end of string

      for(int i = 0; i < n; i++){  // write out the matrix
        for(int j = 0; j < n; j++){
          out.write(m.getMdata[i][j]);
        }
        out.write('\n');
      }

      double det = m.determinant();
      out.write("det(M) = ");
      out.write(det);
      out.write('\n'); out.write('\n');

      if(det != 0){
        Matrix inv = m.inverse();

        out.write("Minv = \n");
        out.write(inv); outwrite('\n');
      }
    }
    return 0;

  }//end of main
}//end of Foo
