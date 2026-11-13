class GymMember {
 protected String memberId; protected int monthlyFee,sessions; private int[] lateFees=new int[10]; private int feeCount;
 public GymMember(String id,int fee){if(id==null||id.trim().length()<4||fee<=0)throw new IllegalArgumentException("Invalid member");memberId=id;monthlyFee=fee;}
 public void attendSession(){sessions++;} public int getSessionsAttended(){return sessions;}
 public String displayInfo(){return "Standard Member | Sessions: "+sessions;}
 protected void chargeLateFee(int amount){if(amount<=0||feeCount==10)throw new IllegalArgumentException();lateFees[feeCount++]=amount;}
 public int[] getLateFeeHistory(){return java.util.Arrays.copyOf(lateFees,feeCount);}
 public int getTotalLateFees(){int n=0;for(int i=0;i<feeCount;i++)n+=lateFees[i];return n;}
 public void payFee(int amount){monthlyFee-=amount;} public int getFeesPaid(){return monthlyFee;}
}
class PremiumMember extends GymMember {
 private String trainerName;
 public PremiumMember(String id,int fee,String trainer){super(id,fee);trainerName=trainer;}
 public String getTrainerName(){return trainerName;}
 @Override public String displayInfo(){return "Premium | Trainer: "+trainerName+" | Sessions: "+sessions;}
 @Override protected void chargeLateFee(int amount){super.chargeLateFee(amount/2);}
}
class EliteMember extends PremiumMember {private String locker;public EliteMember(String id,int fee,String trainer,String locker){super(id,fee,trainer);this.locker=locker;}@Override public String displayInfo(){return "Elite Member | Trainer: "+getTrainerName()+" | Locker: "+locker+" | Sessions: "+sessions;}}
class GroupClassMember extends GymMember {private String className;public GroupClassMember(String id,int fee,String name){super(id,fee);className=name;}@Override public String displayInfo(){return "Group Class Member | Class: "+className+" | Sessions: "+sessions;}}
public class Problem1_GymMembershipFoundation {
 static String signUpBatch(String[] ids,int fee){int ok=0,bad=0;for(String id:ids)try{new GymMember(id,fee);ok++;}catch(IllegalArgumentException e){bad++;}return "Signed Up: "+ok+" | Rejected: "+bad;}
 static String classifyGeneration(GymMember m){if(m instanceof EliteMember)return "Multilevel descendant (3 generations deep)";if(m instanceof GroupClassMember)return "Hierarchical sibling (independent branch)";if(m instanceof PremiumMember)return "Second generation";return "Base generation";}
 static int getTotalSessionsAttended(GymMember[] ms){int n=0;for(GymMember m:ms)n+=m.getSessionsAttended();return n;}
 static String batchPrint(GymMember[] ms){StringBuilder b=new StringBuilder();for(GymMember m:ms){if(b.length()>0)b.append(" | ");b.append(m.displayInfo());if(m instanceof PremiumMember)b.append(" [Trainer via downcast: ").append(((PremiumMember)m).getTrainerName()).append("]");}return b.toString();}
 public static void main(String[] a){System.out.println(signUpBatch(new String[]{"MEM1","GM1","MEM2"," ","MEM3"},1000));}
}