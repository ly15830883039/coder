package rui.coder.algorithms.leetcode.to_interview_questions_easy.array;

public class RotateArrays {

    public void rotate(int[][] matrix) {
        int x=0;
        int y=matrix.length-1;

        while(x<y){
            rotate(matrix,x++,y--);
        }


    }


    private void rotate(int[][] matrix,int start,int last){

        int x=start;
        int y=last;
        while(x<last){
            int temp=matrix[x][last];
            matrix[x][last]=matrix[start][x];

            int temp2=matrix[last][y];
            matrix[last][y]=temp;

            temp=matrix[y][start];
            matrix[y][start]=temp2;

            matrix[start][x]=temp;

            x++;
            y--;
        }
    }




}
