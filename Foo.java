
// This is still  a comment
class Foo
{
  public static void main(String args[]){
    if(args.length < 3)
      System.out.println("Error - Expected usage: ./main input.txt output.tx");
      return 1;
    }
      
    //Initialize file streams
    in = new FileInputStream(args[1]);
    out = new FIleOutputStream(args[2]);
      
    //Process commands
    int n;
    while( (n = System.in.read())> 0){
      Matrix m(n);
      in.read() m;

      out.write("M = \n"); // may have to use .getbytes() on end of string
      out.write(m);

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

//Matrix funct
  public class Matrix(int x){
    private int n = x;
    private double mdata = new double[10][10];// NOT SURE IF THIS IS CORRECT?

//determinant funct
    public static double determinant(){
      double det = 0.0;
      
      if(n == 1){
        det = mdata[0][0];
      }
      else if(n == 2){
        det = (mdata[0][0]*mdata[1][1]) - (mdata[0][1]*mdata[1][0]);
      }
      else{
        for(int i = 0; i < n; i++){
          det += Math.pow(-1.0, (double)i)) * mdata[0][i] * subMatrix(0, i).determinant();
        }
      }

    return det;

    }//end of determinant

//subMatrix funct
    public static Matrix subMatrix(int r, int c){
      Matrix sub(n - 1);

      int row = 0;
      for(int i = 0; i < n; i++){
        if(i == r) continue;

        int col = 0;
        for(int j = 0; j < n; j++){
          if(j == c) continue;

          sub.mdata[row][col] = mdata[i][j];
          ++col;
        }
        ++row;
      }

      return sub;

    }//end of subMatrix


//inverse funct
    public static Matrix inverse(){
      Matrix inv(n);
      double det = determinant();

      for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
          inv.mdata[i][j] = pow(-1.0, (double)i + j) * subMatrix(j,i).determinant() / det;
        }
      }
      return inv;

    }//end of inverse

  }//end of Matrix 


}//end of Foo

