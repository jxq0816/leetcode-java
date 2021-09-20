package no71_simplifyPath;

public class Solution {
    public String simplifyPath(String path) {
        if(path.startsWith("/..")){
            path=path.substring(3);
        }
        path=path.replaceAll("/(!/)*/\\.\\.","/");//向上一级
        while(path.charAt(path.length()-1)=='/'&&path.length()!=1){
            path=path.substring(0,path.length()-1);
        }
        path=path.replaceAll("/{2,}","/");
        path=path.replaceAll("/\\.","");
        return path;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        //System.out.println(solution.simplifyPath("/home/"));
        System.out.println(solution.simplifyPath("/../"));
        //System.out.println(solution.simplifyPath("/home//foo/"));
        //System.out.println(solution.simplifyPath("/a/./b/../../c/"));
        System.out.println(solution.simplifyPath("/a//b////c/d//././/.."));
        System.out.println(solution.simplifyPath("/a/./b/../../c/"));
    }
}
