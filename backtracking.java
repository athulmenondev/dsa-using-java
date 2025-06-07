class backtracking{
    public static void printperm(String str,String perm, int idx){
        if(str.length()==0){
            System.out.println(perm);
            return;
        }else{
            for(int i=0;i<str.length();i++){
             char currentch=str.charAt(i);
             String newstr=str.substring(0, i)+str.substring(i+1);
             printperm(newstr, perm+currentch, idx+1);
            }
        }
    }
    public static void main(String args [] ){
        printperm("ABC","",0);
    }
}