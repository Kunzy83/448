import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.*;
import java.lang.Byte;

// This is still  a comment
public class Foo
{
  public static void main(String[] args){
   try{
    if(args.length < 2){
      System.out.println("Error: not enough arguements");
      return;
    }

    //Initialize file streams
    //FileInputStream in = new FileInputStream(args[0]);
    //BufferedReader in = new BufferedReader( new FileReader(args[0]));
    Scanner scanner = new Scanner(new File(args[0]));
    //FileOutputStream out = new FileOutputStream(args[2]);
    BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));

    //Process commands
    int n = scanner.nextInt();//    int n = (int)in.read();

    while( n > 0){
      Matrix m = new Matrix(n);

      for(int i = 0; i < n; i++){  // read in the matrix
        for(int j = 0; j < n; j++){
          int k = scanner.nextInt();//in.read();
          m.setMdata(k);
        }
      }

      String str = "M = \n";
      //byte b[] = str.getbytes();
      //out.write(b); // may have to use .getbytes() on end of string
      out.write(str);

      for(int i = 0; i < n; i++){  // write out the matrix
        for(int j = 0; j < n; j++){
          out.write(Double.toString(m.getMdata()) + " ");
        }
        out.write('\n');
      }

      double det = m.determinant();

      out.write("det(M) = ");
      out.write(Double.toString(det));
      out.write('\n'); 
      out.write('\n');

      if(det != 0){

        Matrix inv = m.inverse();

        out.write("Minv = \n");

        for(int i = 0; i < n; i++){  // write out the matrix
          for(int j = 0; j < n; j++){
            out.write(Double.toString(inv.getMdata()) + " ");
          }
          out.write('\n');
        }


         out.write('\n');
      }
      n = scanner.nextInt();//in.read();
    }

    //close file stream
    scanner.close();//in.close();
    out.close();
   }
   catch(IOException ex){System.out.println("woops");}

    return;

  }//end of main
}//end of Foo
