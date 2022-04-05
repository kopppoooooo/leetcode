package leetcode.editor.cn;//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1815 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution17 {
    public List<String> letterCombinations(String digits) {
        List<String> combinations=new ArrayList<String>();
        if(digits.length()==0){
            return combinations;
        }
        Map<Character,String> phoneMap=new HashMap<Character,String>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        backtrack(combinations,phoneMap,digits,0,new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String>combinations,Map<Character,String>
            phoneMap,String digits,int index,StringBuffer combination){
        if(index==digits.length()){
            combinations.add(combination.toString());
        }else{
            char digit=digits.charAt(index);
            String letters=phoneMap.get(digit);
            int lettersCount=letters.length();
            for(int i=0;i<lettersCount;i++){
                combination.append(letters.charAt(i));
                backtrack(combinations,phoneMap,digits,index+1,
                        combination);
                //一个递归函数已将所有combination加入combinations list中，只需要对最后一个combination做一点小修饰
                // StringBuffer删除最后一个字符，例如下例就是删除最后list格式中自带的","
                // ["ad","ae","af","bd","be","bf","cd","ce","cf"]
                combination.deleteCharAt(index);
            }
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
