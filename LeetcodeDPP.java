class Solution {
    public boolean canForm(int a, int b, int c){
        if(a+b>c){
            if(b+c>a){
                if(c+a>b)return true;
            }
        }
        return false;
    }
    public String triangleType(int[] nums) {
        int a=nums[0], b=nums[1], c=nums[2];
        if(canForm(a,b,c)){
            if(a==b && b==c)return "equilateral";
            else if(a==b || b==c || a==c)return "isosceles";
            else return "scalene";
        }
        else return "none";
    }
}