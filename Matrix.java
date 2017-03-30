import java.io.*;

// This is still  a comment
  public class Matrix{

    private int n;
    private double mdata[][];
    private int extra[][];
    private int another[][];

    public Matrix(int x){
      n = x;
      mdata = new double[n][n];
      extra = new int[n][n];
      another = new int[n][n];
    }


//set mdata
    public void setMdata(int k){
      for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
          if(extra[i][j] == 0){
            mdata[i][j] = k; extra[i][j] = 1;
            j = n + 1; i = n + 1;
          }
        }
      }
    }//end of setMdata


//get mdata
    public double getMdata(){
      double k = 0;

      for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
          if(another[i][j] == 0){
            another[i][j] = 1; k = mdata[i][j];
            j = n + 1; i = n + 1;
          }
        }
      }
      return k;
    }

//determinant funct
    public double determinant(){
      double det = 0.0;

      if(n == 1){
        det = mdata[0][0];
      }
      else if(n == 2){
        det = (mdata[0][0]*mdata[1][1]) - (mdata[0][1]*mdata[1][0]);
      }
      else{
        for(int i = 0; i < n; i++){
          det += Math.pow(-1.0, (double)i) * mdata[0][i] * subMatrix(0, i).determinant();
        }
      }

    return det;

    }//end of determinant

//subMatrix funct
    public Matrix subMatrix(int r, int c){
      Matrix sub = new Matrix(n - 1);

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
    public Matrix inverse(){
      Matrix inv = new Matrix(n);
      double det = determinant();

      for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
          inv.mdata[i][j] = Math.pow(-1.0, (double)i + j) * subMatrix(j,i).determinant() / det;
        }
      }
      return inv;

    }//end of inverse

  }//end of Matrix 

