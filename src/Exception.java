
  public   class Exception extends Error{
      private static final long serialVersionUID = 1L;
      public Exception(String str){
          super(str);
      }
      public String getLocalizedMessage(){
          return "This is MyException";
      }
  }

