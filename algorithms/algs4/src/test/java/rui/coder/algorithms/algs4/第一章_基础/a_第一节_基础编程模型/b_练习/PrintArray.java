package rui.coder.algorithms.algs4.第一章_基础.a_第一节_基础编程模型.b_练习;

import java.security.InvalidParameterException;
import java.util.List;

public class PrintArray {

    /**
     * 行名称
     */

    private List<String> rowNames;

    /**
     * 列名称
     */

    private List<String> rankNames;

    /**
     * 行长
     */
    private int rowLength;
    /**
     * 列长
     */
    private int rankLength;


    private List<List<String>> arrays;

    private StringBuilder builder=new StringBuilder();

    private int maxLength =1;

    private int rankIndexLength=2;


    public PrintArray(List<List<String>> arrays,List<String> rowNames, List<String> rankNames) {
        this(arrays);
        this.rowNames = rowNames;
        this.rankNames = rankNames;
    }

    public PrintArray(List<List<String>> arrays) {
        this.arrays = arrays;
        if(arrays==null){
            throw new InvalidParameterException("入参数组为 null");
        }
        this.rankLength=arrays.size();
        if(rankLength<=0){
            throw new InvalidParameterException("入参数组 大小为0 ");
        }
        this.rowLength= arrays.get(0).size();
    }

    public String print(){
        getMaxLength();
        getRankMaxLength();

        appendRowNumber();
        appendRowBarrier();

        for (int i = 0; i < rowLength; i++) {
            builder.append(i+1)
                    .append("|");
            for (int j = 0; j < rankLength; j++) {
                builder.append(arrays.get(i).get(j))
                        .append("  ");
            }
            builder.append("\r\n");
        }
        return builder.toString();
    }

    private void getRankMaxLength() {
        if(rankNames!=null &&rankNames.size()!=0){
            for (String rankName : rankNames) {
                int length=rankName.length();
                if(rankIndexLength<length){
                    rankIndexLength=length;
                }
            }
        }
    }

    private void getMaxLength(){
        for (int i = 0; i < rankLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                int length=arrays.get(i).get(j).length();
                if(maxLength<length){
                    maxLength=length;
                }
            }
        }
        if(rowNames!=null &&rowNames.size()!=0){
            for (String rowName : rowNames) {
                int length = rowName.length();
                if (maxLength < length) {
                    maxLength = length;
                }
            }
        }
    }

    private void appendRowBarrier() {
        for (int i = 0; i < rankLength; i++) {
            builder.append("  -");
        }
        builder.append("\r\n");
    }
    private void appendRowNumber() {
        builder.append(getEmptyString((rowLength+"").length()+1));
        builder=appendEmpty(0,maxLength/2);
        for (int i = 1; i < rankLength; i++) {
            appendEmpty(i,maxLength+2);
        }
        builder.append("\r\n");
    }

    private StringBuilder appendEmpty(int rowIndex,int emptySize){
        String rowName=getRowName(rowIndex);
        int length=emptySize-rowIndex;
        builder.append(getEmptyString(length))
                .append(rowName);
        return builder;
    }

    public String getRowName(int index){
        if(rankNames==null||rankNames.size()==0){
            return "行"+(index+1);
        }
        String rowName =rankNames.get(index);
        if(rowName ==null|| rowName.length()==0){
            return "行"+(index+1);
        }else{
            return rowName;
        }
    }

    public static String getEmptyString(int length){
        char[] chars=new char[length];
        for (int i = 0; i < length; i++) {
            chars[i]=' ';
        }
        return new String(chars);
    }
}
