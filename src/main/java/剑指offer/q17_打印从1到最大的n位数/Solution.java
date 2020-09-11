package 剑指offer.q17_打印从1到最大的n位数;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    @Test
    public void test() {
        System.out.println(printNumbers(2));
    }
    public List<String> printNumbers(int n){
        List<String> result = new ArrayList<>();
        //找出当前选择列表的所有子集（包括空集[]）
        getsubsets(n,new StringBuilder(),result);
        //删除空集
        result.remove(0);
        return result;
    }
    public void getsubsets(int n, StringBuilder trace, List<String> result){
        if(trace.length() > n) return ;
        result.add(trace.toString());
        //选择列表[0,1,2,3,4,5,6,7,8,9]
        for (int i = 0; i < 10; i++) {
            //剪枝操作：生成子集的时候不能以0为开头，如0,01,02... 012等等
            if(trace.length() == 0 && i == 0) continue;
            //做出选择
            trace.append(i);
            getsubsets(n,trace,result);
            //撤销选择
            trace.deleteCharAt(trace.length()-1);
        }
    }
}
