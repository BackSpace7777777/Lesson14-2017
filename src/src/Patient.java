package src;
public class Patient {
    private String name;
    private int priority;
    private boolean isBeingTreated,doneTreatment;
    private long startTime,treatmentTime;
    public Patient(String name,int priority)
    {
        this.name=name;
        this.priority=priority;
        isBeingTreated=false;
        startTime=-1;
        treatmentTime=(long)(Math.random()*100000)+5000;
        doneTreatment=false;
    }
    public String getName()
    {
        return name;
    }
    public int getPriority()
    {
        return priority;
    }
    public boolean isBeingTreated()
    {
        return isBeingTreated;
    }
    public long getStartTime()
    {
        return startTime;
    }
    public boolean checkCompletion()
    {
        if((System.currentTimeMillis()-startTime)>treatmentTime && isBeingTreated)
        {
            doneTreatment=true;
            isBeingTreated=false;
            return true;
        }
        else if(doneTreatment)return true;
        return false;
    }
    public void treat()
    {
        doneTreatment=true;
    }
    public long getTreatmentTime()
    {
        return treatmentTime;
    }
    public boolean isCompleted()
    {
        return doneTreatment;
    }
    public void startTreatment()
    {
        startTime=System.currentTimeMillis();
        isBeingTreated=true;
    }
    @Override
    public String toString()
    {
        String out=name;
        switch (priority) {
            case 0:
                out+="\tCritical Condition";
                break;
            case 1:
                out+="\tSerious Condition";
                break;
            case 2:
                out+="\tFair Condition\t";
                break;
            default:
                break;
        }
        if(!doneTreatment)out+="\tis waiting";
        else out+="\thad treatment";
        return out;
    }
}
