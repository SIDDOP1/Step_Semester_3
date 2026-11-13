import java.util.Locale;
public class Problem4_ClassMarksGridAnalysis {
    static void analyze(String[] names,int[][] marks) {
        if(names==null||marks==null||names.length==0||names.length!=marks.length)throw new IllegalArgumentException("Invalid class data");
        double[] sums=new double[3];int topper=0,highest=Integer.MIN_VALUE;
        System.out.print("Totals ");
        for(int i=0;i<marks.length;i++) {
            if(marks[i]==null||marks[i].length!=3)throw new IllegalArgumentException("Each student needs 3 subject marks");
            int total=0;
            for(int j=0;j<3;j++){if(marks[i][j]<0||marks[i][j]>100)throw new IllegalArgumentException("Marks must be 0..100");total+=marks[i][j];sums[j]+=marks[i][j];}
            if(i>0)System.out.print(", ");System.out.print(names[i]+" "+total);
            if(total>highest){highest=total;topper=i;}
        }
        System.out.println();
        System.out.printf(Locale.US,"averages %.2f, %.2f, %.2f%n",sums[0]/marks.length,sums[1]/marks.length,sums[2]/marks.length);
        System.out.println("topper "+names[topper]+" ("+highest+")");
    }
    public static void main(String[] args){analyze(new String[]{"Asha","Ravi","Neha"},new int[][]{{78,85,90},{88,92,79},{65,70,95}});}
}
// Time O(students * 3); additional space O(1) because there are exactly 3 subjects.