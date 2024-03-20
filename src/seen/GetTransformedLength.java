package seen;

public class GetTransformedLength {
    /**
     * 除了z以外的 a->b, z->ab 返回长度
     */
    public static int getTransformedLength(String word, int t) {
        int result = word.length();
        for(char c: word.toCharArray()){
            if(c == 'z'){
                result++;
            }else{
                if(Math.abs(c-'z')<=t){
                    result++;
                }
            }
        }
        return result % (10^9+7);
    }

    public static void main(String[] args) {
        System.out.println(getTransformedLength("bcdabz",2));
    }
}
