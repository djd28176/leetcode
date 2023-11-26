package lcjiajia.array;

public class lcr173 {
    /**
     某班级 n 位同学的学号为 0 ~ n-1。点名结果记录于升序数组 records。假定仅有一位同学缺席，请返回他的学号
     */
    public int takeAttendance(int[] records) {
        for(int i = 0; i < records.length;i++){
            if((records[i] ^ i) != 0){
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        lcr173 lcr173 = new lcr173();
        System.out.println(lcr173.takeAttendance(new int[]{0,1,2,3,5}));
    }
}
