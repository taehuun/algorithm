class Solution {
    public String solution(String code) {
        String answer = "";
        StringBuilder ret = new StringBuilder();
        int mode = 0;
        for(int idx = 0; idx < code.length(); idx++){
            char arr = code.charAt(idx);
            if(arr == '1'){
                if(mode==0)
                    mode = 1;
                else
                    mode = 0;
            }
            else{
                if(mode == 0 && idx%2 == 0){
                    ret.append(arr);
                }
                else if(mode == 1 && idx%2 == 1){
                    ret.append(arr);
                }
            }
        }
        if(ret.length() == 0)
            return "EMPTY";
        else
            return ret.toString();
    }
}