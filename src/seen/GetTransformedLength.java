package seen;

public class GetTransformedLength {
    /**
     * 除了z以外的 a->b, z->ab 返回长度
     */
    public static int getTransformedLength(String word, int t) {
        StringBuilder sb = new StringBuilder();
        while(t > 0){
            char[] chars = word.toCharArray();
            for(char c : chars){
                if(c != 'z'){
                    sb.append((char)(c+1));
                }else{
                    sb.append("ab");
                }
            }
            t--;
            word = sb.toString();
            sb.setLength(0);
        }
        return word.length();
    }

    public static void main(String[] args) {
        System.out.println(getTransformedLength("abz",2));
    }
}
