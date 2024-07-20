package in.ushatech.dsa;

class Solution {
    private void removeUtil(StringBuilder str, int n) {
        int len = str.length();
        int k = 0;

        for (int i = 0; i < n; i++) {
            if (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                    i++;
                }
            } else {
                str.setCharAt(k++, str.charAt(i));
            }
        }
        str.setLength(k);
        if (k != n) {
            removeUtil(str, k);
        }
    }

    public String rremove(String s) {
        StringBuilder sb = new StringBuilder(s);
        removeUtil(sb, sb.length());
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(new Solution().rremove("geeksforgeeks"));
    }
}
