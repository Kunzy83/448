class Foo
{
    public static void main(String args[]){
      if(args.length < 3){
        System.out.println("Error - Expected usage: ./main input.txt output.tx");
        return 1;
      }
      
      //Initialize file streams
      in = new FileInputStream(args[1]);
      out = new FIleOutputStream(args[2]);
      
      //Process commands
      int n;
      while(in >> n && n > 0){
        Matrix m(n);
      }
    }
}
