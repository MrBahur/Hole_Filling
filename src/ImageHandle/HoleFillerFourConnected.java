package ImageHandle;

import NumericFunctions.Function;
import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class HoleFillerFourConnected extends HoleFiller {

    public HoleFillerFourConnected(Function w) {
        super(w);
    }

    @Override
    void findHoleAndBoundary(MyImage image) {
        Set<Pair<Integer, Integer>> hole = image.getHole();
        Set<Pair<Integer, Integer>> boundary = image.getBoundary();
        double[][] imagePixels = image.getImage();
        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
        Pair<Integer,Integer> firstPixelInTheHole = null;
        for (int i = 1; i <imagePixels.length -1 && firstPixelInTheHole==null; i++) {
            for (int j = 1; j <imagePixels[i].length -1 && firstPixelInTheHole==null ; j++) {   //only starting from 1 to length -1 because it is given that the hole is not in the boarder of the picture
                if(imagePixels[i][j]==-1){
                    firstPixelInTheHole = new Pair<>(i,j);
                }
            }
        }
        if(firstPixelInTheHole==null){
            System.out.println("no hole in this picture");
            return;
        }
        q.add(firstPixelInTheHole);
        while (!q.isEmpty()){
            Pair<Integer,Integer> p = q.remove();
            hole.add(p);
            int x = p.getKey();
            int y = p.getValue();
            if(imagePixels[x+1][y+1]==-1)
            {
                Pair pa = new Pair<Integer,Integer>(x+1,y+1);
                if(!q.contains(pa)&&!hole.contains(pa)){
                    q.add(pa);
                }
            }
            if(imagePixels[x+1][y-1]==-1){
                Pair pa = new Pair<Integer,Integer>(x+1,y-1);
                if(!q.contains(pa)&&!hole.contains(pa)){
                    q.add(pa);
                }
            }
            if(imagePixels[x-1][y-1]==-1){
                Pair pa = new Pair<Integer,Integer>(x-1,y-1);
                if(!q.contains(pa)&&!hole.contains(pa)){
                    q.add(pa);
                }
            }
            if(imagePixels[x-1][y+1]==-1){
                Pair pa = new Pair<Integer,Integer>(x-1,y+1);
                if(!q.contains(pa)&&!hole.contains(pa)){
                    q.add(pa);
                }
            }
        }
    }
}
