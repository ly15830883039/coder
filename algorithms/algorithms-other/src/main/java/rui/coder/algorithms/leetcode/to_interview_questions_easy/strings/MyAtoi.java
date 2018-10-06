package rui.coder.algorithms.leetcode.to_interview_questions_easy.strings;

/**
 * 字符串转整数 (atoi)
 */
class MyAtoi {

    /**
     * 这个解决的问题和题设不同
     */
    int myAtoi2(String str) {
        char[] chars = str.toCharArray();

        char[] numbers = new char[chars.length];
        int length = 0;
        boolean flag = false;
        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9') {
                numbers[length++] = aChar;
            } else {
                if (length == 0) {
                    if (!flag) {
                        if (aChar == '-') {
                            numbers[length++] = aChar;
                            flag = true;
                        }
                    }
                }
            }
        }

        if (length == 0) {
            return 0;
        } else if (length == 1) {
            if (flag) {
                return 0;
            }
        } else if (length > 11) {
            return Integer.MIN_VALUE;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            builder.append(numbers[i]);

        }

        try {
            return Integer.parseInt(builder.toString());
        } catch (Exception e) {
            if (flag) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }


    int myAtoi(String str) {
        char[] chars = str.toCharArray();

        StringBuilder builder = new StringBuilder();
        int flag = 0;
        for (char aChar : chars) {
            if (aChar >= '0' && aChar <= '9') {
                builder.append(aChar);
            } else {
                if(builder.length()==0){
                    if(aChar==' '){

                    }else if(aChar=='-'){
                        builder.append(aChar);
                        flag=1;
                    }else if(aChar=='+'){
                        builder.append(aChar);
                        flag=2;
                    }else {
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        if (builder.length() == 0) {
            return 0;
        } else if (builder.length() == 1&&flag>0) {
            return 0;
        }


        String n = builder.toString();
        try {
            return Integer.parseInt(n);
        } catch (Exception e) {
            if (flag==1) {
                return Integer.MIN_VALUE;
            } else  {
                return Integer.MAX_VALUE;
            }
        }
    }
}
