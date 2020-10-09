package Tree;

import java.text.SimpleDateFormat;
import java.util.*;


 class IntervalTreeNode {
    UnloadingTime unloadingTime = null;
     IntervalTreeNode left = null;
     IntervalTreeNode right = null;

    boolean addWithoutOverlap(UnloadingTime unloadingTime, IntervalTreeNode root){


        if(root.unloadingTime == null){
            root.unloadingTime = unloadingTime;
        } else if(!unloadingTime.getEnd().after(root.unloadingTime.getStart())){
            if(root.left == null) root.left = new IntervalTreeNode();
            addWithoutOverlap(unloadingTime, root.left);
        } else if(!unloadingTime.getStart().before(root.unloadingTime.getEnd())){
            if(root.right == null) root.right = new IntervalTreeNode();
            addWithoutOverlap(unloadingTime, root.right);
        } else{
            return false;
        }
        return true;
    }
}
class UnloadingTrucks {
    public static Boolean canUnloadAll(Collection<UnloadingTime> unloadingTimes) {
        IntervalTreeNode tree = new IntervalTreeNode();

        for( UnloadingTime inputRange: unloadingTimes){
            if(!tree.addWithoutOverlap(inputRange, tree)) return false;
        }
        return true;
    }


    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y H:m");

        ArrayList<UnloadingTime> unloadingTimes = new ArrayList<UnloadingTime>();
        unloadingTimes.add(new UnloadingTime(sdf.parse("03/04/2019 19:00"), sdf.parse("03/04/2019 20:30")));
        unloadingTimes.add(new UnloadingTime(sdf.parse("03/04/2019 22:10"), sdf.parse("03/04/2019 22:30")));
        unloadingTimes.add(new UnloadingTime(sdf.parse("03/04/2019 20:30"), sdf.parse("03/04/2019 22:00")));

        System.out.println(UnloadingTrucks.canUnloadAll(unloadingTimes));
    }
}

class UnloadingTime {
    private Date start, end;

    public UnloadingTime(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return this.start;
    }

    public Date getEnd() {
        return this.end;
    }
}
